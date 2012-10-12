package com.geored.dto;

public class TipoNotificacionUsuarioDTO
{
	private Long id;
	
	private Long idTipoNotificacion;
	
	private String nombreTipoNotificacion;
	
	private Long idUsuario;
	
	private String nombreUsuario;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
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
}