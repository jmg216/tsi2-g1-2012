package com.geored.persistencia;

import java.sql.Timestamp;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.geored.dominio.Evento;
import com.geored.dominio.Tematica;
import com.geored.dto.EventoDTO;
import com.geored.dto.TematicaDTO;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class EventoDAOImpl extends GenericDAOBase<Evento, EventoDTO> implements EventoDAO
{

	@EJB
	private TematicaDAO tematicaDAO;
	
	@Override
	public void toEntity(EventoDTO source, Evento target)
	{
		target.setNombre(source.getNombre());
		target.setDescripcion(source.getDescripcion());
		target.setFechaInicio(new Timestamp(source.getFechaInicio().getTime()));
		target.setFechaFin(new Timestamp(source.getFechaFin().getTime()));
		target.setUbicacionGeografica(source.getUbicacionGeogrica());
	}

	@Override
	public void toDto(Evento source, EventoDTO target)
	{
		target.setId(source.getId());
		target.setNombre(source.getNombre());
		target.setDescripcion(source.getDescripcion());
		target.setFechaInicio(source.getFechaInicio());
		target.setFechaFin(source.getFechaFin());
		
		target.setListaTematicasDTO(new ArrayList<TematicaDTO>());
		if(source.getListaTematicas() != null)
		{			
			target.setListaTematicasDTO(tematicaDAO.toDtoList(source.getListaTematicas()));
		}
	}
	
}