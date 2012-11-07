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
	public Tematica toEntity(TematicaDTO source)
	{
		Tematica target = new Tematica();
		
		target.setNombre(source.getNombre());
		target.setDescripcion(source.getDescripcion());
		
		return target;
	}

	@Override
	public TematicaDTO toDto(Tematica source)
	{
		TematicaDTO target = new TematicaDTO();
		
		target.setId(source.getId());
		target.setNombre(source.getNombre());
		target.setDescripcion(source.getDescripcion());
		
		return target;
	}	
}