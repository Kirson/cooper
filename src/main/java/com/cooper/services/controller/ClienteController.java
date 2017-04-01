package com.cooper.services.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooper.entities.Cliente;
import com.cooper.entities.Usuario;
import com.cooper.services.ClienteService;

@RestController
@RequestMapping(value = "/api/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public  ResponseEntity<List<Cliente>> findAll(){
		
		List<Cliente> found = clienteService.findAll();
	
	    if(found!=null && !found.isEmpty()){
	    	return new ResponseEntity<List<Cliente>>(found, HttpStatus.OK);
	    }else{
	    	return new ResponseEntity<List<Cliente>>(new ArrayList<Cliente>(),HttpStatus.OK);
	    }
	}
	
	@RequestMapping(value = "/findByDocumento/{documento}", method = RequestMethod.GET)
	public  ResponseEntity<Cliente> findByDocumento(@PathVariable("documento")String documento){
		
		Cliente found = clienteService.findByDocumento(documento);

	    return new ResponseEntity<Cliente>(found, HttpStatus.OK);
	   
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {

		Cliente csave = clienteService.save(cliente);

		return new ResponseEntity<Cliente>(csave, HttpStatus.OK);

	}
}
