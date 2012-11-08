package com.geored.backoffice.managedBean.reportes;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.geored.backoffice.managedBean.BaseBean;

@ManagedBean(name="reporteComprasBean")
@RequestScoped
public class ReporteComprasBean extends BaseBean implements Serializable
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4370175574249396986L;

	public ReporteComprasBean()
	{
		
	}
}
