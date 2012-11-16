package com.geored.backoffice.managedBean.eventos;

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
import com.geored.negocio.EventoDTO;

@ManagedBean(name="listadoEventosBean")
@RequestScoped
public class ListadoEventosBean extends BaseBean implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5206259587791039366L;
	
	private static final String TO_GESTION_EVENTO = "to_gestion_evento";
	
	private Long idEvento;
	
	private List<EventoDTO> listaEventos = new ArrayList<EventoDTO>();
	
	public ListadoEventosBean()
	{
		try
		{	EventoDTO[] arrayEventos = getEventoPort().obtenerListado();
		
			if(arrayEventos != null)
			{
				listaEventos = Arrays.asList(arrayEventos);
			}
			else
			{
				listaEventos = new ArrayList<EventoDTO>();
			}
		} 
		catch (Exception e)
		{
			handleWSException(e);
		} 
	}
	
	public String toGestionEvento()
	{
		return TO_GESTION_EVENTO;
	}

	public Long getIdEvento()
	{
		return idEvento;
	}

	public void setIdEvento(Long idEvento)
	{
		this.idEvento = idEvento;
	}

	public List<EventoDTO> getListaEventos()
	{
		return listaEventos;
	}

	public void setListaEventos(List<EventoDTO> listaEventos)
	{
		this.listaEventos = listaEventos;
	}
}
