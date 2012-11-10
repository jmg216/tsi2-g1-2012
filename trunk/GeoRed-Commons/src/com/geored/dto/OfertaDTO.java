package com.geored.dto;

import java.util.Date;
import java.util.List;

public class OfertaDTO
{
	private Long id;
	
	private String nombre;
	
	private String descripcion;
	
	private Double costo;
	
	private String urlImagen;
	
	private Date fechaInicio;
	
	private Date fechaFin;
	
	private Long idLocal;
	
	private String nombreLocal;

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

	public Long getIdLocal()
	{
		return idLocal;
	}

	public void setIdLocal(Long idLocal)
	{
		this.idLocal = idLocal;
	}

	public String getNombreLocal()
	{
		return nombreLocal;
	}

	public void setNombreLocal(String nombreLocal)
	{
		this.nombreLocal = nombreLocal;
	}

	public String getDescripcion()
	{
		return descripcion;
	}

	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}

	public Double getCosto()
	{
		return costo;
	}

	public void setCosto(Double costo)
	{
		this.costo = costo;
	}

	public String getUrlImagen()
	{
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen)
	{
		this.urlImagen = urlImagen;
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