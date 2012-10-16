package com.geored.persistencia;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.geored.dominio.Evento;
import com.geored.dto.EventoDTO;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class EventoDAOImpl extends GenericDAOBase<Evento, EventoDTO> implements EventoDAO
{

	@Override
	public void dtoToEntity(EventoDTO source, Evento target)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void entityToDto(Evento source, EventoDTO target)
	{
		// TODO Auto-generated method stub
		
	}
	
}