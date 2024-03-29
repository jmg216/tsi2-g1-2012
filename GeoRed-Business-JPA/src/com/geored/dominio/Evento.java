package com.geored.dominio;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false)
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
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="evento_tematica",
	joinColumns =
	{
	    @JoinColumn(name = "EVENTO_FK")
	},
	inverseJoinColumns =
	{
	    @JoinColumn(name = "TEMATICA_FK")
	})
	private List<Tematica> listaTematicas;

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

	public List<Tematica> getListaTematicas()
	{
		return listaTematicas;
	}

	public void setListaTematicas(List<Tematica> listaTematicas)
	{
		this.listaTematicas = listaTematicas;
	}

	
}