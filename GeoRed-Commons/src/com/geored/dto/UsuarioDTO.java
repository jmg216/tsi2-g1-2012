package com.geored.dto;

import java.util.List;

public class UsuarioDTO
{
	private Long id;
	
	private String email;
	
	private String pass;

	private String nombre;
	
	private String urlImagen;
	
	private List<TematicaDTO> listaTematicasDTO;
	
	private List<OfertaDTO> listaComprasDTO;
	
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


	public String getUrlImagen()
	{
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen)
	{
		this.urlImagen = urlImagen;
	}

	public List<TematicaDTO> getListaTematicasDTO()
	{
		return listaTematicasDTO;
	}

	public void setListaTematicasDTO(List<TematicaDTO> listaTematicasDTO)
	{
		this.listaTematicasDTO = listaTematicasDTO;
	}

	public List<OfertaDTO> getListaComprasDTO()
	{
		return listaComprasDTO;
	}

	public void setListaComprasDTO(List<OfertaDTO> listaComprasDTO)
	{
		this.listaComprasDTO = listaComprasDTO;
	}
}