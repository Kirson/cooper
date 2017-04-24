package com.cooper.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooper.entities.Cliente;
import com.cooper.entities.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta,Long> {

	public List<Cuenta> findAll();
	public List<Cuenta> findByCliente(Cliente cliente);
	public List<Cuenta> findByNumeroCuenta(String numeroCuenta);
}
