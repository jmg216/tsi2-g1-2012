package com.geored.backoffice.managedBean.administradores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.geored.backoffice.managedBean.BaseBean;
import com.geored.backoffice.utiles.UtilesWeb;
import com.geored.negocio.AdministradorDTO;
import com.geored.negocio.TipoAdministradorDTO;

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
	
	private List<TipoAdministradorDTO> listaTiposAdministradores = new ArrayList<TipoAdministradorDTO>();
	
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
				administradorDTO = getAdminPort().obtener(Long.valueOf(idAdministrador));
			} 
			catch (Exception e)
			{
				handleWSException(e);
			} 
		}
		
		cargarDatosIniciales();
	}
	
	private void cargarDatosIniciales()
	{
		try
		{
			TipoAdministradorDTO[] arrayTiposAdministradores = getGlobalPort().obtenerListadoTiposAdministradores();
			
			if(arrayTiposAdministradores != null)
			{
				listaTiposAdministradores = Arrays.asList(arrayTiposAdministradores);
			}
			else
			{
				listaTiposAdministradores = new ArrayList<TipoAdministradorDTO>();
			}
		}
		catch (Exception e)
		{
			handleWSException(e);
		} 
	}

	public void guardarAdministrador()
	{
		boolean administradorValido = true;
		
		if(getAdministradorDTO() == null)
		{
			addBeanError("Administrador no puede ser nulo");			
			administradorValido = false;
		}
		else
		{
			if(UtilesWeb.isNullOrEmpty(getAdministradorDTO().getEmail()))
			{
				addBeanError("'E-mail' es un campo obligatorio.");
				administradorValido = false;
			}
			if(UtilesWeb.isNullOrEmpty(getAdministradorDTO().getNombre()))
			{
				addBeanError("'Nombre' es un campo obligatorio.");
				administradorValido = false;
			}
			if(UtilesWeb.isNullOrZero(getAdministradorDTO().getIdTipoAdministrador()))
			{
				addBeanError("'Tipo de Administrador' es un campo obligatorio.");
				administradorValido = false;
			}
		}
		
		// Si valida correctamente doy de alta el administrador
		try
		{
			if(administradorValido)
			{
				getAdminPort().insertar(getAdministradorDTO());
				
				addBeanMessage("Administrador guardado correctamente");
			}
		} 
		catch (Exception e)
		{
			handleWSException(e);
		} 		
	}
	
	public String toListadoAdministradores()
	{
		return TO_LISTADO_ADMINISTRADORES;
	}

	public AdministradorDTO getAdministradorDTO()
	{
		return administradorDTO;
	}

	public void setAdministradorDTO(AdministradorDTO administradorDTO)
	{
		this.administradorDTO = administradorDTO;
	}

	public List<TipoAdministradorDTO> getListaTiposAdministradores()
	{
		return listaTiposAdministradores;
	}

	public void setListaTiposAdministradores(List<TipoAdministradorDTO> listaTiposAdministradores)
	{
		this.listaTiposAdministradores = listaTiposAdministradores;
	}
}