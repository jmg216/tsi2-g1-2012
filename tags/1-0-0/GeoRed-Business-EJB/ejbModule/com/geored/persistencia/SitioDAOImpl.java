package com.geored.persistencia;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.geored.dominio.Sitio;
import com.geored.dto.SitioDTO;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class SitioDAOImpl extends GenericDAOBase<Sitio> implements SitioDAO
{

	@Override
	public void dtoToEntity(SitioDTO source, Sitio target)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void entityToDto(Sitio source, SitioDTO target)
	{
		// TODO Auto-generated method stub
		
	}
	
}