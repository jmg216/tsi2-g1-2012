package com.geored.backoffice.managedBean.eventos;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.geored.backoffice.managedBean.BaseBean;

@ManagedBean(name="gestionEventoBean")
@RequestScoped
public class GestionEventoBean extends BaseBean implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5348254664595085666L;
	
	public GestionEventoBean()
	{
		
	}
}
