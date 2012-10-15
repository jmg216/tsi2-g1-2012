package com.geored.persistencia;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.geored.dominio.Administrador;
import com.geored.dominio.ContenidoSitio;
import com.geored.dto.AdministradorDTO;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ContenidoSitioDAOImpl extends GenericDAOBase<ContenidoSitio> implements ContenidoSitioDAO
{

	@Override
	public void dtoToEntity(AdministradorDTO source, Administrador target)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void entityToDto(Administrador source, AdministradorDTO target)
	{
		// TODO Auto-generated method stub
		
	}
	
}