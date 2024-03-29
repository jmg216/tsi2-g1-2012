package com.geored.persistencia.core;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.geored.exceptions.DaoException;
import com.geored.utiles.UtilesPersistencia;

/**
 * Implementa las operaciones del GenericDAO de forma generica.
 * Es padre de todos los DAOImpl.
 */
public abstract class GenericDAOBase<EntityType, DtoType>
{
	@PersistenceContext(unitName=UtilesPersistencia.PERSISTENCE_UNIT_NAME)
	protected EntityManager em;
	
	private Class<EntityType> entityClass = getEntityClass();
	
	private Class<DtoType> dtoClass = getDtoClass();
	
	private EntityTransformer<EntityType, DtoType> entityTransformer = (EntityTransformer<EntityType, DtoType>) this;
	
	public EntityType insertar(EntityType entity) throws DaoException
	{
		try
		{
			em.persist(entity);
			return entity;
		}
		catch(Throwable e)
		{
			throw new DaoException(e.getMessage());
		}	
	}
	
	public void actualizar(EntityType entity) throws DaoException
	{
		try
		{
			em.merge(entity);
		}
		catch(Throwable e)
		{
			throw new DaoException(e.getMessage());
		}
	}
	
	public void eliminar(EntityType entity) throws DaoException
	{
		try
		{
			em.remove(entity);
		}
		catch(Throwable e)
		{
			throw new DaoException(e.getMessage());
		}
	}
	
	public Object obtener(Long id, boolean toDTO) throws DaoException
	{
		try
		{	
			EntityType entity = em.find(entityClass, id);
			
			if(toDTO)
			{							
				return entityTransformer.toDto(entity);			
			}
			
			return entity;
		}
		catch(Throwable e)
		{
			throw new DaoException(e.getMessage());
		}
	}
	
	public List obtenerListado(boolean toDTO) throws DaoException
	{
		try
		{
			Query query = em.createQuery("SELECT e FROM " + entityClass.getName() + " e");
			
			List<EntityType> listaEntidades = query.getResultList();
			
			if(toDTO)
			{			
				return entityTransformer.toDtoList(listaEntidades);			
			}
			
			return listaEntidades;
		}
		catch(Throwable e)
		{
			throw new DaoException(e.getMessage());
		}
	}
	
	// TO ENTITY
	public EntityType toEntity(DtoType source)
	{		
		try
		{
			EntityType target = entityClass.newInstance();
			
			entityTransformer.toEntity(source, target);
			
			return target;
		} 
		catch (InstantiationException | IllegalAccessException e)
		{
			e.printStackTrace();
			
			return null;
		}
	}
	
	// TO DTO 
	public DtoType toDto(EntityType source)
	{
		try
		{
			DtoType target = dtoClass.newInstance();
			
			entityTransformer.toDto(source, target);
			
			return target;
		} 
		catch (InstantiationException | IllegalAccessException e)
		{
			e.printStackTrace();
			
			return null;
		}
	}
	
	// TRANSFORMACION DE COLECCIONES
	public List<EntityType> toEntityList(List<DtoType> listaDtos)
	{
		List<EntityType> listaEntities = new ArrayList<EntityType>();
		
		for(DtoType dto : listaDtos)
		{
			listaEntities.add(entityTransformer.toEntity(dto));
		}
		
		return listaEntities;
	}
	
	public List<DtoType> toDtoList(List<EntityType> listaEntities)
	{
		List<DtoType> listaDtos = new ArrayList<DtoType>();
		
		for(EntityType entity : listaEntities)
		{
			listaDtos.add(entityTransformer.toDto(entity));
		}
		
		return listaDtos;
	}
	
	
	// ************* OPERACIONES AUXILIARES PARA LA CLASE GENERICA *************
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