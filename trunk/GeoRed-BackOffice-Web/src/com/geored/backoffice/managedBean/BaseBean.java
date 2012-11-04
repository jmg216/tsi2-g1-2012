package com.geored.backoffice.managedBean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.xml.rpc.ServiceException;

import com.geored.negocio.EmpresaServiceImpl;
import com.geored.negocio.EmpresaServiceImplServiceLocator;

public abstract class BaseBean
{
	protected static final String MSJ_ERROR_COMUNICACION_WS = "Error de comunicación con el WS";
	
	protected static final String SUCCESS = "success";
	
	protected void addMessage(String message)
	{
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message));
	}
	
	// Ports WS
	private EmpresaServiceImpl empresaPort;
	protected EmpresaServiceImpl getEmpresaPort() throws ServiceException
	{
		if(empresaPort == null)
		{
			empresaPort = new EmpresaServiceImplServiceLocator().getEmpresaServiceImplPort();
		}
		
		return empresaPort;
	}
}