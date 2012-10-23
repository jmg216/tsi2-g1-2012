package com.geored.dto;

public class TematicaEventoDTO
{
	private Long id;
	
	private Long idTematica;
	
	private String nombreTematica;
	
	private Long idEvento;
	
	private String nombreEvento;

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

	public Long getIdEvento()
	{
		return idEvento;
	}

	public void setIdEvento(Long idEvento)
	{
		this.idEvento = idEvento;
	}

	public String getNombreEvento()
	{
		return nombreEvento;
	}

	public void setNombreEvento(String nombreEvento)
	{
		this.nombreEvento = nombreEvento;
	}
}