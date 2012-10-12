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
}