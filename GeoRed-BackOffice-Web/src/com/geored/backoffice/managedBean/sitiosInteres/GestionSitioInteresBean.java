package com.geored.backoffice.managedBean.sitiosInteres;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="gestionSitioInteresBean")
@SessionScoped
public class GestionSitioInteresBean implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
//	public void crearSitio() throws ServiceException
//	{
//		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
//		
//		locator = new SitioServiceImplServiceLocator ();
//		sitioWS = locator.getSitioServiceImplPort();
//		
//		SitioDTO sitio = null;
//		
//		sitio.setDescripcion(descripcion);
//		sitio.setNombre(nombre);
//		sitio.setUbicacionGeografica(ubicacion);
//		
//		try
//		{
//			sitioWS.insertar(sitio);
//		
//		} catch(RemoteException e1)
//		{
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No es posible Salvar el sitio."));
//		}
//	}
	
}
