package com.geored.persistencia;

import java.sql.Timestamp;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.geored.dominio.Oferta;
import com.geored.dto.OfertaDTO;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class OfertaDAOImpl extends GenericDAOBase<Oferta, OfertaDTO> implements OfertaDAO
{

	@Override
	public void dtoToEntity(OfertaDTO source, Oferta target)
	{
		target.setNombre(source.getNombre());
		target.setDescripcion(source.getDescripcion());
		target.setCosto(source.getCosto());
		target.setLogoUrl(source.getLogoUrl());
		target.setFechaInicio(new Timestamp(source.getFechaInicio().getTime()));
		target.setFechaFin(new Timestamp(source.getFechaFin().getTime()));
	}

	@Override
	public void entityToDto(Oferta source, OfertaDTO target)
	{
		target.setId(source.getId());
		target.setNombre(source.getNombre());
		target.setDescripcion(source.getDescripcion());
		target.setCosto(source.getCosto());
		target.setLogoUrl(source.getLogoUrl());
		target.setFechaInicio(source.getFechaInicio());
		target.setFechaFin(source.getFechaFin());
		
		if(source.getLocal() != null)
		{
			target.setIdLocal(source.getLocal().getId());
			target.setNombreLocal(source.getLocal().getNombre());
		}
	}
	
}