package com.geored.persistencia;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.geored.dominio.Amistad;
import com.geored.dto.AmistadDTO;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AmistadDAOImpl extends GenericDAOBase<Amistad> implements AmistadDAO
{

	@Override
	public void dtoToEntity(AmistadDTO source, Amistad target)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void entityToDto(Amistad source, AmistadDTO target)
	{
		// TODO Auto-generated method stub
		
	}	
}