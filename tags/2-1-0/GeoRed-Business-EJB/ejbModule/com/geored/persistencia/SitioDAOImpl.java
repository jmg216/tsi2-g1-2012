package com.geored.persistencia;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.geored.dominio.Sitio;
import com.geored.dto.SitioDTO;
import com.geored.dto.TematicaDTO;
import com.geored.exceptions.DaoException;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class SitioDAOImpl extends GenericDAOBase<Sitio, SitioDTO> implements SitioDAO
{
	@EJB
	private TematicaDAO tematicaDAO;
	
	@Override
	public Sitio toEntity(SitioDTO source)
	{
		Sitio target = new Sitio();
		
		toEntity(source, target);
		
		return target;
	}

	@Override
	public void toEntity(SitioDTO source, Sitio target)
	{
		target.setNombre(source.getNombre());
		target.setDescripcion(source.getDescripcion());
		target.setUrlImagen(source.getUrlImagen());
		target.setUbicacionGeografica(source.getUbicacionGeografica());
	}
	
	@Override
	public void toDto(Sitio source, SitioDTO target)
	{
		target.setId(source.getId());
		target.setNombre(source.getNombre());
		target.setUrlImagen(source.getUrlImagen());
		target.setDescripcion(source.getDescripcion());
		target.setUbicacionGeografica(source.getUbicacionGeografica());
		
		target.setListaTematicasDTO(new ArrayList<TematicaDTO>());
		if(source.getListaTematicas() != null)
		{
			target.setListaTematicasDTO(tematicaDAO.toDtoList(source.getListaTematicas()));
		}
	}

	@Override
	public Object obtenerSitioPorNombre(String nombre, boolean toDTO) throws DaoException
	{
		try
		{
			Query query = em.createQuery("select s from com.geored.dominio.Sitio s where s.nombre = ?1");        
	        query.setParameter(1, nombre);        
	        
	        try
	        {
	        	 Sitio sitioEntity = (Sitio) query.getSingleResult();
	        	 
	        	 if(toDTO)
	             {        	
	             	return toDto(sitioEntity);
	             }
	        	 
	        	 return sitioEntity;
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