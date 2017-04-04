package com.cooper.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooper.entities.Cliente;
import com.cooper.entities.Cuenta;
import com.cooper.repository.CuentaRepository;

@Service
public class CuentaService {

	@Autowired
	private CuentaRepository cuentaRepository;
	
	public List<Cuenta> findAll(){
		return cuentaRepository.findAll();
	}
	
	public List<Cuenta> findByCliente(Cliente cliente){
		return cuentaRepository.findByCliente(cliente);
	}
	
	public Cuenta save(Cuenta cuenta){
		return cuentaRepository.save(cuenta);
	}
	
}
