package com.geored.persistencia;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.geored.dominio.CompraOferta;
import com.geored.dto.CompraOfertaDTO;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class CompraOfertaDAOImpl extends GenericDAOBase<CompraOferta> implements CompraOfertaDAO
{

	@Override
	public void dtoToEntity(CompraOfertaDTO source, CompraOferta target)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void entityToDto(CompraOferta source, CompraOfertaDTO target)
	{
		// TODO Auto-generated method stub
		
	}
	
}