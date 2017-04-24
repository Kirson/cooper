package com.cooper.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooper.entities.Cuenta;
import com.cooper.entities.Movimiento;
import com.cooper.repository.CuentaRepository;
import com.cooper.repository.MovimientoRepository;
import com.cooper.vo.TransferenciaVO;

@Service
public class TransferenciaService {

	@Autowired
	private MovimientoRepository movimientoRepository;

	@Autowired
	private CuentaRepository cuentaRepository;

	@Transactional
	public TransferenciaVO realizarTransferencia(TransferenciaVO data) {

		String resultado = "OK";

		if (data.getOrigen() == null) {
			resultado = "ERROR";
			data.getMensajesError().add("Cuenta origen es requerida");
		}
		if (data.getDestino() == null) {
			resultado = "ERROR";
			data.getMensajesError().add("Cuenta destino es requerida");
		}
		if (data.getMonto() == null) {
			resultado = "ERROR";
			data.getMensajesError().add("Monto es requerido");
		}

		// Reconsultar datos de fondos en el momento de transferir
		List<Cuenta> qOrigen = cuentaRepository.findByNumeroCuenta(data.getOrigen().getNumeroCuenta());
		Cuenta cOrigen = data.getOrigen();

		if (qOrigen != null && !qOrigen.isEmpty()) {
			cOrigen = qOrigen.get(0);
		} else {
			resultado = "ERROR";
			data.getMensajesError().add("Problemas recuperando informacion de cuenta origen");
		}

		if (data.getMonto().doubleValue() > cOrigen.getSaldo().doubleValue()) {
			resultado = "ERROR";
			data.getMensajesError().add("Saldo insuficiente en cuenta origen");
		}

		// Reconsultar datos de cuenta destino
		List<Cuenta> qDestino = cuentaRepository.findByNumeroCuenta(data.getDestino().getNumeroCuenta());
		Cuenta cDestino = data.getDestino();

		if (qDestino != null && !qDestino.isEmpty()) {
			cDestino = qDestino.get(0);
		} else {
			resultado = "ERROR";
			data.getMensajesError().add("Problemas recuperando informacion de cuenta destino");
		}

		if (resultado.equals("OK")) {
			Date fechaUltimoMovimiento = new Date();

			BigDecimal saldoOrigen = new BigDecimal(cOrigen.getSaldo().doubleValue() - data.getMonto().doubleValue());

			cOrigen.setSaldo(saldoOrigen);
			cOrigen.setFechaUltimoMovimiento(fechaUltimoMovimiento);

			BigDecimal saldoDestino = new BigDecimal(cDestino.getSaldo().doubleValue() + data.getMonto().doubleValue());

			cDestino.setSaldo(saldoDestino);
			cDestino.setFechaUltimoMovimiento(fechaUltimoMovimiento);

			cuentaRepository.save(cOrigen);
			cuentaRepository.save(cDestino);

			Movimiento movimiento = new Movimiento();

			movimiento.setCuentaOrigen(cOrigen);
			movimiento.setCuentaDestino(cDestino);
			movimiento.setDescripcion("Transferencia");
			movimiento.setMonto(new BigDecimal(data.getMonto().doubleValue()));
			movimiento.setFechaMovimiento(fechaUltimoMovimiento);

			movimientoRepository.save(movimiento);
		}
		
		data.setResultado(resultado);

		return data;
	}
}
