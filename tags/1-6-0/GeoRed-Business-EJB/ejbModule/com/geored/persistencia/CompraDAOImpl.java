package com.geored.persistencia;

import java.sql.Timestamp;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.geored.dominio.Compra;
import com.geored.dto.CompraDTO;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class CompraDAOImpl extends GenericDAOBase<Compra, CompraDTO> implements CompraDAO
{
	@Override
	public Compra toEntity(CompraDTO source)
	{
		Compra target = new Compra();
		
		target.setFechaCreacion(new Timestamp(source.getFechaCreacion().getTime()));
		
		return target;
	}

	@Override
	public CompraDTO toDto(Compra source)
	{
		CompraDTO target = new CompraDTO();
		
		target.setId(source.getId());
		target.setFechaCreacion(source.getFechaCreacion());
		
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