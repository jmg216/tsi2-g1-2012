package com.geored.backoffice.managedBean.administradores;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.xml.rpc.ServiceException;

import com.geored.backoffice.managedBean.BaseBean;
import com.geored.backoffice.utiles.UtilesWeb;
import com.geored.negocio.AdministradorDTO;
import com.geored.negocio.DaoException;
import com.geored.negocio.EmpresaDTO;
import com.geored.negocio.NegocioException;

@ManagedBean(name="gestionAdministradorBean")
@RequestScoped
public class GestionAdministradorBean extends BaseBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1818155054179872179L;
	
	private static final String TO_LISTADO_ADMINISTRADORES = "to_listado_administradores";
	
	private AdministradorDTO administradorDTO = new AdministradorDTO();
	
	public GestionAdministradorBean()
	{	
		String idAdministrador = getRequestParameter("idAdministrador");                
		
		if(UtilesWeb.isNullOrEmpty(idAdministrador))
		{
			administradorDTO = new AdministradorDTO();
		}
		else
		{
			try
			{
				administradorDTO = getAdministradorPort().obtener(Long.valueOf(idAdministrador));
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
		
		cargarDatosIniciales();
	}
	
	private void cargarDatosIniciales()
	{
		try
		{
			List listaAdministradores = Arrays.asList(getAdministradorPort().obtenerListado());
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

	public String toListadoAdministradores()
	{
		return TO_LISTADO_ADMINISTRADORES;
	}
}