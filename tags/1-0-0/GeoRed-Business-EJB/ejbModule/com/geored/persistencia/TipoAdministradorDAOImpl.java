package com.geored.persistencia;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.geored.dominio.TipoAdministrador;
import com.geored.dto.TipoAdministradorDTO;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TipoAdministradorDAOImpl extends GenericDAOBase<TipoAdministrador> implements TipoAdministradorDAO
{

	@Override
	public void dtoToEntity(TipoAdministradorDTO source, TipoAdministrador target)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void entityToDto(TipoAdministrador source, TipoAdministradorDTO target)
	{
		// TODO Auto-generated method stub
		
	}
	
}