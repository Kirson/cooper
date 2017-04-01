package com.cooper.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooper.entities.Catalogo;
import com.cooper.entities.Cuenta;
import com.cooper.entities.Movimiento;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long>{

	public List<Movimiento> findAll();
	public List<Movimiento> findByTipo(Catalogo tipo);
	public List<Movimiento> findByTipoPago(Catalogo tipoPago);
	public List<Movimiento> findByCuentaOrigen(Cuenta cuentaOrigen);
	public List<Movimiento> findByCuentaDestino(Cuenta cuentaDestino);
}
