package com.geored.persistencia;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.geored.dominio.Local;
import com.geored.dto.LocalDTO;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class LocalDAOImpl extends GenericDAOBase<Local> implements LocalDAO
{

	@Override
	public void dtoToEntity(LocalDTO source, Local target)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void entityToDto(Local source, LocalDTO target)
	{
		// TODO Auto-generated method stub
		
	}
	
}