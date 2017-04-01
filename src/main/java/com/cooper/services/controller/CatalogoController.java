package com.cooper.services.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooper.entities.Catalogo;
import com.cooper.services.CatalogoService;

@RestController
@RequestMapping(value = "/api/catalogo")
public class CatalogoController {

	@Autowired
	private CatalogoService catalogoService;
	
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public  ResponseEntity<List<Catalogo>> findAll(){
		
		List<Catalogo> found = catalogoService.findAll();
	
	    if(found!=null && !found.isEmpty()){
	    	return new ResponseEntity<List<Catalogo>>(found, HttpStatus.OK);
	    }else{
	    	return new ResponseEntity<List<Catalogo>>(new ArrayList<Catalogo>(),HttpStatus.OK);
	    }
	}
	
	@RequestMapping(value = "/findByNemonico/{nemonico}", method = RequestMethod.GET)
	public  ResponseEntity<Catalogo> findByNemonico(@PathVariable("nemonico")String nemonico){
		
		Catalogo found = catalogoService.findByNemonico(nemonico);
	
	    if(found!=null ){
	    	return new ResponseEntity<Catalogo>(found, HttpStatus.OK);
	    }else{
	    	return new ResponseEntity<Catalogo>(new Catalogo(),HttpStatus.OK);
	    }
	}
}
