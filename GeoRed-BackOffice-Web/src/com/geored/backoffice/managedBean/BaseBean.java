package com.geored.backoffice.managedBean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.xml.rpc.ServiceException;

import com.geored.negocio.AdminServiceImpl;
import com.geored.negocio.AdminServiceImplServiceLocator;
import com.geored.negocio.EmpresaServiceImpl;
import com.geored.negocio.EmpresaServiceImplServiceLocator;

public abstract class BaseBean
{
	protected static final String MSJ_ERROR_COMUNICACION_WS = "Error de comunicación con el WS";
	
	protected static final String SUCCESS = "success";
	
	protected void addError(String message)
	{
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
	}
	
	protected void addMessage(String message)
	{
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
	}
	
	protected String getParameter(String key)
	{
		return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(key);
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
	
	private AdminServiceImpl administradorPort;
	protected AdminServiceImpl getAdministradorPort() throws ServiceException
	{
		if(administradorPort == null)
		{
			administradorPort = new AdminServiceImplServiceLocator().getAdminServiceImplPort();
		}
		
		return administradorPort;
	}
}