package com.geored.backoffice.managedBean.eventos;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.geored.backoffice.managedBean.BaseBean;

@ManagedBean(name="listadoEventosBean")
@RequestScoped
public class ListadoEventosBean extends BaseBean implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5206259587791039366L;
	
	public ListadoEventosBean()
	{
		
	}
}
