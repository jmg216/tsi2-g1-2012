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
	public void toEntity(TematicaDTO source, Tematica target)
	{
		target.setNombre(source.getNombre());
		target.setDescripcion(source.getDescripcion());
	}

	@Override
	public void toDto(Tematica source, TematicaDTO target)
	{
		target.setId(source.getId());
		target.setNombre(source.getNombre());
		target.setDescripcion(source.getDescripcion());
	}	
}