package com.geored.persistencia;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.geored.dominio.EvaluacionOferta;
import com.geored.dto.EvaluacionOfertaDTO;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class EvaluacionOfertaDAOImpl extends GenericDAOBase<EvaluacionOferta, EvaluacionOfertaDTO> implements EvaluacionOfertaDAO
{

	@Override
	public void dtoToEntity(EvaluacionOfertaDTO source, EvaluacionOferta target)
	{
		target.setEvaluacion(source.getEvaluacion());
	}

	@Override
	public void entityToDto(EvaluacionOferta source, EvaluacionOfertaDTO target)
	{
		target.setId(source.getId());
		target.setEvaluacion(source.getEvaluacion());
		
		if(source.getUsuario() != null)
		{
			target.setIdUsuario(source.getUsuario().getId());
			target.setNombreUsuario(source.getUsuario().getNombre());
		}
		
		if(source.getOferta() != null)
		{
			target.setIdOferta(source.getOferta().getId());
			target.setNombreOferta(source.getOferta().getNombre());
		}
	}	
}