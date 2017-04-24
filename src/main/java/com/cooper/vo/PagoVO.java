package com.cooper.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cooper.entities.Catalogo;
import com.cooper.entities.Cuenta;

/**
 * 
 * @author cherrera
 *
 */
public class PagoVO implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1713223934584127921L;
	private Cuenta cuenta;
	private Catalogo tipoPago;
	private Double monto;
	private String descripcion;
	private Date fecha;
	private List<String> mensajesError;
	private String resultado;
	
	public PagoVO(){
		mensajesError = new ArrayList<String>();
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public Catalogo getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(Catalogo tipoPago) {
		this.tipoPago = tipoPago;
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<String> getMensajesError() {
		return mensajesError;
	}

	public void setMensajesError(List<String> mensajesError) {
		this.mensajesError = mensajesError;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
	
}
