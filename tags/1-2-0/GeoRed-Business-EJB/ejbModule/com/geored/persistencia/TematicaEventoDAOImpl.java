package com.geored.persistencia;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.geored.dominio.TematicaEvento;
import com.geored.dto.TematicaEventoDTO;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TematicaEventoDAOImpl extends GenericDAOBase<TematicaEvento, TematicaEventoDTO> implements TematicaEventoDAO
{

	@Override
	public void dtoToEntity(TematicaEventoDTO source, TematicaEvento target)
	{
	}

	@Override
	public void entityToDto(TematicaEvento source, TematicaEventoDTO target)
	{
		target.setId(source.getId());
		
		if(source.getTematica() != null)
		{
			target.setIdTematica(source.getTematica().getId());
			target.setNombreTematica(source.getTematica().getNombre());
		}
		
		if(source.getEvento() != null)
		{
			target.setIdEvento(source.getEvento().getId());
			target.setNombreEvento(source.getEvento().getNombre());
		}
	}
	
}