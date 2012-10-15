package com.geored.persistencia;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.geored.dominio.TipoNotificacion;
import com.geored.dto.TipoNotificacionDTO;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TipoNotificacionDAOImpl extends GenericDAOBase<TipoNotificacion> implements TipoNotificacionDAO
{

	@Override
	public void dtoToEntity(TipoNotificacionDTO source, TipoNotificacion target)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void entityToDto(TipoNotificacion source, TipoNotificacionDTO target)
	{
		// TODO Auto-generated method stub
		
	}
	
}