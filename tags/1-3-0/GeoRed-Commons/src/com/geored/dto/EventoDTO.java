package com.geored.dto;

import java.util.Date;
import java.util.List;

public class EventoDTO
{
	private Long id;
	
	private String nombre;
	
	private String descripcion;
	
	private String ubicacionGeogrica;
	
	private Date fechaInicio;
	
	private Date fechaFin;

	private List<TematicaDTO> listaTematicasDTO;
	
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

	public List<TematicaDTO> getListaTematicasDTO()
	{
		return listaTematicasDTO;
	}

	public void setListaTematicasDTO(List<TematicaDTO> listaTematicasDTO)
	{
		this.listaTematicasDTO = listaTematicasDTO;
	}
}