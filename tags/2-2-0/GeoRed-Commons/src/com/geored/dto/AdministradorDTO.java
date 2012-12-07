package com.geored.dto;

import java.util.ArrayList;
import java.util.List;

public class AdministradorDTO
{
	private Long id;
	
	private String email;
	
	private String pass;
	
	private String nombre;
	
	private Long idTipoAdministrador;
	
	private String nombreTipoAdministrador;

	private List<EmpresaDTO> listaEmpresasDTO = new ArrayList<EmpresaDTO>();
	
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

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public List<EmpresaDTO> getListaEmpresasDTO()
	{
		return listaEmpresasDTO;
	}

	public void setListaEmpresasDTO(List<EmpresaDTO> listaEmpresasDTO)
	{
		this.listaEmpresasDTO = listaEmpresasDTO;
	}
}