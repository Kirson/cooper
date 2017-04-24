package com.cooper.services.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooper.services.TransferenciaService;
import com.cooper.vo.TransferenciaVO;

@RestController
@RequestMapping(value = "/api/transferencia")
public class TransferenciaController {

	@Autowired
	private TransferenciaService transferenciaService;
	
	@RequestMapping(value = "/realizarTransferencia", method = RequestMethod.POST)
	public ResponseEntity<TransferenciaVO> realizarTransferencia(@RequestBody TransferenciaVO data) {

		TransferenciaVO mTrans = transferenciaService.realizarTransferencia(data);

		return new ResponseEntity<TransferenciaVO>(mTrans, HttpStatus.OK);

	}
}
