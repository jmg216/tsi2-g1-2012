package com.geored.persistencia;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.geored.dominio.TematicaSitio;
import com.geored.dto.TematicaSitioDTO;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TematicaSitioDAOImpl extends GenericDAOBase<TematicaSitio, TematicaSitioDTO> implements TematicaSitioDAO
{

	@Override
	public void dtoToEntity(TematicaSitioDTO source, TematicaSitio target)
	{
	}

	@Override
	public void entityToDto(TematicaSitio source, TematicaSitioDTO target)
	{
		target.setId(source.getId());
	
		if(source.getTematica() != null)
		{
			target.setIdTematica(source.getTematica().getId());
			target.setNombreTematica(source.getTematica().getNombre());			
		}
		
		if(source.getSitio() != null)
		{
			target.setIdSitio(source.getSitio().getId());
			target.setNombreSitio(source.getSitio().getNombre());
		}
	}
	
}