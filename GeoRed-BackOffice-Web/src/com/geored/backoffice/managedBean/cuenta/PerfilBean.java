package com.geored.backoffice.managedBean.cuenta;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.geored.backoffice.managedBean.BaseBean;
import com.geored.negocio.AdministradorDTO;

@ManagedBean(name="perfilBean")
@RequestScoped
public class PerfilBean extends BaseBean implements Serializable
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3650528505815349823L;
	
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