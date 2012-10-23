package com.geored.persistencia;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.geored.dominio.CompraOferta;
import com.geored.dto.CompraOfertaDTO;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class CompraOfertaDAOImpl extends GenericDAOBase<CompraOferta, CompraOfertaDTO> implements CompraOfertaDAO
{

	@Override
	public void dtoToEntity(CompraOfertaDTO source, CompraOferta target)
	{		
	}

	@Override
	public void entityToDto(CompraOferta source, CompraOfertaDTO target)
	{
		target.setId(source.getId());
		
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