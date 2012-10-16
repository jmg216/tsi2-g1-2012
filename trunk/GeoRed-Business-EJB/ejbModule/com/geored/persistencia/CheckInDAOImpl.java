package com.geored.persistencia;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.geored.dominio.CheckIn;
import com.geored.dto.CheckInDTO;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class CheckInDAOImpl extends GenericDAOBase<CheckIn, CheckInDTO> implements CheckInDAO
{

	@Override
	public void dtoToEntity(CheckInDTO source, CheckIn target)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void entityToDto(CheckIn source, CheckInDTO target)
	{
		// TODO Auto-generated method stub
		
	}	
}