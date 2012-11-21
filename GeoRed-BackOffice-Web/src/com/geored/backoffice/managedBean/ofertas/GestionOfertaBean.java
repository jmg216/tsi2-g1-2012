package com.geored.backoffice.managedBean.ofertas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.geored.backoffice.managedBean.BaseBean;
import com.geored.backoffice.utiles.UtilesWeb;
import com.geored.negocio.LocalDTO;
import com.geored.negocio.OfertaDTO;
import com.geored.negocio.TematicaDTO;

@ManagedBean(name="gestionOfertaBean")
@RequestScoped
public class GestionOfertaBean extends BaseBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6757255144084899088L;

	private static final String TO_LISTADO_OFERTAS = "to_listado_ofertas";

	private static final String OFERTA_DTO_KEY = "OFERTA_DTO_KEY"; 
	
	private static final int VALIDAR_CREAR = 1;
	
	private static final int VALIDAR_MODIFICAR = 2;
	
	private OfertaDTO ofertaDTO = new OfertaDTO();

	private List<LocalDTO> listaLocales = new ArrayList<LocalDTO>();
	
	private List<TematicaDTO> listaTematicas = new ArrayList<TematicaDTO>();
	
	private List<String> tematicasSeleccionadas = new ArrayList<String>();
	
	public GestionOfertaBean()
	{	
		ofertaDTO = (OfertaDTO) getFlashAttribute(OFERTA_DTO_KEY);
		
		if(ofertaDTO == null)
		{
			String idOferta = getRequestParameter("idOferta");
			
			if(UtilesWeb.isNullOrEmpty(idOferta))
			{
				ofertaDTO = new OfertaDTO();
			}
			else
			{
				try
				{
					ofertaDTO = getOfertaPort().obtener(Long.valueOf(idOferta));
				} 
				catch (Exception e)
				{
					handleWSException(e);
				} 
			}
			
			setFlashAttribute(OFERTA_DTO_KEY, ofertaDTO);
		}		
		
		cargarDatosIniciales();
	}
	
	private void cargarDatosIniciales()
	{
		try
		{
			// Locales
			LocalDTO[] arrayLocalesDTO = getEmpresaPort().obtenerListadoLocalesPorEmpresa(UtilesWeb.obtenerEmpresaAdministrada().getId());
					
			if(arrayLocalesDTO != null)
			{
				listaLocales = Arrays.asList(arrayLocalesDTO);
			}
			
			// Tematicas
			TematicaDTO[] arrayTematicasDTO = getGlobalPort().obtenerListadoTematicas();
			
			if(arrayTematicasDTO != null)
			{
				listaTematicas = Arrays.asList(arrayTematicasDTO);
			}	
			
			// Cargo los ids de las tematicas seleccionadas en el sitio
			tematicasSeleccionadas = new ArrayList<String>();
			if(ofertaDTO.getListaTematicasDTO() != null)
			{
				for(TematicaDTO tematicaDTO : ofertaDTO.getListaTematicasDTO())
				{
					tematicasSeleccionadas.add(tematicaDTO.getId().toString());
				}
			}		
		} 
		catch(Exception e)
		{
			handleWSException(e);
		}
	}

	public String guardarOferta()
	{
		try
		{
			if(getOfertaDTO() == null)
			{
				addBeanError("Oferta no puede ser nula");
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
				getOfertaDTO().setListaTematicasDTO(listaTematicasDTO.toArray(new TematicaDTO[]{}));
				
				// Pregunto si es creacion o edicion
				if(UtilesWeb.isNullOrZero(getOfertaDTO().getId()))
				{
					if(validar(VALIDAR_CREAR))
					{
						Long idOfertaNueva = getOfertaPort().insertar(getOfertaDTO());
						
						setOfertaDTO(getOfertaPort().obtener(idOfertaNueva));
						
						addBeanMessage("Oferta guardada correctamente");
					}
				}
				else
				{
					if(validar(VALIDAR_MODIFICAR))
					{
						getOfertaPort().actualizar(getOfertaDTO());	
						
						setOfertaDTO(getOfertaPort().obtener(getOfertaDTO().getId()));
						
						addBeanMessage("Oferta guardada correctamente");
					}
				}
			}
		}
		catch(Exception e)
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
			if(UtilesWeb.isNullOrEmpty(getOfertaDTO().getNombre()))
			{
				addBeanError("gestionOfertaForm:nombreOferta", "Obligatorio");
				isValid = false;
			}			
			if(UtilesWeb.isNullOrEmpty(getOfertaDTO().getDescripcion()))
			{
				addBeanError("gestionOfertaForm:descripcionOferta", "Obligatorio");
				isValid = false;
			}			
			if(getOfertaDTO().getCosto() == null)
			{
				addBeanError("gestionOfertaForm:costoOferta", "Obligatorio");
				isValid = false;
			}			
			if(UtilesWeb.isNullOrEmpty(getOfertaDTO().getUrlImagen()))
			{
				addBeanError("gestionOfertaForm:imagenOferta", "Obligatorio");
				isValid = false;
			}
			if(getOfertaDTO().getFechaInicio() == null)
			{
				addBeanError("gestionOfertaForm:fechaInicioOferta", "Obligatorio");
				isValid = false;
			}
			if(getOfertaDTO().getFechaFin() == null)
			{
				addBeanError("gestionOfertaForm:fechaFinOferta", "Obligatorio");
				isValid = false;
			}
			if(UtilesWeb.isNullOrZero(getOfertaDTO().getIdLocal()))
			{
				addBeanError("gestionOfertaForm:localOferta", "Obligatorio");
				isValid = false;
			}
			if(tematicasSeleccionadas == null || tematicasSeleccionadas.isEmpty())
			{
				addBeanError("gestionOfertaForm:tematicasOferta", "Debe seleccionar al menos una");
				isValid = false;
			}
		}
		
		return isValid;
	}
	
	public String toListadoOfertas()
	{
		return TO_LISTADO_OFERTAS;
	}

	public OfertaDTO getOfertaDTO() 
	{
		return ofertaDTO;
	}

	public void setOfertaDTO(OfertaDTO ofertaDTO) 
	{
		this.ofertaDTO = ofertaDTO;
	}

	public List<LocalDTO> getListaLocales()
	{
		return listaLocales;
	}

	public void setListaLocales(List<LocalDTO> listaLocales)
	{
		this.listaLocales = listaLocales;
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
