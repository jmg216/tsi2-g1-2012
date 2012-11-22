package com.geored.backoffice.managedBean.eventos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.geored.backoffice.managedBean.BaseBean;
import com.geored.backoffice.utiles.UtilesWeb;
import com.geored.negocio.EventoDTO;
import com.geored.negocio.TematicaDTO;

@ManagedBean(name="gestionEventoBean")
@RequestScoped
public class GestionEventoBean extends BaseBean implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5348254664595085666L;
	
	private static final int VALIDAR_CREAR = 1;
	
	private static final int VALIDAR_MODIFICAR = 2; 
	
	private static final String EVENTO_DTO_KEY = "EVENTO_DTO_KEY";
	
	private static final String TO_LISTADO_EVENTOS = "to_listado_eventos";

	private EventoDTO eventoDTO = new EventoDTO();
	
	private List<TematicaDTO> listaTematicas = new ArrayList<TematicaDTO>();
	
	private List<String> tematicasSeleccionadas = new ArrayList<String>();
	
	public GestionEventoBean()
	{	
		eventoDTO = (EventoDTO) getFlashAttribute(EVENTO_DTO_KEY);
		
		if(eventoDTO == null)
		{
			String idEvento = getRequestParameter("idEvento");                
			
			if(UtilesWeb.isNullOrEmpty(idEvento))
			{
				eventoDTO = new EventoDTO();
			}
			else
			{
				try
				{
					eventoDTO = getEventoPort().obtener(Long.valueOf(idEvento));
				} 
				catch (Exception e)
				{
					addBeanError(e.getMessage());
				} 
			}
			
			setFlashAttribute(EVENTO_DTO_KEY, eventoDTO);
		}		
		
		cargarDatosIniciales();
	}

	private void cargarDatosIniciales()
	{
		try
		{
			TematicaDTO[] arrayTematicas = getGlobalPort().obtenerListadoTematicas();
			
			if(arrayTematicas != null)
			{
				listaTematicas = Arrays.asList(arrayTematicas);
			}
			
			// Cargo los ids de las tematicas seleccionadas en el sitio
			tematicasSeleccionadas = new ArrayList<String>();
			if(eventoDTO.getListaTematicasDTO() != null)
			{
				for(TematicaDTO tematicaDTO : eventoDTO.getListaTematicasDTO())
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
	
	public String guardarEvento()
	{
		try
		{
			if(getEventoDTO() == null)
			{
				addBeanError("Evento no puede ser nulo");			
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
				getEventoDTO().setListaTematicasDTO(listaTematicasDTO.toArray(new TematicaDTO[]{}));
				
				// Pregunto si es creacion o edicion
				if(UtilesWeb.isNullOrZero(getEventoDTO().getId()))
				{
					if(validar(VALIDAR_CREAR))
					{
						Long idEventoNuevo = getEventoPort().insertar(getEventoDTO());
						
						setEventoDTO(getEventoPort().obtener(idEventoNuevo));
						
						addBeanMessage("Evento guardado correctamente");
					}
				}
				else
				{
					if(validar(VALIDAR_MODIFICAR))
					{
						getEventoPort().actualizar(getEventoDTO());	
						
						setEventoDTO(getEventoPort().obtener(getEventoDTO().getId()));
						
						addBeanMessage("Evento guardado correctamente");
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
			if(UtilesWeb.isNullOrEmpty(getEventoDTO().getNombre()))
			{
				addBeanError("gestionEventoForm:nombreEvento", "Obligatorio");
				isValid = false;
			}
			if(UtilesWeb.isNullOrEmpty(getEventoDTO().getDescripcion()))
			{
				addBeanError("gestionEventoForm:descripcionEvento", "Obligatorio");
				isValid = false;
			}
			if(getEventoDTO().getFechaInicio() == null)
			{
				addBeanError("gestionEventoForm:fechaInicioEvento", "Obligatorio");
				isValid = false;
			}
			if(getEventoDTO().getFechaFin() == null)
			{
				addBeanError("gestionEventoForm:fechaFinEvento", "Obligatorio");
				isValid = false;
			}
			if(UtilesWeb.isNullOrEmpty(getEventoDTO().getUbicacionGeografica()))
			{
				addBeanError("gestionEventoForm:ubicacionGeografica", "Obligatorio");
				isValid = false;
			}
			if(getEventoDTO().getFechaInicio() != null && getEventoDTO().getFechaFin() != null)
			{
				if(getEventoDTO().getFechaFin().before(getEventoDTO().getFechaInicio()))
				{
					addBeanError("gestionEventoForm:fechaFinEvento", "La fecha fin debe se mayor a la inicial");
					isValid = false;
				}
			}
			if(tematicasSeleccionadas == null || tematicasSeleccionadas.isEmpty())
			{
				addBeanError("gestionEventoForm:tematicasEvento", "Debe seleccionar al menos una.");
				isValid = false;
			}
		}
		
		return isValid;
	}
	
	public String toListadoEventos()
	{
		return TO_LISTADO_EVENTOS;
	}

	public EventoDTO getEventoDTO()
	{
		return eventoDTO;
	}

	public void setEventoDTO(EventoDTO eventoDTO)
	{
		this.eventoDTO = eventoDTO;
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
