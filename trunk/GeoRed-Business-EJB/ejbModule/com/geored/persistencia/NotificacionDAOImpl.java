package com.geored.persistencia;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.geored.dominio.Notificacion;
import com.geored.dto.NotificacionDTO;
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
		
	}

	@Override
	public void toDto(Notificacion source, NotificacionDTO target)
	{
		target.setId(source.getId());
		target.setDescripcion(source.getDescripcion());
		target.setLeida(source.isLeida());
		
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
}