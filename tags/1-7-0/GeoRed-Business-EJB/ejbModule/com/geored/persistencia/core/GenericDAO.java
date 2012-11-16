package com.geored.persistencia.core;

import java.util.List;

import com.geored.exceptions.DaoException;

/**
 * Define las operacione basicas del ORM:
 *   - insertar
 *   - actualizar
 *   - eliminar
 *   - obtener
 *   - obtenerListado
 *   
 * Seran implementadas por el GenericDAOBase de forma genérica.
 */
public interface GenericDAO<EntityType, DtoType> extends EntityTransformer<EntityType, DtoType>
{	
	public EntityType insertar(EntityType entity) throws DaoException;
	
	public void actualizar(EntityType entity) throws DaoException;
	
	public void eliminar(EntityType entity) throws DaoException;

	public Object obtener(Long id, boolean toDTO) throws DaoException;
	
	public List obtenerListado(boolean toDTO) throws DaoException;
}