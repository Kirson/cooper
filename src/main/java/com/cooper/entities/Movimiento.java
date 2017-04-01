package com.cooper.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the movimientos database table.
 * 
 */
@Entity
@Table(name="movimientos")
@NamedQuery(name="Movimiento.findAll", query="SELECT m FROM Movimiento m")
public class Movimiento implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String descripcion;
	private Date fechaMovimiento;
	private BigDecimal monto;
	private Catalogo tipo;
	private Catalogo tipoPago;
	private Cuenta cuentaDestino;
	private Cuenta cuentaOrigen;

	public Movimiento() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="fecha_movimiento")
	public Date getFechaMovimiento() {
		return this.fechaMovimiento;
	}

	public void setFechaMovimiento(Date fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}


	public BigDecimal getMonto() {
		return this.monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}


	//bi-directional many-to-one association to Catalogo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_tipo_movimiento")
	public Catalogo getTipo() {
		return this.tipo;
	}

	public void setTipo(Catalogo tipo) {
		this.tipo = tipo;
	}


	//bi-directional many-to-one association to Catalogo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_tipo_pago")
	public Catalogo getTipoPago() {
		return this.tipoPago;
	}

	public void setTipoPago(Catalogo tipoPago) {
		this.tipoPago = tipoPago;
	}


	//bi-directional many-to-one association to Cuenta
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_cuenta_destino")
	public Cuenta getCuentaDestino() {
		return this.cuentaDestino;
	}

	public void setCuentaDestino(Cuenta cuenta) {
		this.cuentaDestino = cuenta;
	}


	//bi-directional many-to-one association to Cuenta
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_cuenta_origen")
	public Cuenta getCuentaOrigen() {
		return this.cuentaOrigen;
	}

	public void setCuentaOrigen(Cuenta cuenta) {
		this.cuentaOrigen = cuenta;
	}

}