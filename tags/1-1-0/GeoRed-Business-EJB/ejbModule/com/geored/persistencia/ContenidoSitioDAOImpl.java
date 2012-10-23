package com.geored.persistencia;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.geored.dominio.ContenidoSitio;
import com.geored.dto.ContenidoSitioDTO;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ContenidoSitioDAOImpl extends GenericDAOBase<ContenidoSitio, ContenidoSitioDTO> implements ContenidoSitioDAO
{

	@Override
	public void dtoToEntity(ContenidoSitioDTO source, ContenidoSitio target)
	{
	}

	@Override
	public void entityToDto(ContenidoSitio source, ContenidoSitioDTO target)
	{
		target.setId(source.getId());
		
		if(source.getSitio() != null)
		{
			target.setIdSitio(source.getSitio().getId());
			target.setNombreSitio(source.getSitio().getNombre());
		}
		
		if(source.getUsuario() != null)
		{
			target.setIdUsuario(source.getUsuario().getId());
			target.setNombreUsuario(source.getUsuario().getNombre());
		}
	}
	
}