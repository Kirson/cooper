package com.cooper.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooper.entities.Catalogo;
import com.cooper.entities.Cuenta;
import com.cooper.entities.Movimiento;
import com.cooper.repository.MovimientoRepository;

@Service
public class MovimientoService {

	@Autowired
	private MovimientoRepository movimientoRepository;
	
	public List<Movimiento> findAll(){
		return movimientoRepository.findAll();
	}
	
	public List<Movimiento> findByCuentaOrigen(Cuenta cuentaOrigen){
		return movimientoRepository.findByCuentaOrigen(cuentaOrigen);
	}
	
	public List<Movimiento> findByCuentaDestino(Cuenta cuentaDestino){
		return movimientoRepository.findByCuentaDestino(cuentaDestino);
	}
	
	public List<Movimiento> findByTipo(Catalogo tipo){
		return movimientoRepository.findByTipo(tipo);
	}
	
	public List<Movimiento> findByTipoPago(Catalogo tipoPago){
		return movimientoRepository.findByTipoPago(tipoPago);
	}
	
	
}
