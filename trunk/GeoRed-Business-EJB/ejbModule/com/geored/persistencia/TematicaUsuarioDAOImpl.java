package com.geored.persistencia;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.geored.dominio.TematicaUsuario;
import com.geored.dto.TematicaUsuarioDTO;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TematicaUsuarioDAOImpl extends GenericDAOBase<TematicaUsuario> implements TematicaUsuarioDAO
{

	@Override
	public void dtoToEntity(TematicaUsuarioDTO source, TematicaUsuario target)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void entityToDto(TematicaUsuario source, TematicaUsuarioDTO target)
	{
		// TODO Auto-generated method stub
		
	}
	
}