package com.geored.persistencia;

import java.sql.Timestamp;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.Query;


import com.geored.dominio.Oferta;
import com.geored.dominio.TematicaUsuario;
import com.geored.dominio.Usuario;

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
	
	public Object buscarOfertasPorTematicas(List<TematicaUsuario> tematicas, Usuario u,  boolean toDTO)
	{
		Query query = em.createQuery("select o from Oferta o JOIN o.tematicas where o.tematicas in ?1");        
        query.setParameter(1, tematicas);       
        
        
        Oferta ofertaEntity = (Oferta) query.getSingleResult();
        
        if(toDTO)
        {
        	OfertaDTO ofertaDTO = new OfertaDTO();
        	
        	entityToDto(ofertaEntity, ofertaDTO);
        	
        	return ofertaDTO;
        }
        
        return ofertaEntity;
	
    }
}