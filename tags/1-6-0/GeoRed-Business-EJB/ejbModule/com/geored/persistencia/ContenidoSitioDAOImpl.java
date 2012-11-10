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
	public ContenidoSitio toEntity(ContenidoSitioDTO source)
	{
		ContenidoSitio target = new ContenidoSitio();
		
		target.setComentario(source.getComentario());
		target.setUrlImagen(source.getUrlImagen());
		
		return target;
	}

	@Override
	public ContenidoSitioDTO toDto(ContenidoSitio source)
	{
		ContenidoSitioDTO target = new ContenidoSitioDTO();
		
		target.setId(source.getId());
		target.setComentario(source.getComentario());
		target.setUrlImagen(source.getUrlImagen());
		
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
		
		return target;
	}
}