package com.geored.persistencia;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.geored.dominio.TematicaOferta;
import com.geored.dto.TematicaOfertaDTO;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TematicaOfertaDAOImpl extends GenericDAOBase<TematicaOferta, TematicaOfertaDTO> implements TematicaOfertaDAO
{

	@Override
	public void dtoToEntity(TematicaOfertaDTO source, TematicaOferta target)
	{
	}

	@Override
	public void entityToDto(TematicaOferta source, TematicaOfertaDTO target)
	{
		target.setId(source.getId());
		
		if(source.getTematica() != null)
		{
			target.setIdTematica(source.getTematica().getId());
			target.setNombreTematica(source.getTematica().getNombre());
		}
		
		if(source.getOferta() != null)
		{
			target.setIdOferta(source.getOferta().getId());
			target.setNombreOferta(source.getOferta().getNombre());
		}
	}
	
}