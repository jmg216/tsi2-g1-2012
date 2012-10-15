package com.geored.persistencia;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.geored.dominio.TematicaEvento;
import com.geored.dto.TematicaEventoDTO;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TematicaEventoDAOImpl extends GenericDAOBase<TematicaEvento> implements TematicaEventoDAO
{

	@Override
	public void dtoToEntity(TematicaEventoDTO source, TematicaEvento target)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void entityToDto(TematicaEvento source, TematicaEventoDTO target)
	{
		// TODO Auto-generated method stub
		
	}
	
}