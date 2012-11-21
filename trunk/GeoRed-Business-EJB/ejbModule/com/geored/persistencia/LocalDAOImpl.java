package com.geored.persistencia;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.geored.dominio.Local;
import com.geored.dto.LocalDTO;
import com.geored.dto.OfertaDTO;
import com.geored.exceptions.DaoException;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class LocalDAOImpl extends GenericDAOBase<Local, LocalDTO> implements LocalDAO
{
	@EJB
	private OfertaDAO ofertaDAO;
	
	@Override
	public void toEntity(LocalDTO source, Local target)
	{
		target.setNombre(source.getNombre());
		target.setDireccion(source.getDireccion());
		target.setUbicacionGeografica(source.getUbicacionGeografica());
	}

	@Override
	public void toDto(Local source, LocalDTO target)
	{
		target.setId(source.getId());
		target.setNombre(source.getNombre());
		target.setDireccion(source.getDireccion());
		target.setUbicacionGeografica(source.getUbicacionGeografica());
		
		if(source.getEmpresa() != null)
		{
			target.setIdEmpresa(source.getEmpresa().getId());
			target.setNombreEmpresa(source.getEmpresa().getNombre());
		}		
		
		target.setListaOfertas(new ArrayList<OfertaDTO>());
		if(source.getListaOfertas() != null)
		{
			target.setListaOfertas(ofertaDAO.toDtoList(source.getListaOfertas()));
		}
	}

	@Override
	public Object obtenerLocalPorNombreYEmpresa(String nombre, Long idEmpresa, boolean toDTO) throws DaoException
	{
		try
		{
			Query query = em.createQuery("select l from com.geored.dominio.Local l where l.nombre = ?1 and l.empresa.id = ?2");        
	        query.setParameter(1, nombre);      
	        query.setParameter(2, idEmpresa);
	        
	        try
	        {
	        	 Local localEntity = (Local) query.getSingleResult();
	        	 
	        	 if(toDTO)
	             {        	
	             	return toDto(localEntity);
	             }
	        	 
	        	 return localEntity;
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

	@Override
	public List obtenerListadoPorEmpresa(Long idEmpresa, boolean toDTO) throws DaoException
	{
		try
		{
			Query query = em.createQuery("SELECT l FROM com.geored.dominio.Local l where l.empresa.id = ?1");
			query.setParameter(1, idEmpresa);
			
			List<Local> listaLocales = query.getResultList();
			
			if(toDTO)
			{			
				return toDtoList(listaLocales);			
			}
			
			return listaLocales;
		}
		catch(Throwable e)
		{
			throw new DaoException(e.getMessage());
		} 
	}
}