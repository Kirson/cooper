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
import com.cooper.vo.PagoVO;

@Service
public class PagoService {

	@Autowired
	private MovimientoRepository movimientoRepository;

	@Autowired
	private CuentaRepository cuentaRepository;

	@Transactional
	public PagoVO realizarPago(PagoVO data) {

		String resultado = "OK";

		if (data.getCuenta() == null) {
			resultado = "ERROR";
			data.getMensajesError().add("Cuenta es requerida");
		}

		if (data.getTipoPago() == null) {
			resultado = "ERROR";
			data.getMensajesError().add("Tipo de Pago es requerido");
		}

		// Reconsultar datos de fondos en el momento de transferir
		List<Cuenta> qOrigen = cuentaRepository.findByNumeroCuenta(data.getCuenta().getNumeroCuenta());
		Cuenta cOrigen = data.getCuenta();

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
		
		if (resultado.equals("OK")) {
			Date fechaUltimoMovimiento = new Date();

			BigDecimal saldoOrigen = new BigDecimal(cOrigen.getSaldo().doubleValue() - data.getMonto().doubleValue());

			cOrigen.setSaldo(saldoOrigen);
			cOrigen.setFechaUltimoMovimiento(fechaUltimoMovimiento);
			
			cuentaRepository.save(cOrigen);
			
			Movimiento movimiento = new Movimiento();

			movimiento.setCuentaOrigen(cOrigen);
			movimiento.setTipoPago(data.getTipoPago());
			movimiento.setDescripcion("Pago");
			movimiento.setMonto(new BigDecimal(data.getMonto().doubleValue()));
			movimiento.setFechaMovimiento(fechaUltimoMovimiento);

			movimientoRepository.save(movimiento);
		
		}

		data.setResultado(resultado);
		return data;
	}
}
