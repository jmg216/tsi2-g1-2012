package com.geored.persistencia;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.geored.dominio.Administrador;
import com.geored.dto.AdministradorDTO;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AdministradorDAOImpl extends GenericDAOBase<Administrador, AdministradorDTO> implements AdministradorDAO
{
	@Override
	public void dtoToEntity(AdministradorDTO source, Administrador target)
	{		
	}

	@Override
	public void entityToDto(Administrador source, AdministradorDTO target)
	{	
	}
}