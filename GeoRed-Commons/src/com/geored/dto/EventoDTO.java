package com.geored.dto;

import java.util.Date;

public class EventoDTO
{
	private Long id;
	
	private String nombre;
	
	private String descripcion;
	
	private String ubicacionGeogrica;
	
	private Date fechaInicio;
	
	private Date fechaFin;
	
	private Long idAministrador;
	
	private String nombreAdministrador;

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

	public Long getIdAministrador()
	{
		return idAministrador;
	}

	public void setIdAministrador(Long idAministrador)
	{
		this.idAministrador = idAministrador;
	}

	public String getNombreAdministrador()
	{
		return nombreAdministrador;
	}

	public void setNombreAdministrador(String nombreAdministrador)
	{
		this.nombreAdministrador = nombreAdministrador;
	}

	public String getDescripcion()
	{
		return descripcion;
	}

	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}

	public String getUbicacionGeogrica()
	{
		return ubicacionGeogrica;
	}

	public void setUbicacionGeogrica(String ubicacionGeogrica)
	{
		this.ubicacionGeogrica = ubicacionGeogrica;
	}

	public Date getFechaInicio()
	{
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio)
	{
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin()
	{
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin)
	{
		this.fechaFin = fechaFin;
	}
}