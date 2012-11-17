package com.geored.backoffice.managedBean.locales;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.geored.backoffice.managedBean.BaseBean;
import com.geored.backoffice.utiles.UtilesWeb;
import com.geored.negocio.LocalDTO;

@ManagedBean(name="gestionLocalBean")
@RequestScoped
public class GestionLocalBean extends BaseBean implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8834025396990537040L;
	
	private static final int VALIDAR_CREAR = 1;
	
	private static final int VALIDAR_MODIFICAR = 2; 
	
	private static final String LOCAL_DTO_KEY = "LOCAL_DTO_KEY"; 
	
	private static final String TO_LISTADO_LOCALES = "to_listado_sitios";
	
	private LocalDTO localDTO = new LocalDTO();
	
	public GestionLocalBean()
	{	
		localDTO = (LocalDTO) getFlashAttribute(LOCAL_DTO_KEY);
				
		if(localDTO == null)
		{
			String idLocal = getRequestParameter("idLocal");     
			
			if(UtilesWeb.isNullOrEmpty(idLocal))
			{
				localDTO = new LocalDTO();
			}
			else
			{
				try
				{
					localDTO = getEmpresaPort().obtenerLocal(Long.valueOf(idLocal));
				} 
				catch (Exception e)
				{
					addBeanError(e.getMessage());
				} 
			}
			
			setFlashAttribute(LOCAL_DTO_KEY, localDTO);
		}
	}

	public String guardarLocal()
	{
		try
		{
			if(getLocalDTO() == null)
			{
				addBeanError("Sitio no puede ser nulo");			
			}
			else
			{				
				if(UtilesWeb.isNullOrZero(getLocalDTO().getId()))
				{
					if(validar(VALIDAR_CREAR))
					{
						getLocalDTO().setIdEmpresa(UtilesWeb.obtenerEmpresaAdministrada().getId());
						
						Long idLocalNuevo = getEmpresaPort().insertarLocal(getLocalDTO());
						
						setLocalDTO(getEmpresaPort().obtenerLocal(idLocalNuevo));
						
						addBeanMessage("Local guardado correctamente");
					}
				}
				else
				{
					if(validar(VALIDAR_MODIFICAR))
					{
						getEmpresaPort().actualizarLocal(getLocalDTO());	
						
						setLocalDTO(getEmpresaPort().obtenerLocal(getLocalDTO().getId()));
						
						addBeanMessage("Local guardado correctamente");
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
	
	public String toListadoLocales()
	{
		return TO_LISTADO_LOCALES;
	}

	private boolean validar(int opValidar)
	{
		boolean isValid = true;
		
		if(opValidar == VALIDAR_CREAR || opValidar == VALIDAR_MODIFICAR)
		{
			if(UtilesWeb.isNullOrEmpty(getLocalDTO().getNombre()))
			{
				addBeanError("'Nombre' es un campo obligatorio.");
				isValid = false;
			}						
			
			if(UtilesWeb.isNullOrEmpty(getLocalDTO().getUbicacionGeografica()))
			{
				addBeanError("'Ubicación Geográfica' es un campo obligatorio.");
				isValid = false;
			}			
		}
		
		return isValid;
	}

	public LocalDTO getLocalDTO()
	{
		return localDTO;
	}

	public void setLocalDTO(LocalDTO localDTO)
	{
		this.localDTO = localDTO;
	}
}
