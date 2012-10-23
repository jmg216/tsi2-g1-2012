package com.geored.dto;

public class SitioDTO 
{
	private Long id;
	
	private String nombre;
	
	private String descripcion;
	
	private String ubicacionGeografica;

	private Long idAdministrador;
	
	private String nombreAdministrador;
	
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

	public Long getIdAdministrador()
	{
		return idAdministrador;
	}

	public void setIdAdministrador(Long idAdministrador)
	{
		this.idAdministrador = idAdministrador;
	}

	public String getNombreAdministrador()
	{
		return nombreAdministrador;
	}

	public void setNombreAdministrador(String nombreAdministrador)
	{
		this.nombreAdministrador = nombreAdministrador;
	}

	public String getDescripcion()
	{
		return descripcion;
	}

	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}

	public String getUbicacionGeografica()
	{
		return ubicacionGeografica;
	}

	public void setUbicacionGeografica(String ubicacionGeografica)
	{
		this.ubicacionGeografica = ubicacionGeografica;
	}
}