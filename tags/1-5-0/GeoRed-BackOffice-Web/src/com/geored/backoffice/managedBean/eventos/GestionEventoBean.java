package com.geored.backoffice.managedBean.eventos;

import java.io.Serializable;
import java.rmi.RemoteException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.xml.rpc.ServiceException;

import com.geored.backoffice.managedBean.BaseBean;
import com.geored.backoffice.utiles.UtilesWeb;
import com.geored.negocio.DaoException;
import com.geored.negocio.EventoDTO;
import com.geored.negocio.NegocioException;

@ManagedBean(name="gestionEventoBean")
@RequestScoped
public class GestionEventoBean extends BaseBean implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5348254664595085666L;
	
	private static final String TO_LISTADO_EVENTOS = "to_listado_eventos";
	
	private EventoDTO eventoDTO = new EventoDTO();
	
	public GestionEventoBean()
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

	public void guardarEvento()
	{
		addBeanMessage("Evento guardado correctamente");
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
}
