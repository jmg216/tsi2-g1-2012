package com.geored.backoffice.managedBean.administradores;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.geored.backoffice.managedBean.BaseBean;

@ManagedBean(name="gestionAdministradorBean")
@RequestScoped
public class GestionAdministradorBean extends BaseBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1818155054179872179L;
	
	public GestionAdministradorBean()
	{
		
	}
}