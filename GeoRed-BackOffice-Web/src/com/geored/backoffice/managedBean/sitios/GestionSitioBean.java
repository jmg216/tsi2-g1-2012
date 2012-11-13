package com.geored.backoffice.managedBean.sitios;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.geored.backoffice.managedBean.BaseBean;
import com.geored.backoffice.utiles.UtilesWeb;
import com.geored.negocio.SitioDTO;
import com.geored.negocio.TematicaDTO;

@ManagedBean(name="gestionSitioBean")
@RequestScoped
public class GestionSitioBean extends BaseBean implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8834025396990537040L;
	
	private static final int VALIDAR_CREAR = 1;
	
	private static final int VALIDAR_MODIFICAR = 2; 
	
	private static final String TO_LISTADO_SITIOS = "to_listado_sitios";
	
	private SitioDTO sitioDTO = new SitioDTO();
	
	private List<TematicaDTO> listaTematicas = new ArrayList<TematicaDTO>();
	
	private List<Long> tematicasSeleccionadas = new ArrayList<Long>();
	
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
			catch (Exception e)
			{
				addBeanError(e.getMessage());
			} 
		}
		
		cargarDatoIniciales();
	}

	private void cargarDatoIniciales()
	{
		try
		{
			listaTematicas = Arrays.asList(getGlobalPort().obtenerListadoTematicas());
		} 
		catch (Exception e)
		{
			handleWSException(e);
		}
	}
	
	public void guardarSitio()
	{
		try
		{
			if(getSitioDTO() == null)
			{
				addBeanError("Sitio no puede ser nulo");			
			}
			else
			{
				if(UtilesWeb.isNullOrZero(getSitioDTO().getId()))
				{
					if(validar(VALIDAR_CREAR))
					{
						getSitioPort().insertar(getSitioDTO());
						
						addBeanMessage("Sitio guardado correctamente");
					}
				}
				else
				{
					if(validar(VALIDAR_MODIFICAR))
					{
						getSitioPort().actualizar(getSitioDTO());	
						
						addBeanMessage("Sitio guardado correctamente");
					}
				}				 
			}
		}	
		catch (Exception e)
		{
			handleWSException(e);
		}
	}
	
	public String toListadoSitios()
	{
		return TO_LISTADO_SITIOS;
	}

	private boolean validar(int opValidar)
	{
		boolean isValid = true;
		
		switch(opValidar)
		{
		case VALIDAR_CREAR:			
			if(UtilesWeb.isNullOrEmpty(getSitioDTO().getNombre()))
			{
				addBeanError("'Nombre' es un campo obligatorio.");
				isValid = false;
			}			
			if(UtilesWeb.isNullOrEmpty(getSitioDTO().getDescripcion()))
			{
				addBeanError("'Descripción' es un campo obligatorio.");
				isValid = false;
			}
			if(UtilesWeb.isNullOrEmpty(getSitioDTO().getUrlImagen()))
			{
				addBeanError("'URL Imagen' es un campo obligatorio.");
				isValid = false;
			}
			if(UtilesWeb.isNullOrEmpty(getSitioDTO().getUbicacionGeografica()))
			{
				addBeanError("'Ubicación Geográfica' es un campo obligatorio.");
				isValid = false;
			}
			break;
			
		case VALIDAR_MODIFICAR:
			if(UtilesWeb.isNullOrEmpty(getSitioDTO().getNombre()))
			{
				addBeanError("'Nombre' es un campo obligatorio.");
				isValid = false;
			}			
			if(UtilesWeb.isNullOrEmpty(getSitioDTO().getDescripcion()))
			{
				addBeanError("'Descripción' es un campo obligatorio.");
				isValid = false;
			}
			if(UtilesWeb.isNullOrEmpty(getSitioDTO().getUrlImagen()))
			{
				addBeanError("'URL Imagen' es un campo obligatorio.");
				isValid = false;
			}
			if(UtilesWeb.isNullOrEmpty(getSitioDTO().getUbicacionGeografica()))
			{
				addBeanError("'Ubicación Geográfica' es un campo obligatorio.");
				isValid = false;
			}
			break;
			
		default:
			isValid = false;
		}
		
		return isValid;
	}
	
	public SitioDTO getSitioDTO()
	{
		return sitioDTO;
	}

	public void setSitioDTO(SitioDTO sitioDTO)
	{
		this.sitioDTO = sitioDTO;
	}

	public List<TematicaDTO> getListaTematicas()
	{
		return listaTematicas;
	}

	public void setListaTematicas(List<TematicaDTO> listaTematicas)
	{
		this.listaTematicas = listaTematicas;
	}

	public List<Long> getTematicasSeleccionadas()
	{
		return tematicasSeleccionadas;
	}

	public void setTematicasSeleccionadas(List<Long> tematicasSeleccionadas)
	{
		this.tematicasSeleccionadas = tematicasSeleccionadas;
	}	
}
