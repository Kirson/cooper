package com.cooper.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cooper.entities.Cuenta;

public class TransferenciaVO implements Serializable {

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = -2773925815224799485L;
	private Cuenta origen;
	private Cuenta destino;
	private Double monto;
	private String descripcion;
	private Date fecha;
	private List<String> mensajesError;
	private String resultado;
	
	public TransferenciaVO(){
		mensajesError = new ArrayList<String>();
	}

	public Cuenta getOrigen() {
		return origen;
	}

	public void setOrigen(Cuenta origen) {
		this.origen = origen;
	}

	public Cuenta getDestino() {
		return destino;
	}

	public void setDestino(Cuenta destino) {
		this.destino = destino;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<String> getMensajesError() {
		return mensajesError;
	}

	public void setMensajesError(List<String> mensajesError) {
		this.mensajesError = mensajesError;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
	
	
}
