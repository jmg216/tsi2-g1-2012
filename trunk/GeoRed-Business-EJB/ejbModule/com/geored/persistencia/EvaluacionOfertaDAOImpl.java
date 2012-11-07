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
	public EvaluacionOferta toEntity(EvaluacionOfertaDTO source)
	{
		EvaluacionOferta target = new EvaluacionOferta();
		
		target.setEvaluacion(source.getEvaluacion());
		
		return target;
	}

	@Override
	public EvaluacionOfertaDTO toDto(EvaluacionOferta source)
	{
		EvaluacionOfertaDTO target = new EvaluacionOfertaDTO();
		
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
		
		return target;
	}	
}