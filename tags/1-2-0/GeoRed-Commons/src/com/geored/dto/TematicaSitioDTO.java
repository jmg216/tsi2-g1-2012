package com.geored.dto;

public class TematicaSitioDTO
{
	private Long id;
	
	private Long idTematica;
	
	private String nombreTematica;
	
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