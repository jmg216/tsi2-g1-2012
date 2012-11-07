package com.geored.dto;

import java.util.List;

public class SitioDTO 
{
	private Long id;
	
	private String nombre;
	
	private String urlImagen;
	
	private String descripcion;
	
	private String ubicacionGeografica;

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

	public String getUrlImagen()
	{
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen)
	{
		this.urlImagen = urlImagen;
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

	public List<TematicaDTO> getListaTematicasDTO()
	{
		return listaTematicasDTO;
	}

	public void setListaTematicasDTO(List<TematicaDTO> listaTematicasDTO)
	{
		this.listaTematicasDTO = listaTematicasDTO;
	}
}