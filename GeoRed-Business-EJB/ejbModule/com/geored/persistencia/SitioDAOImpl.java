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
	public void dtoToEntity(SitioDTO source, Sitio target)
	{
		target.setNombre(source.getNombre());
		target.setDescripcion(source.getDescripcion());
		target.setImagen(source.getImagen());
		target.setUbicacionGeografica(source.getUbicacionGeografica());
	}

	@Override
	public void entityToDto(Sitio source, SitioDTO target)
	{
		target.setId(source.getId());
		target.setNombre(source.getNombre());
		target.setImagen(source.getImagen());
		target.setDescripcion(source.getDescripcion());
		target.setUbicacionGeografica(source.getUbicacionGeografica());
		
		if(source.getAdministrador() != null)
		{
			target.setIdAdministrador(source.getAdministrador().getId());
			target.setNombreAdministrador(source.getAdministrador().getNombre());
		}
	}
	
}