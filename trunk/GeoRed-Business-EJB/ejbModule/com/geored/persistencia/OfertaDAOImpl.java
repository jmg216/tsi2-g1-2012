package com.geored.persistencia;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.geored.dominio.Administrador;
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
	public void toEntity(OfertaDTO source, Oferta target)
	{
		target.setNombre(source.getNombre());
		target.setDescripcion(source.getDescripcion());
		target.setCosto(source.getCosto());
		target.setUrlImagen(source.getUrlImagen());
		target.setFechaInicio(new Timestamp(source.getFechaInicio().getTime()));
		target.setFechaFin(new Timestamp(source.getFechaFin().getTime()));
	}

	@Override
	public void toDto(Oferta source, OfertaDTO target)
	{
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
	}
	
	public List buscarOfertasPorTematicas(List<Tematica> tematicas, Usuario u,  boolean toDTO) throws DaoException
	{
		try
		{
			Query query = em.createQuery("select o from com.geored.dominio.Oferta o where o.listaTematicas in ?1");
			
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

	@Override
	public List obtenerListadoPorEmpresa(Long idEmpresa, boolean toDTO) throws DaoException
	{
		try
		{
			Query query = em.createQuery("select o from com.geored.dominio.Oferta o where o.local.empresa.id = ?1");
			
	        query.setParameter(1, idEmpresa);       
	        
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

	@Override
	public Object obtenerPorNombreYLocal(String nombre, Long idLocal, boolean toDTO) throws DaoException
	{
		try
		{
			Query query = em.createQuery("select o from com.geored.dominio.Oferta o where o.nombre = ?1 and o.local.id = ?2");        
	        query.setParameter(1, nombre);
	        query.setParameter(2, idLocal);
	        
	        try
	        {
	        	 Oferta ofertaEntity = (Oferta) query.getSingleResult();
	        	 
	        	 if(toDTO)
	             {        	
	             	return toDto(ofertaEntity);
	             }
	        	 
	        	 return ofertaEntity;
	        }
	        catch(NoResultException e)
	        {
	        	return null;
	        }
		}
		catch(Throwable e)
		{
			throw new DaoException(e.getMessage());
		}
	}	
}