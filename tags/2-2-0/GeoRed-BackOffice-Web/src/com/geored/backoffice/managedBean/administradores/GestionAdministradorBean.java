package com.geored.backoffice.managedBean.administradores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.geored.backoffice.managedBean.BaseBean;
import com.geored.backoffice.utiles.UtilesSeguridadWeb;
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
	
	private static final int VALIDAR_CREAR = 1;
	
	private static final int VALIDAR_MODIFICAR = 2;
	
	private static final String ADMINISTRADOR_DTO_KEY = "ADMINISTRADOR_DTO_KEY";
	
	private static final String TO_LISTADO_ADMINISTRADORES = "to_listado_administradores";
	
	private AdministradorDTO administradorDTO = new AdministradorDTO();
	
	private List<TipoAdministradorDTO> listaTiposAdministradores = new ArrayList<TipoAdministradorDTO>();
	
	public GestionAdministradorBean()
	{
		administradorDTO = (AdministradorDTO) getFlashAttribute(ADMINISTRADOR_DTO_KEY);
		
		if(administradorDTO == null)
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
			
			setFlashAttribute(ADMINISTRADOR_DTO_KEY, administradorDTO);
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

	public String guardarAdministrador()
	{
		try
		{
			if(getAdministradorDTO() == null)
			{
				addBeanError("Administrador no puede ser nulo");			
			}
			else
			{
				if(UtilesWeb.isNullOrZero(getAdministradorDTO().getId()))
				{
					if(validar(VALIDAR_CREAR))
					{
						getAdministradorDTO().setPass(UtilesSeguridadWeb.encriptarMD5(UtilesSeguridadWeb.DEFAULT_PASS));
						
						getAdminPort().insertar(getAdministradorDTO());
						
						addBeanMessage("Administrador guardado correctamente");
					}
				}
				else
				{
					if(validar(VALIDAR_MODIFICAR))
					{
						getAdminPort().actualizar(getAdministradorDTO());
						
						addBeanMessage("Administrador guardado correctamente");
					}
				}				 
			}
		}	
		catch (Exception e)
		{
			handleWSException(e);
		}
		
		return SUCCESS;
	}
	
	private boolean validar(int opValidar)
	{
		boolean isValid = true;
		
		if(opValidar == VALIDAR_CREAR || opValidar == VALIDAR_MODIFICAR)
		{			
			if(UtilesWeb.isNullOrEmpty(getAdministradorDTO().getEmail()))
			{
				addBeanError("gestionAdministradorForm:emailAdministrador", "Obligatorio");
				isValid = false;
			}
			if(UtilesWeb.isNullOrEmpty(getAdministradorDTO().getNombre()))
			{
				addBeanError("gestionAdministradorForm:nombreAdministrador", "Obligatorio");
				isValid = false;
			}
			if(UtilesWeb.isNullOrZero(getAdministradorDTO().getIdTipoAdministrador()))
			{
				addBeanError("gestionAdministradorForm:tipoAdministrador", "Obligatorio");
				isValid = false;
			}
		}
		
		return isValid;
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