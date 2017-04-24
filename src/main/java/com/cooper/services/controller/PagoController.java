package com.cooper.services.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooper.services.PagoService;
import com.cooper.vo.PagoVO;


@RestController
@RequestMapping(value = "/api/pago")
public class PagoController {

	@Autowired
	private PagoService pagoService;
	
	@RequestMapping(value = "/realizarPago", method = RequestMethod.POST)
	public ResponseEntity<PagoVO> realizarPago(@RequestBody PagoVO data) {

		PagoVO mPago = pagoService.realizarPago(data);

		return new ResponseEntity<PagoVO>(mPago, HttpStatus.OK);

	}
}
