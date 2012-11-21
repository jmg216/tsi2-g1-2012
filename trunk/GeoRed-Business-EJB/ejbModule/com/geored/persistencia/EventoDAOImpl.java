package com.geored.persistencia;

import java.sql.Timestamp;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.geored.dominio.Evento;
import com.geored.dominio.Oferta;
import com.geored.dominio.Tematica;
import com.geored.dto.EventoDTO;
import com.geored.dto.TematicaDTO;
import com.geored.exceptions.DaoException;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class EventoDAOImpl extends GenericDAOBase<Evento, EventoDTO> implements EventoDAO
{
	@EJB
	private TematicaDAO tematicaDAO;
	
	@Override
	public void toEntity(EventoDTO source, Evento target)
	{
		target.setNombre(source.getNombre());
		target.setDescripcion(source.getDescripcion());
		target.setFechaInicio(new Timestamp(source.getFechaInicio().getTime()));
		target.setFechaFin(new Timestamp(source.getFechaFin().getTime()));
		target.setUbicacionGeografica(source.getUbicacionGeografica());
	}

	@Override
	public void toDto(Evento source, EventoDTO target)
	{
		target.setId(source.getId());
		target.setNombre(source.getNombre());
		target.setDescripcion(source.getDescripcion());
		target.setFechaInicio(source.getFechaInicio());
		target.setFechaFin(source.getFechaFin());
		
		target.setListaTematicasDTO(new ArrayList<TematicaDTO>());
		if(source.getListaTematicas() != null)
		{			
			target.setListaTematicasDTO(tematicaDAO.toDtoList(source.getListaTematicas()));
		}
	}

	@Override
	public Object obtenerPorNombre(String nombre, boolean toDTO) throws DaoException
	{
		try
		{
			Query query = em.createQuery("select e from com.geored.dominio.Evento e where e.nombre = ?1");        
	        query.setParameter(1, nombre);
	        
	        try
	        {
	        	 Evento eventoEntity = (Evento) query.getSingleResult();
	        	 
	        	 if(toDTO)
	             {        	
	             	return toDto(eventoEntity);
	             }
	        	 
	        	 return eventoEntity;
	        }
	        catch(NoResultException e)
	        {
	        	return null;
	        }
		}
		catch(Throwable e)
		{
			throw new DaoException(e.getMessage());
		}
	}
	
}