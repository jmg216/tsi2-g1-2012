package com.geored.dto;

import java.io.Serializable;
import java.util.Date;

public class MensajeAmistadDTO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2446065374052925070L;

	private Long id;
	
	private String mensaje;
	
	private Date fechaCreacion;
	
	private Long idAmistad;
	
	private Long idRemitente;
	
	private String nombreRemitente;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getMensaje()
	{
		return mensaje;
	}

	public void setMensaje(String mensaje)
	{
		this.mensaje = mensaje;
	}

	public Date getFechaCreacion()
	{
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion)
	{
		this.fechaCreacion = fechaCreacion;
	}

	public Long getIdAmistad()
	{
		return idAmistad;
	}

	public void setIdAmistad(Long idAmistad)
	{
		this.idAmistad = idAmistad;
	}

	public Long getIdRemitente()
	{
		return idRemitente;
	}

	public void setIdRemitente(Long idRemitente)
	{
		this.idRemitente = idRemitente;
	}

	public String getNombreRemitente()
	{
		return nombreRemitente;
	}

	public void setNombreRemitente(String nombreRemitente)
	{
		this.nombreRemitente = nombreRemitente;
	}
}