package com.geored.backoffice.managedBean.cuenta;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.geored.negocio.AdministradorDTO;

@ManagedBean(name = "loginBean")
@SessionScoped
public class RegistroBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private AdministradorDTO administradorDTO;

	@PostConstruct
	public void init()
	{
	}

	public AdministradorDTO getAdministradorDTO()
	{
		return administradorDTO;
	}

	public void setAdministradorDTO(AdministradorDTO administradorDTO)
	{
		this.administradorDTO = administradorDTO;
	}
}