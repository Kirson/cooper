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

import com.cooper.entities.Cuenta;
import com.cooper.entities.Movimiento;
import com.cooper.services.MovimientoService;

@RestController
@RequestMapping(value = "/api/movimiento")
public class MovimientoController {

	@Autowired
	private MovimientoService movimientoService;
	
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public ResponseEntity<List<Movimiento>> findAll() {

		List<Movimiento> found = movimientoService.findAll();

		if (found != null && !found.isEmpty()) {
			return new ResponseEntity<List<Movimiento>>(found, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Movimiento>>(new ArrayList<Movimiento>(), HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/findByCuentaOrigen", method = RequestMethod.GET)
	public ResponseEntity<List<Movimiento>> findByCuentaOrigen( @RequestBody Cuenta cuentaOrigen) {

		List<Movimiento> found = movimientoService.findByCuentaOrigen(cuentaOrigen);

		if (found != null && !found.isEmpty()) {
			return new ResponseEntity<List<Movimiento>>(found, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Movimiento>>(new ArrayList<Movimiento>(), HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/findByCuentaDestino", method = RequestMethod.GET)
	public ResponseEntity<List<Movimiento>> findByCuentaDestino(@RequestBody Cuenta cuentaDestino) {

		List<Movimiento> found = movimientoService.findByCuentaDestino(cuentaDestino);

		if (found != null && !found.isEmpty()) {
			return new ResponseEntity<List<Movimiento>>(found, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Movimiento>>(new ArrayList<Movimiento>(), HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<Movimiento> save(@RequestBody Movimiento movimiento) {

		Movimiento msave = movimientoService.save(movimiento);

		return new ResponseEntity<Movimiento>(msave, HttpStatus.OK);

	}
}
