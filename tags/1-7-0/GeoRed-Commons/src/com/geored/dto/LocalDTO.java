package com.geored.dto;

import java.util.List;

public class LocalDTO
{
	private Long id;
	
	private String nombre;
	
	private String direccion;
	
	private String ubicacionGeografica;
	
	private Long idEmpresa;
	
	private String nombreEmpresa;
	
	private List<OfertaDTO> listaOfertas;

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

	public Long getIdEmpresa()
	{
		return idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa)
	{
		this.idEmpresa = idEmpresa;
	}

	public String getNombreEmpresa()
	{
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa)
	{
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getUbicacionGeografica()
	{
		return ubicacionGeografica;
	}

	public void setUbicacionGeografica(String ubicacionGeografica)
	{
		this.ubicacionGeografica = ubicacionGeografica;
	}

	public String getDireccion()
	{
		return direccion;
	}

	public void setDireccion(String direccion)
	{
		this.direccion = direccion;
	}

	public List<OfertaDTO> getListaOfertas()
	{
		return listaOfertas;
	}

	public void setListaOfertas(List<OfertaDTO> listaOfertas)
	{
		this.listaOfertas = listaOfertas;
	}
}