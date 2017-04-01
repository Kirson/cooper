package com.cooper.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the catalogo database table.
 * 
 */
@Entity
@NamedQuery(name="Catalogo.findAll", query="SELECT c FROM Catalogo c")
public class Catalogo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nemonico;
	private String nombre;
	private String valor;
	private Catalogo padre;
	private List<Catalogo> catalogos;
	

	public Catalogo() {
		catalogos = new ArrayList<Catalogo>();
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getNemonico() {
		return this.nemonico;
	}

	public void setNemonico(String nemonico) {
		this.nemonico = nemonico;
	}


	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}


	//bi-directional many-to-one association to Catalogo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_padre")
	public Catalogo getPadre() {
		return this.padre;
	}

	public void setPadre(Catalogo catalogo) {
		this.padre = catalogo;
	}


	//bi-directional many-to-one association to Catalogo
	@OneToMany(mappedBy="padre")
	public List<Catalogo> getCatalogos() {
		return this.catalogos;
	}

	public void setCatalogos(List<Catalogo> catalogos) {
		this.catalogos = catalogos;
	}

	public Catalogo addCatalogo(Catalogo catalogo) {
		getCatalogos().add(catalogo);
		catalogo.setPadre(this);

		return catalogo;
	}

	public Catalogo removeCatalogo(Catalogo catalogo) {
		getCatalogos().remove(catalogo);
		catalogo.setPadre(null);

		return catalogo;
	}


	

	
}