package com.geored.dto;

public class NotificacionDTO 
{
	private Long id;
	
	private String nombre;
	
	private Long idUsuario;
	
	private String nombreUsuario;

	private Long idTipoNotificacion;
	
	private String nombreTipoNotificacion;
	
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

	public Long getIdTipoNotificacion()
	{
		return idTipoNotificacion;
	}

	public void setIdTipoNotificacion(Long idTipoNotificacion)
	{
		this.idTipoNotificacion = idTipoNotificacion;
	}

	public String getNombreTipoNotificacion()
	{
		return nombreTipoNotificacion;
	}

	public void setNombreTipoNotificacion(String nombreTipoNotificacion)
	{
		this.nombreTipoNotificacion = nombreTipoNotificacion;
	}
}