package com.geored.backoffice.managedBean.administradores;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.geored.backoffice.managedBean.BaseBean;

@ManagedBean(name="listadoAdministradoresBean")
@RequestScoped
public class ListadoAdministradoresBean extends BaseBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6024226771137458953L;
	
	public ListadoAdministradoresBean()
	{		
	}
}