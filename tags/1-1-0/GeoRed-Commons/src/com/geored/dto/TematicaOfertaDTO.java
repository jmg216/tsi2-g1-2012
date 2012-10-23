package com.geored.dto;

public class TematicaOfertaDTO
{
	private Long id;
	
	private Long idTematica;
	
	private String nombreTematica;
	
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