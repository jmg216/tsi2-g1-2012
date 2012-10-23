package com.geored.persistencia;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.geored.dominio.TipoNotificacionUsuario;
import com.geored.dto.TipoNotificacionUsuarioDTO;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TipoNotificacionUsuarioDAOImpl extends GenericDAOBase<TipoNotificacionUsuario, TipoNotificacionUsuarioDTO> implements TipoNotificacionUsuarioDAO
{

	@Override
	public void dtoToEntity(TipoNotificacionUsuarioDTO source, TipoNotificacionUsuario target)
	{
	}

	@Override
	public void entityToDto(TipoNotificacionUsuario source, TipoNotificacionUsuarioDTO target)
	{
		target.setId(source.getId());
		
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
	}
	
}