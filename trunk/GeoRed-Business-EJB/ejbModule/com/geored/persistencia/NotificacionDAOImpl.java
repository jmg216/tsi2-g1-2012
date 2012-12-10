package com.geored.persistencia;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.Query;

import com.geored.dominio.Notificacion;
import com.geored.dto.NotificacionDTO;
import com.geored.exceptions.DaoException;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class NotificacionDAOImpl extends GenericDAOBase<Notificacion, NotificacionDTO> implements NotificacionDAO
{

	@Override
	public void toEntity(NotificacionDTO source, Notificacion target)
	{
		target.setDescripcion(source.getDescripcion());
		target.setLeida(source.isLeida());	
		target.setMetadataNotif(source.getMetadataNotif());
	}

	@Override
	public void toDto(Notificacion source, NotificacionDTO target)
	{
		target.setId(source.getId());
		target.setDescripcion(source.getDescripcion());
		target.setLeida(source.isLeida());
		target.setMetadataNotif(source.getMetadataNotif());
		
		if(source.getUsuarioDestino() != null)
		{
			target.setIdUsuarioDestino(source.getUsuarioDestino().getId());
			target.setNombreUsuarioDestino(source.getUsuarioDestino().getNombre());
		}
		
		if(source.getTipoNotificacion() != null)
		{
			target.setIdTipoNotificacion(source.getTipoNotificacion().getId());
			target.setNombreTipoNotificacion(source.getTipoNotificacion().getNombre());
		}
	}

	@Override
	public List obtenerListadoPorTipoYUsuarioDestino(Long idTipoNotificacion, Long idUsuarioDestino, boolean toDTO) throws DaoException
	{
		try
		{
			StringBuilder sbQuery = new StringBuilder("select n from com.geored.dominio.Notificacion n where n.usuarioDestino.id = ?1");			
			
			if(idTipoNotificacion != null)
			{
				sbQuery.append(" and n.tipoNotificacion.id = ?2 ");
			}
			
			Query query = em.createQuery(sbQuery.toString());
			
	        query.setParameter(1, idUsuarioDestino);
			
	        if(idTipoNotificacion != null)
	        {
	        	query.setParameter(2, idTipoNotificacion);
	        }
	        
	        List listaNotificaciones = query.getResultList();
	        
	        if(toDTO)
	        {
	             return toDtoList(listaNotificaciones);
	        }
	       
	        return listaNotificaciones;
		}
		catch(Throwable e)
		{
			throw new DaoException(e.getMessage());		
		}
	}
}