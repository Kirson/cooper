package com.cooper.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooper.entities.Catalogo;

public interface CatalogoRepository extends JpaRepository<Catalogo, Long>  {

	public List<Catalogo> findAll();
	public List<Catalogo> findByPadre(Catalogo padre);
	public Catalogo findByNemonico(String nemonico);
}
