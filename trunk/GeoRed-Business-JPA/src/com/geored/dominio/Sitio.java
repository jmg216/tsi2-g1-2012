package com.geored.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="sitio")
public class Sitio implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2388324649793497036L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false)
	private Long id;
	
	@Column(name="NOMBRE", nullable=false)
	private String nombre;
	
	@Column(name="DESCRIPCION", nullable=false)
	private String descripcion;

	@Column(name="UBICACION_GEOGRAFICA", nullable=false)
	private String ubicacionGeografica;
	
	@JoinColumn(name="ADMINISTRADOR_FK", nullable=false)
	private Administrador administrador;
	
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

	public Administrador getAdministrador()
	{
		return administrador;
	}

	public void setAdministrador(Administrador administrador)
	{
		this.administrador = administrador;
	}

	public String getDescripcion()
	{
		return descripcion;
	}

	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}

	public String getUbicacionGeografica()
	{
		return ubicacionGeografica;
	}

	public void setUbicacionGeografica(String ubicacionGeografica)
	{
		this.ubicacionGeografica = ubicacionGeografica;
	}
}