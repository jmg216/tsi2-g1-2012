package com.geored.dto;

import java.io.Serializable;
import java.util.Date;

public class CompraDTO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7441150510833578026L;

	private Long id;
	
	private Date fechaCreacion;
	
	private Long idUsuario;
	
	private String nombreUsuario;
	
	private Long idOferta;
	
	private String nombreOferta;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Date getFechaCreacion()
	{
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion)
	{
		this.fechaCreacion = fechaCreacion;
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

	public Long getIdOferta()
	{
		return idOferta;
	}

	public void setIdOferta(Long idOferta)
	{
		this.idOferta = idOferta;
	}

	public String getNombreOferta()
	{
		return nombreOferta;
	}

	public void setNombreOferta(String nombreOferta)
	{
		this.nombreOferta = nombreOferta;
	}
}