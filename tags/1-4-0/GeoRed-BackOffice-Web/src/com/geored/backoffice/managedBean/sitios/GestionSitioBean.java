package com.geored.backoffice.managedBean.sitios;

import java.io.Serializable;
import java.rmi.RemoteException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.xml.rpc.ServiceException;

import com.geored.backoffice.managedBean.BaseBean;
import com.geored.backoffice.utiles.UtilesWeb;
import com.geored.negocio.DaoException;
import com.geored.negocio.NegocioException;
import com.geored.negocio.SitioDTO;

@ManagedBean(name="gestionSitioBean")
@RequestScoped
public class GestionSitioBean extends BaseBean implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8834025396990537040L;
	
	private static final String TO_LISTADO_SITIOS = "to_listado_sitios";
	
	private SitioDTO sitioDTO = new SitioDTO();
	
	public GestionSitioBean()
	{	
		String idSitio = getRequestParameter("idSitio");                
		
		if(UtilesWeb.isNullOrEmpty(idSitio))
		{
			sitioDTO = new SitioDTO();
		}
		else
		{
			try
			{
				sitioDTO = getSitioPort().obtener(Long.valueOf(idSitio));
			} 
			catch (NegocioException e)
			{
				addBeanError(e.getMessage());
			} 
			catch (DaoException e)
			{
				addBeanError(e.getMessage());
			} 
			catch (RemoteException e)
			{
				addBeanError(MSJ_ERROR_COMUNICACION_WS);
			} 
			catch (ServiceException e)
			{
				addBeanError(MSJ_ERROR_COMUNICACION_WS);
			}
		}
	}

	public void guardarSitio()
	{
		addBeanMessage("Sitio guardado correctamente");
	}
	
	public String toListadoSitios()
	{
		return TO_LISTADO_SITIOS;
	}

	public SitioDTO getSitioDTO()
	{
		return sitioDTO;
	}

	public void setSitioDTO(SitioDTO sitioDTO)
	{
		this.sitioDTO = sitioDTO;
	}
	
	
}
