package com.geored.persistencia;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.geored.dominio.EvaluacionOferta;
import com.geored.dto.EvaluacionOfertaDTO;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class EvaluacionOfertaDAOImpl extends GenericDAOBase<EvaluacionOferta> implements EvaluacionOfertaDAO
{

	@Override
	public void dtoToEntity(EvaluacionOfertaDTO source, EvaluacionOferta target)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void entityToDto(EvaluacionOferta source, EvaluacionOfertaDTO target)
	{
		// TODO Auto-generated method stub
		
	}
	
}