package com.geored.backoffice.managedBean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public abstract class BaseBean
{
	protected static final String MSJ_ERROR_COMUNICACION_WS = "Error de comunicaci�n con el WS";
	
	protected void addMessage(String message)
	{
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(message));
	}
}