package com.geored.persistencia;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.geored.dominio.Notificacion;
import com.geored.dto.NotificacionDTO;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class NotificacionDAOImpl extends GenericDAOBase<Notificacion> implements NotificacionDAO
{

	@Override
	public void dtoToEntity(NotificacionDTO source, Notificacion target)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void entityToDto(Notificacion source, NotificacionDTO target)
	{
		// TODO Auto-generated method stub
		
	}
	
}