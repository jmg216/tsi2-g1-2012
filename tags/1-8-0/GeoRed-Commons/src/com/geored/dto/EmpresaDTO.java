package com.geored.dto;

import java.util.Date;
import java.util.List;

public class EmpresaDTO
{
	private Long id;
	
	private String nombre;
	
	private String descripcion;
	
	private String urlImagen;
	
	private Date fechaCreacion;

	private Long idAdministrador;
	
	private String nombreAdministrador;
	
	private List<LocalDTO> listaLocalesDTO;
	
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

	public Long getIdAdministrador()
	{
		return idAdministrador;
	}

	public void setIdAdministrador(Long idAdministrador)
	{
		this.idAdministrador = idAdministrador;
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

	public String getUrlImagen()
	{
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen)
	{
		this.urlImagen = urlImagen;
	}

	public Date getFechaCreacion()
	{
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion)
	{
		this.fechaCreacion = fechaCreacion;
	}

	public List<LocalDTO> getListaLocalesDTO()
	{
		return listaLocalesDTO;
	}

	public void setListaLocalesDTO(List<LocalDTO> listaLocalesDTO)
	{
		this.listaLocalesDTO = listaLocalesDTO;
	}
}