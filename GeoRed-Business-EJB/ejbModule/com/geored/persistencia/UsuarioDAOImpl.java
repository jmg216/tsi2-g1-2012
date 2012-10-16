package com.geored.persistencia;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.geored.dominio.Usuario;
import com.geored.dto.UsuarioDTO;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class UsuarioDAOImpl extends GenericDAOBase<Usuario, UsuarioDTO> implements UsuarioDAO
{

	@Override
	public void dtoToEntity(UsuarioDTO source, Usuario target)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void entityToDto(Usuario source, UsuarioDTO target)
	{
		// TODO Auto-generated method stub
		
	}
	
}