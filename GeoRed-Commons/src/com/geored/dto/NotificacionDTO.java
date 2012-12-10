package com.geored.dto;

public class NotificacionDTO 
{
	private Long id;
	
	private String descripcion;
	
	private String metadataNotif;
	
	private boolean leida;
	
	private Long idUsuarioDestino;
	
	private String nombreUsuarioDestino;

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

	public String getDescripcion()
	{
		return descripcion;
	}

	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}

	public boolean isLeida()
	{
		return leida;
	}

	public void setLeida(boolean leida)
	{
		this.leida = leida;
	}

	public Long getIdUsuarioDestino()
	{
		return idUsuarioDestino;
	}

	public void setIdUsuarioDestino(Long idUsuarioDestino)
	{
		this.idUsuarioDestino = idUsuarioDestino;
	}

	public String getNombreUsuarioDestino()
	{
		return nombreUsuarioDestino;
	}

	public void setNombreUsuarioDestino(String nombreUsuarioDestino)
	{
		this.nombreUsuarioDestino = nombreUsuarioDestino;
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

	public String getMetadataNotif()
	{
		return metadataNotif;
	}

	public void setMetadataNotif(String metadataNotif)
	{
		this.metadataNotif = metadataNotif;
	}
}