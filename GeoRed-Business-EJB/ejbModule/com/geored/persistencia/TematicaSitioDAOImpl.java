package com.geored.persistencia;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.geored.dominio.TematicaSitio;
import com.geored.dto.TematicaSitioDTO;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TematicaSitioDAOImpl extends GenericDAOBase<TematicaSitio> implements TematicaSitioDAO
{

	@Override
	public void dtoToEntity(TematicaSitioDTO source, TematicaSitio target)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void entityToDto(TematicaSitio source, TematicaSitioDTO target)
	{
		// TODO Auto-generated method stub
		
	}
	
}