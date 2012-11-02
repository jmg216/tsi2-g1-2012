package com.geored.persistencia.core;

import java.lang.reflect.ParameterizedType;
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
	
	private Class<EntityType> entityClass = getEntityClass();
	
	private Class<DtoType> dtoClass = getDtoClass();
	
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
		Query query = em.createQuery("SELECT e FROM " + entityClass.getName() + " e");
		
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
	
	// Utilidades de la clase Generica
	
	/**
	 * Recupera la clase del EntityType
	 * @return
	 */
	private Class getEntityClass() 
	{
	 	if (entityClass == null) 
	 	{
			ParameterizedType thisType = (ParameterizedType) getClass().getGenericSuperclass();
			entityClass = (Class) thisType.getActualTypeArguments()[0];
	 	}
	 	
		return entityClass;
	}
	
	/**
	 * Recupera la clase del DtoType
	 * @return
	 */
	private Class getDtoClass() 
	{
	 	if (dtoClass == null) 
	 	{
			ParameterizedType thisType = (ParameterizedType) getClass().getGenericSuperclass();
			dtoClass = (Class) thisType.getActualTypeArguments()[1];
	 	}
	 	
		return dtoClass;
	}
}