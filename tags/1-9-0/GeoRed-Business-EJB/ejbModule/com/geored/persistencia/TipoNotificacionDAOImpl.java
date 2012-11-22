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
	public void toEntity(TipoNotificacionDTO source, TipoNotificacion target)
	{
		target.setNombre(source.getNombre());
	}

	@Override
	public void toDto(TipoNotificacion source, TipoNotificacionDTO target)
	{
		target.setId(source.getId());
		target.setNombre(source.getNombre());
	}
	
}