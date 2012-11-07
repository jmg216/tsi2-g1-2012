package com.geored.persistencia;

import java.sql.Timestamp;

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
	public Evento toEntity(EventoDTO source)
	{
		Evento target = new Evento();
		
		target.setNombre(source.getNombre());
		target.setDescripcion(source.getDescripcion());
		target.setFechaInicio(new Timestamp(source.getFechaInicio().getTime()));
		target.setFechaFin(new Timestamp(source.getFechaFin().getTime()));
		target.setUbicacionGeografica(source.getUbicacionGeogrica());
		
		return target;
	}

	@Override
	public EventoDTO toDto(Evento source)
	{
		EventoDTO target = new EventoDTO();
		
		target.setId(source.getId());
		target.setNombre(source.getNombre());
		target.setDescripcion(source.getDescripcion());
		target.setFechaInicio(source.getFechaInicio());
		target.setFechaFin(source.getFechaFin());
		
		return target;
	}
	
}