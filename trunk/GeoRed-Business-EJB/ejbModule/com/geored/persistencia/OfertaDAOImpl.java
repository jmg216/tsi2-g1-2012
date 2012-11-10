package com.geored.persistencia;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.Query;

import com.geored.dominio.Oferta;
import com.geored.dominio.Tematica;
import com.geored.dominio.Usuario;
import com.geored.dto.OfertaDTO;
import com.geored.dto.TematicaDTO;
import com.geored.exceptions.DaoException;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class OfertaDAOImpl extends GenericDAOBase<Oferta, OfertaDTO> implements OfertaDAO
{
	@EJB
	private TematicaDAO tematicaDAO;
	
	@EJB
	private UsuarioDAO usuarioDAO;
	
	@Override
	public Oferta toEntity(OfertaDTO source)
	{
		Oferta target = new Oferta();
		
		target.setNombre(source.getNombre());
		target.setDescripcion(source.getDescripcion());
		target.setCosto(source.getCosto());
		target.setUrlImagen(source.getUrlImagen());
		target.setFechaInicio(new Timestamp(source.getFechaInicio().getTime()));
		target.setFechaFin(new Timestamp(source.getFechaFin().getTime()));
		
		return target;
	}

	@Override
	public OfertaDTO toDto(Oferta source)
	{
		OfertaDTO target = new OfertaDTO();
		
		target.setId(source.getId());
		target.setNombre(source.getNombre());
		target.setDescripcion(source.getDescripcion());
		target.setCosto(source.getCosto());
		target.setUrlImagen(source.getUrlImagen());
		target.setFechaInicio(source.getFechaInicio());
		target.setFechaFin(source.getFechaFin());
		
		if(source.getLocal() != null)
		{
			target.setIdLocal(source.getLocal().getId());
			target.setNombreLocal(source.getLocal().getNombre());
		}
		
		target.setListaTematicasDTO(new ArrayList<TematicaDTO>());
		if(source.getListaTematicas() != null)
		{
			target.setListaTematicasDTO(tematicaDAO.toDtoList(source.getListaTematicas()));
		}
		
		return target;
	}
	
	public List buscarOfertasPorTematicas(List<Tematica> tematicas, Usuario u,  boolean toDTO) throws DaoException
	{
		try
		{
			Query query = em.createQuery("select o from Oferta oferta where o.listaTematicas in ?1");
			
	        query.setParameter(1, tematicas);       
	        
	        List<Oferta> listaOfertas = query.getResultList();
	        
	        if(toDTO)
	        {
	        	return toDtoList(listaOfertas);
	        }
	     
	        return listaOfertas;
		}
		catch(Throwable e)
		{
			throw new DaoException(e.getMessage());
		}
		
    }	
}