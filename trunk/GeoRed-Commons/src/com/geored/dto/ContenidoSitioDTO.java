package com.geored.dto;

public class ContenidoSitioDTO
{
	private Long id;

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
}