package com.cooper.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cuenta database table.
 * 
 */
@Entity
@NamedQuery(name="Cuenta.findAll", query="SELECT c FROM Cuenta c")
public class Cuenta implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String descripcion;
	private Date fechaApertura;
	private Date fechaUltimoMovimiento;
	private BigDecimal saldo;
	private Catalogo catalogo;
	private Cliente cliente;
	private List<Movimiento> movimientos1;
	private List<Movimiento> movimientos2;

	public Cuenta() {
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
	@Column(name="fecha_apertura")
	public Date getFechaApertura() {
		return this.fechaApertura;
	}

	public void setFechaApertura(Date fechaApertura) {
		this.fechaApertura = fechaApertura;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="fecha_ultimo_movimiento")
	public Date getFechaUltimoMovimiento() {
		return this.fechaUltimoMovimiento;
	}

	public void setFechaUltimoMovimiento(Date fechaUltimoMovimiento) {
		this.fechaUltimoMovimiento = fechaUltimoMovimiento;
	}


	public BigDecimal getSaldo() {
		return this.saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}


	//bi-directional many-to-one association to Catalogo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_tipo_cuenta")
	public Catalogo getCatalogo() {
		return this.catalogo;
	}

	public void setCatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
	}


	//bi-directional many-to-one association to Cliente
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_propietario")
	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	//bi-directional many-to-one association to Movimiento
	@OneToMany(mappedBy="cuentaDestino")
	public List<Movimiento> getMovimientos1() {
		return this.movimientos1;
	}

	public void setMovimientos1(List<Movimiento> movimientos1) {
		this.movimientos1 = movimientos1;
	}

	public Movimiento addMovimientos1(Movimiento movimientos1) {
		getMovimientos1().add(movimientos1);
		movimientos1.setCuentaDestino(this);

		return movimientos1;
	}

	public Movimiento removeMovimientos1(Movimiento movimientos1) {
		getMovimientos1().remove(movimientos1);
		movimientos1.setCuentaDestino(null);

		return movimientos1;
	}


	//bi-directional many-to-one association to Movimiento
	@OneToMany(mappedBy="cuentaOrigen")
	public List<Movimiento> getMovimientos2() {
		return this.movimientos2;
	}

	public void setMovimientos2(List<Movimiento> movimientos2) {
		this.movimientos2 = movimientos2;
	}

	public Movimiento addMovimientos2(Movimiento movimientos2) {
		getMovimientos2().add(movimientos2);
		movimientos2.setCuentaOrigen(this);

		return movimientos2;
	}

	public Movimiento removeMovimientos2(Movimiento movimientos2) {
		getMovimientos2().remove(movimientos2);
		movimientos2.setCuentaOrigen(null);

		return movimientos2;
	}

}