package com.geored.backoffice.managedBean.reportes;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="reporteComprasBean")
@SessionScoped
public class ReporteComprasBean implements Serializable
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PostConstruct
	public void init() 
	{
	}	
}
