package com.geored.dto;

public class TematicaUsuarioDTO
{
	private Long id;
	
	private Long idTematica;
	
	private String nombreTematica;
	
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

	public Long getIdTematica()
	{
		return idTematica;
	}

	public void setIdTematica(Long idTematica)
	{
		this.idTematica = idTematica;
	}

	public String getNombreTematica()
	{
		return nombreTematica;
	}

	public void setNombreTematica(String nombreTematica)
	{
		this.nombreTematica = nombreTematica;
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