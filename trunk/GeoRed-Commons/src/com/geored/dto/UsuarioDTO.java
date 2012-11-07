package com.geored.dto;

public class UsuarioDTO
{
	private Long id;
	
	private String email;
	
	private String pass;

	private String nombre;
	
	private String imagen;
	
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

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPass()
	{
		return pass;
	}

	public void setPass(String pass)
	{
		this.pass = pass;
	}
	
	public String getImagen()
	{
		return imagen;
	}

	public void setImagen(String imagen)
	{
		this.imagen = imagen;
	}
}