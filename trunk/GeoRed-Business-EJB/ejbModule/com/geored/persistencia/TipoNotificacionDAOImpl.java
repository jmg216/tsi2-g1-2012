package com.geored.persistencia;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.geored.dominio.TipoNotificacion;
import com.geored.dto.TipoNotificacionDTO;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TipoNotificacionDAOImpl extends GenericDAOBase<TipoNotificacion, TipoNotificacionDTO> implements TipoNotificacionDAO
{

	@Override
	public TipoNotificacion toEntity(TipoNotificacionDTO source)
	{
		TipoNotificacion target = new TipoNotificacion();
		
		target.setNombre(source.getNombre());
		
		return target;
	}

	@Override
	public TipoNotificacionDTO toDto(TipoNotificacion source)
	{
		TipoNotificacionDTO target = new TipoNotificacionDTO();
		
		target.setId(source.getId());
		target.setNombre(source.getNombre());
		
		return target;
	}
	
}