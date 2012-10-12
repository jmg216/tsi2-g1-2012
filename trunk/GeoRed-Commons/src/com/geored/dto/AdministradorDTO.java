package com.geored.dto;

public class AdministradorDTO
{
	private Long id;
	
	private String nombre;
	
	private String pass;
	
	private Long idTipoAdministrador;
	
	private String nombreTipoAdministrador;

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

	public Long getIdTipoAdministrador()
	{
		return idTipoAdministrador;
	}

	public void setIdTipoAdministrador(Long idTipoAdministrador)
	{
		this.idTipoAdministrador = idTipoAdministrador;
	}

	public String getNombreTipoAdministrador()
	{
		return nombreTipoAdministrador;
	}

	public void setNombreTipoAdministrador(String nombreTipoAdministrador)
	{
		this.nombreTipoAdministrador = nombreTipoAdministrador;
	}

	public String getPass()
	{
		return pass;
	}

	public void setPass(String pass)
	{
		this.pass = pass;
	}
}