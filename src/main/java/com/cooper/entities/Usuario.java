package com.cooper.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String email;
	private Date fechaCreacion;
	private String nick;
	private String password;
	private Boolean status;
	private List<Cliente> clientes;
	private Catalogo catalogo;
	
	@Transient
	private Boolean isValid;

	public Usuario() {
		isValid=true;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="fecha_creacion")
	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	public String getNick() {
		return this.nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}


	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}


	//bi-directional many-to-one association to Cliente
	@OneToMany(mappedBy="usuario")
	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente addCliente(Cliente cliente) {
		getClientes().add(cliente);
		cliente.setUsuario(this);

		return cliente;
	}

	public Cliente removeCliente(Cliente cliente) {
		getClientes().remove(cliente);
		cliente.setUsuario(null);

		return cliente;
	}


	//bi-directional many-to-one association to Catalogo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_tipo_usuario")
	public Catalogo getCatalogo() {
		return this.catalogo;
	}

	public void setCatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
	}

	@Transient
	public Boolean getIsValid() {
		return isValid;
	}

	@Transient
	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}

	
}