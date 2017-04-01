package com.cooper.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooper.entities.Catalogo;
import com.cooper.repository.CatalogoRepository;

@Service
public class CatalogoService {

	@Autowired
	private CatalogoRepository catalogoRepository;
	
	public List<Catalogo> findAll(){
		return catalogoRepository.findAll();
	}
	
	public List<Catalogo> findByPadre(Catalogo padre){
		return catalogoRepository.findByPadre(padre);
	}
	
	public Catalogo findByNemonico(String nemonico){
		return catalogoRepository.findByNemonico(nemonico);
	}
	
}
