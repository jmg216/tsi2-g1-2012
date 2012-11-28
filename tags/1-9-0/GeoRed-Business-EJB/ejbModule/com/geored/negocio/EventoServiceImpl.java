package com.geored.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.jws.WebMethod;
import javax.jws.WebService;

import com.geored.dominio.Evento;
import com.geored.dominio.Tematica;
import com.geored.dto.EventoDTO;
import com.geored.dto.TematicaDTO;
import com.geored.exceptions.DaoException;
import com.geored.exceptions.NegocioException;
import com.geored.persistencia.EventoDAO;
import com.geored.persistencia.TematicaDAO;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@WebService
public class EventoServiceImpl implements EventoService
{
	@EJB
	private EventoDAO eventoDAO;
	
	@EJB
	private TematicaDAO tematicaDAO;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public Long insertar(EventoDTO eventoDTO)  throws NegocioException, DaoException
	{	
		if(eventoDAO.obtenerPorNombre(eventoDTO.getNombre(), false) != null)
		{
			throw new NegocioException("Ya existe un evento activo con este nombre"); 
		}
		
		Evento eventoEntity = eventoDAO.toEntity(eventoDTO);
		
		asociarTematicas(eventoDTO, eventoEntity);
		
		eventoDAO.insertar(eventoEntity);
		
		return eventoEntity.getId();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public void actualizar(EventoDTO eventoDTO)  throws NegocioException, DaoException
	{
		try
		{
			Evento eventoEntity = (Evento) eventoDAO.obtener(eventoDTO.getId(), false);
			
			if(eventoEntity == null)
			{
				throw new NegocioException("Evento no encontrado");
			}
			
			eventoDAO.toEntity(eventoDTO, eventoEntity);
			
			asociarTematicas(eventoDTO, eventoEntity);
			
			eventoDAO.actualizar(eventoEntity);			
		}
		catch(Throwable e)
		{
			throw new DaoException(e);
		}
	}
	
	private void asociarTematicas(EventoDTO eventoDTO, Evento eventoEntity) throws DaoException, NegocioException
	{
		// Cargo la lista de tematicas para el sitio
		if(eventoEntity.getListaTematicas() == null)
		{
			eventoEntity.setListaTematicas(new ArrayList<Tematica>());
		}
		else
		{
			eventoEntity.getListaTematicas().clear();
		}
		
		if(eventoDTO.getListaTematicasDTO() != null)
		{			
			for(TematicaDTO tematicaDTO : eventoDTO.getListaTematicasDTO())
			{
				Tematica tematica = (Tematica) tematicaDAO.obtener(tematicaDTO.getId(), false);
				
				if(tematica == null)
				{
					throw new NegocioException("La tematica (" + tematicaDTO.getId() + ") no existe");
				}
				
				eventoEntity.getListaTematicas().add(tematica);
			}
		}
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public void eliminar(Long idEvento)  throws NegocioException, DaoException
	{
		Evento eventoEntity = (Evento) eventoDAO.obtener(idEvento, false);
		
		if(eventoEntity == null)
		{
			throw new NegocioException("Evento no encontrado");
		}
		
		eventoDAO.eliminar(eventoEntity);
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public EventoDTO obtener(Long idEvento)  throws NegocioException, DaoException
	{
		EventoDTO eventoDTO = (EventoDTO) eventoDAO.obtener(idEvento, true);
		
		if(eventoDTO == null)
		{
			throw new NegocioException("Evento no encontrado");
		}
		
		return eventoDTO;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public List<EventoDTO> obtenerListado() throws DaoException
	{
		return eventoDAO.obtenerListado(true);	
	}	
}