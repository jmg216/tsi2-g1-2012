package com.geored.dominio;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

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
public class CheckIn implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 595575847837079673L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false)
	private Long id;
	
	@Column(name="NOMBRE", nullable=false)
	private String nombre;
	
	@Column(name="FECHA_CREACION", nullable=false)
	private Timestamp fechaCreacion;
	
	@JoinColumn(name="USUARIO_FK", nullable=false)
	@ManyToOne(fetch=FetchType.EAGER)
	private Usuario usuario;
	
	@JoinColumn(name="SITIO_FK", nullable=false)
	@ManyToOne(fetch=FetchType.EAGER)
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

	public Timestamp getFechaCreacion()
	{
		return fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion)
	{
		this.fechaCreacion = fechaCreacion;
	}
}