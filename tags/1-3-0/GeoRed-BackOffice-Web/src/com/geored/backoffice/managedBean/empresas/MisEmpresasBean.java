package com.geored.backoffice.managedBean.empresas;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.xml.rpc.ServiceException;


@ManagedBean(name="misEmpresasBean")
@SessionScoped
public class MisEmpresasBean implements Serializable
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PostConstruct
	public void init() throws ServiceException
	{	
	}	
}
