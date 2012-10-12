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
@Table(name="check_in")
class CheckIn implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 595575847837079673L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID", nullable=false)
	private Long id;
	
	@Column(name="NOMBRE", nullable=false)
	private String nombre;

	@JoinColumn(name="USUARIO_FK", nullable=false)
	@ManyToOne(fetch=FetchType.LAZY)
	private Usuario usuario;
	
	@JoinColumn(name="SITIO_FK", nullable=false)
	@ManyToOne(fetch=FetchType.LAZY)
	private Sitio sitio;
	
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

	public Usuario getUsuario()
	{
		return usuario;
	}

	public void setUsuario(Usuario usuario)
	{
		this.usuario = usuario;
	}

	public Sitio getSitio()
	{
		return sitio;
	}

	public void setSitio(Sitio sitio)
	{
		this.sitio = sitio;
	}
}