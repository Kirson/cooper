package com.cooper.services.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooper.entities.Cliente;
import com.cooper.entities.Cuenta;
import com.cooper.services.CuentaService;

@RestController
@RequestMapping(value = "/api/cuenta")
public class CuentaController {

	@Autowired
	private CuentaService cuentaService;

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public ResponseEntity<List<Cuenta>> findAll() {

		List<Cuenta> found = cuentaService.findAll();

		if (found != null && !found.isEmpty()) {
			return new ResponseEntity<List<Cuenta>>(found, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Cuenta>>(new ArrayList<Cuenta>(), HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/findByCliente", method = RequestMethod.GET)
	public ResponseEntity<List<Cuenta>> findByCliente(@RequestBody Cliente cliente) {

		List<Cuenta> found = cuentaService.findByCliente(cliente);

		if (found != null && !found.isEmpty()) {
			return new ResponseEntity<List<Cuenta>>(found, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Cuenta>>(new ArrayList<Cuenta>(), HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<Cuenta> save(@RequestBody Cuenta cuenta) {

		Cuenta csave = cuentaService.save(cuenta);

		return new ResponseEntity<Cuenta>(csave, HttpStatus.OK);

	}
}
