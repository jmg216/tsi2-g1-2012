package com.geored.dto;

import java.util.Date;

public class EmpresaDTO
{
	private Long id;
	
	private String nombre;
	
	private String descripcion;
	
	private String logoUrl;
	
	private Date fechaCreacion;

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

	public String getLogoUrl()
	{
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl)
	{
		this.logoUrl = logoUrl;
	}

	public Date getFechaCreacion()
	{
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion)
	{
		this.fechaCreacion = fechaCreacion;
	}
}