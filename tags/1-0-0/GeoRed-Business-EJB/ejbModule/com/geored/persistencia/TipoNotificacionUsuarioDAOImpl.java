package com.geored.persistencia;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.geored.dominio.TipoNotificacionUsuario;
import com.geored.dto.TipoNotificacionUsuarioDTO;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TipoNotificacionUsuarioDAOImpl extends GenericDAOBase<TipoNotificacionUsuario> implements TipoNotificacionUsuarioDAO
{

	@Override
	public void dtoToEntity(TipoNotificacionUsuarioDTO source, TipoNotificacionUsuario target)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void entityToDto(TipoNotificacionUsuario source, TipoNotificacionUsuarioDTO target)
	{
		// TODO Auto-generated method stub
		
	}
	
}