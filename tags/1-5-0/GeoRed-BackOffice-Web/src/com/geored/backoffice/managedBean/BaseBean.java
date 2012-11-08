package com.geored.backoffice.managedBean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.xml.rpc.ServiceException;

import com.geored.negocio.AdminServiceImpl;
import com.geored.negocio.AdminServiceImplServiceLocator;
import com.geored.negocio.EmpresaServiceImpl;
import com.geored.negocio.EmpresaServiceImplServiceLocator;
import com.geored.negocio.EventoServiceImpl;
import com.geored.negocio.EventoServiceImplServiceLocator;
import com.geored.negocio.GlobalServiceImpl;
import com.geored.negocio.GlobalServiceImplServiceLocator;
import com.geored.negocio.OfertaServiceImpl;
import com.geored.negocio.OfertaServiceImplServiceLocator;
import com.geored.negocio.SitioServiceImpl;
import com.geored.negocio.SitioServiceImplServiceLocator;

public abstract class BaseBean
{
	protected static final String MSJ_ERROR_COMUNICACION_WS = "Error de comunicación con el WS";
	
	protected void addBeanError(String message)
	{
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
	}
	
	protected void addBeanMessage(String message)
	{
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
	}
	
	protected String getRequestParameter(String key)
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
	
	private AdminServiceImpl adminPort;
	protected AdminServiceImpl getAdminPort() throws ServiceException
	{
		if(adminPort == null)
		{
			adminPort = new AdminServiceImplServiceLocator().getAdminServiceImplPort();
		}
		
		return adminPort;
	}
	
	private OfertaServiceImpl ofertaPort;
	protected OfertaServiceImpl getOfertaPort() throws ServiceException 
	{
		if(ofertaPort == null) 
		{
			ofertaPort = new OfertaServiceImplServiceLocator().getOfertaServiceImplPort();
		}
		
		return ofertaPort;
	} 
	
	private EventoServiceImpl eventoPort;
	protected EventoServiceImpl getEventoPort() throws ServiceException
	{
		if(eventoPort == null)
		{
			eventoPort = new EventoServiceImplServiceLocator().getEventoServiceImplPort();
		}
		
		return eventoPort;			
	}
	
	private SitioServiceImpl sitioPort;
	protected SitioServiceImpl getSitioPort() throws ServiceException
	{
		if(sitioPort == null)
		{
			sitioPort = new SitioServiceImplServiceLocator().getSitioServiceImplPort();
		}
		
		return sitioPort;
	}
	
	private GlobalServiceImpl globalPort;
	protected GlobalServiceImpl getGlobalPort() throws ServiceException
	{
		if(globalPort == null)
		{
			globalPort = new GlobalServiceImplServiceLocator().getGlobalServiceImplPort();
		}
		
		return globalPort;
	}
}