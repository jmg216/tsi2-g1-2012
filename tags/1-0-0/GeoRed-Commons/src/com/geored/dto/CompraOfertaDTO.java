package com.geored.dto;

public class CompraOfertaDTO
{
	private Long id;
	
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
