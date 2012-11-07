package com.geored.backoffice.managedBean.sitios;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.geored.backoffice.managedBean.BaseBean;

@ManagedBean(name="gestionSitioBean")
@RequestScoped
public class GestionSitioBean extends BaseBean implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8834025396990537040L;
	
	public GestionSitioBean()
	{
		
	}
}
