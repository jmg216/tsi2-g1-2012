package com.geored.persistencia;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.geored.dominio.Tematica;
import com.geored.dto.TematicaDTO;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TematicaDAOImpl extends GenericDAOBase<Tematica, TematicaDTO> implements TematicaDAO
{

	@Override
	public void dtoToEntity(TematicaDTO source, Tematica target)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void entityToDto(Tematica source, TematicaDTO target)
	{
		// TODO Auto-generated method stub
		
	}
	
}