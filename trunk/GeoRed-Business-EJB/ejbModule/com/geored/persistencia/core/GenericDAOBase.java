package com.geored.persistencia.core;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.geored.utiles.UtilesPersistencia;

/**
 * Implementa las operaciones del GenericDAO de forma generica.
 * Es padre de todos los DAOImpl.
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public abstract class GenericDAOBase<EntityType, DtoType>
{
	@PersistenceContext(unitName=UtilesPersistencia.PERSISTENCE_UNIT_NAME)
	protected EntityManager em;
	
	private Class<EntityType> entityClass;
	
	private Class<DtoType> dtoClass;
	
	private EntityTransformer<EntityType, DtoType> entityTransformer = (EntityTransformer<EntityType, DtoType>) this;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public EntityType insertar(EntityType entity)
	{
		em.persist(entity);
		return entity;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void actualizar(EntityType entity)
	{
		em.refresh(entity);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void eliminar(EntityType entity)
	{
		em.remove(entity);
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public Object obtener(Long id, boolean toDTO)
	{
		EntityType entity = em.find(entityClass, id);
		
		if(toDTO)
		{
			try
			{
				DtoType dto = dtoClass.newInstance();
				
				entityTransformer.entityToDto(entity, dto);
				
				return dto;
			} 
			catch (InstantiationException e1)
			{
				throw new RuntimeException("Error transformando Entity");
			} 
			catch (IllegalAccessException e1)
			{
				throw new RuntimeException("Error transformando Entity");
			}
		}
		
		return entity;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List obtenerListado(boolean toDTO)
	{
		Query query = em.createQuery("SELECT e FROM " + entityClass.getClass().getName() + " e");
		
		List<EntityType> listaEntidades = new ArrayList<EntityType>();
		
		listaEntidades = query.getResultList();
		
		if(toDTO)
		{
			try
			{
				List<DtoType> listaDtos = new ArrayList<DtoType>();
				
				for(EntityType entity : listaEntidades)
				{
					DtoType dto = dtoClass.newInstance();
					
					entityTransformer.entityToDto(entity, dto);
					
					listaDtos.add(dto);
				}
				
				return listaDtos;
								
			} 
			catch (InstantiationException e1)
			{
				throw new RuntimeException("Error transformando Entity");
			} 
			catch (IllegalAccessException e1)
			{
				throw new RuntimeException("Error transformando Entity");
			}
		}
		
	    return listaEntidades;
	}
}