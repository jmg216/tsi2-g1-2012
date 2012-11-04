package com.geored.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="administrador")
public class Administrador implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3229972234019860115L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID", nullable=false)
	private Long id;
	
	@Column(name="EMAIL", nullable=false)
	private String email;
	
	@Column(name="PASS", nullable=false)
	private String pass;
	
	@Column(name="NOMBRE", nullable=false)
	private String nombre;

	@JoinColumn(name="TIPO_ADMINISTRADOR_FK", nullable=false)
	@ManyToOne(fetch=FetchType.EAGER)
	private TipoAdministrador tipoAdministrador;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public TipoAdministrador getTipoAdministrador()
	{
		return tipoAdministrador;
	}

	public void setTipoAdministrador(TipoAdministrador tipoAdministrador)
	{
		this.tipoAdministrador = tipoAdministrador;
	}

	public String getPass()
	{
		return pass;
	}

	public void setPass(String pass)
	{
		this.pass = pass;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}
}