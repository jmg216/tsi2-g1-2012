package com.geored.backoffice.managedBean.sitios;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.xml.rpc.ServiceException;

import com.geored.backoffice.managedBean.BaseBean;
import com.geored.negocio.DaoException;
import com.geored.negocio.SitioDTO;

@ManagedBean(name="listadoSitiosBean")
@RequestScoped
public class ListadoSitiosBean extends BaseBean implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -285130153830430998L;
	
	private static final String TO_GESTION_SITIO = "to_gestion_sitio";
	
	private Long idSitio;
	
	private List<SitioDTO> listaSitios = new ArrayList<SitioDTO>();

	public ListadoSitiosBean() 
	{
		try 
		{
			listaSitios = Arrays.asList(getSitioPort().obtenerListado());
			
		} 
		catch (ServiceException e) 
		{
			addBeanError(MSJ_ERROR_COMUNICACION_WS);
			
		} 
		catch (DaoException e) 
		{
			addBeanError(e.getMessage());
			
		}
		catch (RemoteException e) 
		{
			addBeanError(MSJ_ERROR_COMUNICACION_WS);
		}
	}
	
	public String toGestionSitio()
	{
		return TO_GESTION_SITIO;
	}

	public Long getIdSitio()
	{
		return idSitio;
	}

	public void setIdSitio(Long idSitio)
	{
		this.idSitio = idSitio;
	}

	public List<SitioDTO> getListaSitios()
	{
		return listaSitios;
	}

	public void setListaSitios(List<SitioDTO> listaSitios)
	{
		this.listaSitios = listaSitios;
	}
	
	
}
