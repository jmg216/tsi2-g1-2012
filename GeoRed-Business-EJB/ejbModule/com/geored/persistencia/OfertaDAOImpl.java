package com.geored.persistencia;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.geored.dominio.Oferta;
import com.geored.dto.OfertaDTO;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class OfertaDAOImpl extends GenericDAOBase<Oferta, OfertaDTO> implements OfertaDAO
{

	@Override
	public void dtoToEntity(OfertaDTO source, Oferta target)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void entityToDto(Oferta source, OfertaDTO target)
	{
		// TODO Auto-generated method stub
		
	}
	
}