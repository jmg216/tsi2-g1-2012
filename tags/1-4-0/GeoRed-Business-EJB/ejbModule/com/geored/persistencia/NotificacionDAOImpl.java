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
	public Notificacion toEntity(NotificacionDTO source)
	{
		Notificacion target = new Notificacion();
		
		target.setNombre(source.getNombre());
		
		return target;
	}

	@Override
	public NotificacionDTO toDto(Notificacion source)
	{
		NotificacionDTO target = new NotificacionDTO();
		
		target.setId(source.getId());
		target.setNombre(source.getNombre());
		
		if(source.getUsuario() != null)
		{
			target.setIdUsuario(source.getUsuario().getId());
			target.setNombreUsuario(source.getUsuario().getNombre());
		}
		
		if(source.getTipoNotificacion() != null)
		{
			target.setIdTipoNotificacion(source.getTipoNotificacion().getId());
			target.setNombreTipoNotificacion(source.getTipoNotificacion().getNombre());
		}
		
		return target;
	}
}