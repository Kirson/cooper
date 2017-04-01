package com.cooper.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cooper.entities.Cliente;
import com.cooper.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public List<Cliente> findAll(){
		return clienteRepository.findAll();
	}
	
	public Cliente findByDocumento(String documento){
		
		List<Cliente> query = clienteRepository.findByDocumento(documento);
		
		if(query!=null && !query.isEmpty()){
			return query.get(0);
		}else{
			return null;
		}
	}
	
	public Cliente save(Cliente cliente){
		return clienteRepository.save(cliente);
	}

}
