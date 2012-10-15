package com.geored.persistencia;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.geored.dominio.TematicaOferta;
import com.geored.dto.TematicaOfertaDTO;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TematicaOfertaDAOImpl extends GenericDAOBase<TematicaOferta> implements TematicaOfertaDAO
{

	@Override
	public void dtoToEntity(TematicaOfertaDTO source, TematicaOferta target)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void entityToDto(TematicaOferta source, TematicaOfertaDTO target)
	{
		// TODO Auto-generated method stub
		
	}
	
}