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
	
	private static final String SITIO_DTO_KEY = "SITIO_DTO_KEY"; 
	
	private static final String TO_LISTADO_SITIOS = "to_listado_sitios";
	
	private SitioDTO sitioDTO = new SitioDTO();
	
	private List<TematicaDTO> listaTematicas = new ArrayList<TematicaDTO>();
	
	private List<String> tematicasSeleccionadas = new ArrayList<String>();
	
	public GestionSitioBean()
	{	
		sitioDTO = (SitioDTO) getFlashAttribute(SITIO_DTO_KEY);
				
		if(sitioDTO == null)
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
			
			setFlashAttribute(SITIO_DTO_KEY, sitioDTO);
		}
		
		cargarDatoIniciales();
	}

	private void cargarDatoIniciales()
	{
		try
		{
			listaTematicas = Arrays.asList(getGlobalPort().obtenerListadoTematicas());
			
			// Cargo los ids de las tematicas seleccionadas en el sitio
			tematicasSeleccionadas = new ArrayList<String>();
			if(sitioDTO.getListaTematicasDTO() != null)
			{
				for(TematicaDTO tematicaDTO : sitioDTO.getListaTematicasDTO())
				{
					tematicasSeleccionadas.add(tematicaDTO.getId().toString());
				}
			}			
		} 
		catch (Exception e)
		{
			handleWSException(e);
		}
	}
	
	public String guardarSitio()
	{
		try
		{
			if(getSitioDTO() == null)
			{
				addBeanError("Sitio no puede ser nulo");			
			}
			else
			{
				// Transformo las tematicas seleccionadas
				List<TematicaDTO> listaTematicasDTO = new ArrayList<TematicaDTO>();
				if(tematicasSeleccionadas != null)
				{
					for(String idTematica : tematicasSeleccionadas)
					{
						TematicaDTO tematicaDTO = new TematicaDTO();
						
						tematicaDTO.setId(Long.valueOf(idTematica));
						
						listaTematicasDTO.add(tematicaDTO);
					}
				}
				getSitioDTO().setListaTematicasDTO(listaTematicasDTO.toArray(new TematicaDTO[]{}));
				
				if(UtilesWeb.isNullOrZero(getSitioDTO().getId()))
				{
					if(validar(VALIDAR_CREAR))
					{
						Long idSitioNuevo = getSitioPort().insertar(getSitioDTO());
						
						setSitioDTO(getSitioPort().obtener(idSitioNuevo));
						
						addBeanMessage("Sitio guardado correctamente");
					}
				}
				else
				{
					if(validar(VALIDAR_MODIFICAR))
					{
						getSitioPort().actualizar(getSitioDTO());	
						
						setSitioDTO(getSitioPort().obtener(getSitioDTO().getId()));
						
						addBeanMessage("Sitio guardado correctamente");
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
	
	public String toListadoSitios()
	{
		return TO_LISTADO_SITIOS;
	}

	private boolean validar(int opValidar)
	{
		boolean isValid = true;
		
		if(opValidar == VALIDAR_CREAR || opValidar == VALIDAR_MODIFICAR)
		{
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
			if(tematicasSeleccionadas == null || tematicasSeleccionadas.isEmpty())
			{
				addBeanError("Debe seleccionar al menos una temática.");
				isValid = false;
			}
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

	public List<String> getTematicasSeleccionadas()
	{
		return tematicasSeleccionadas;
	}

	public void setTematicasSeleccionadas(List<String> tematicasSeleccionadas)
	{
		this.tematicasSeleccionadas = tematicasSeleccionadas;
	}
}
