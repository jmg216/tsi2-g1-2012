package com.geored.persistencia;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.geored.dominio.TematicaUsuario;
import com.geored.dto.TematicaUsuarioDTO;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TematicaUsuarioDAOImpl extends GenericDAOBase<TematicaUsuario, TematicaUsuarioDTO> implements TematicaUsuarioDAO
{

	@Override
	public void dtoToEntity(TematicaUsuarioDTO source, TematicaUsuario target)
	{
	}

	@Override
	public void entityToDto(TematicaUsuario source, TematicaUsuarioDTO target)
	{
		target.setId(source.getId());
		
		if(source.getTematica() != null)
		{
			target.setIdTematica(source.getTematica().getId());
			target.setNombreTematica(source.getTematica().getNombre());			
		}
		
		if(source.getUsuario() != null)
		{
			target.setIdUsuario(source.getUsuario().getId());
			target.setNombreUsuario(source.getUsuario().getNombre());
		}
			
	}
	
}