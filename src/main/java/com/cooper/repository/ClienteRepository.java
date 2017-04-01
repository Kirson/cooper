package com.cooper.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooper.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {

	public List<Cliente> findAll();
	public List<Cliente> findByDocumento(String documento);
}
