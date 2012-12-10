package com.geored.dto;

import java.util.Date;

public class CheckInDTO
{
	private Long id;
	
	private Date fechaCreacion;

	private Long idUsuario;
	
	private String nombreUsuario;
	
	private Long idSitio;
	
	private String nombreSitio;
	
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Long getIdUsuario()
	{
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario)
	{
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario()
	{
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario)
	{
		this.nombreUsuario = nombreUsuario;
	}

	public Long getIdSitio()
	{
		return idSitio;
	}

	public void setIdSitio(Long idSitio)
	{
		this.idSitio = idSitio;
	}

	public String getNombreSitio()
	{
		return nombreSitio;
	}

	public void setNombreSitio(String nombreSitio)
	{
		this.nombreSitio = nombreSitio;
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