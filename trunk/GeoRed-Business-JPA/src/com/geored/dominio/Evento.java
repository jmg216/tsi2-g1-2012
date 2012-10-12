package com.geored.dominio;

import java.io.Serializable;
import java.sql.Timestamp;

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
@Table(name="evento")
public class Evento implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7607595252285552941L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="NOMBRE", nullable=false)
	private String nombre;
	
	@Column(name="DESCRIPCION", nullable=false)
	private String descripcion;
	
	@Column(name="UBICACION_GEOGRAFICA", nullable=false)
	private String ubicacionGeografica;
	
	@Column(name="FECHA_INICIO", nullable=false)
	private Timestamp fechaInicio;
	
	@Column(name="FECHA_FIN", nullable=false)
	private Timestamp fechaFin;
	
	@JoinColumn(name="ADMINISTRADOR_FK", nullable=false)
	@ManyToOne(fetch=FetchType.LAZY)
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

	public Timestamp getFechaInicio()
	{
		return fechaInicio;
	}

	public void setFechaInicio(Timestamp fechaInicio)
	{
		this.fechaInicio = fechaInicio;
	}

	public Timestamp getFechaFin()
	{
		return fechaFin;
	}

	public void setFechaFin(Timestamp fechaFin)
	{
		this.fechaFin = fechaFin;
	}

	public Administrador getAdministrador()
	{
		return administrador;
	}

	public void setAdministrador(Administrador administrador)
	{
		this.administrador = administrador;
	}
}