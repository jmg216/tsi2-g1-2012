package com.geored.persistencia;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.geored.dominio.Sitio;
import com.geored.dto.SitioDTO;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class SitioDAOImpl extends GenericDAOBase<Sitio, SitioDTO> implements SitioDAO
{

	@Override
	public Sitio toEntity(SitioDTO source)
	{
		Sitio target = new Sitio();
		
		target.setNombre(source.getNombre());
		target.setDescripcion(source.getDescripcion());
		target.setUrlImagen(source.getUrlImagen());
		target.setUbicacionGeografica(source.getUbicacionGeografica());
		
		return target;
	}

	@Override
	public SitioDTO toDto(Sitio source)
	{
		SitioDTO target = new SitioDTO();
		
		target.setId(source.getId());
		target.setNombre(source.getNombre());
		target.setUrlImagen(source.getUrlImagen());
		target.setDescripcion(source.getDescripcion());
		target.setUbicacionGeografica(source.getUbicacionGeografica());
		
		return target;
	}
	
}