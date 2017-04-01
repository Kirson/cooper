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

import com.cooper.entities.Usuario;
import com.cooper.services.UsuarioService;
import com.cooper.vo.CredentialsVO;

@RestController
@RequestMapping(value = "/api/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> findAll() {

		List<Usuario> found = usuarioService.findAll();

		if (found != null && !found.isEmpty()) {
			return new ResponseEntity<List<Usuario>>(found, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Usuario>>(new ArrayList<Usuario>(), HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<Usuario> save(@RequestBody Usuario usuario) {

		Usuario usave = usuarioService.save(usuario);

		return new ResponseEntity<Usuario>(usave, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public ResponseEntity<Usuario> auth(@RequestBody CredentialsVO credentials) {

		Usuario usave = usuarioService.findUsuario(credentials);

		return new ResponseEntity<Usuario>(usave, HttpStatus.OK);

	}
}
