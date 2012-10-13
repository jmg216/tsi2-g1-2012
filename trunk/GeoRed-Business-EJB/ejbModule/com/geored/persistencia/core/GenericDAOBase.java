package com.geored.persistencia.core;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.geored.utiles.UtilesPersistencia;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public abstract class GenericDAOBase<E>
{
	@PersistenceContext(unitName=UtilesPersistencia.PERSISTENCE_UNIT_NAME)
	protected EntityManager em;
	
	private Class<E> entityClass;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public E insertar(E entity)
	{
		em.persist(entity);
		return entity;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void actualizar(E entity)
	{
		em.refresh(entity);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void eliminar(E entity)
	{
		em.remove(entity);
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public E obtener(Long id)
	{
		return em.find(entityClass, id);
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public Collection<E> obtenerListado()
	{
		Query query = em.createQuery("SELECT e FROM " + entityClass.getClass().getName() + " e");
		
	    return (Collection<E>) query.getResultList();
	}
}