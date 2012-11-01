package com.geored.persistencia.core;

import java.util.List;

/**
 * Define las operacione basicas del ORM:
 *   - insertar
 *   - actualizar
 *   - eliminar
 *   - obtener
 *   - obtenerListado
 *   
 * Seran implementadas por el GenericDAOBase de forma genéricas.
 */
public interface GenericDAO<EntityType, DtoType> extends EntityTransformer<EntityType, DtoType>
{	
	public EntityType insertar(EntityType entity);
	
	public void actualizar(EntityType entity);
	
	public void eliminar(EntityType entity);

	public Object obtener(Long id, boolean toDTO);
	
	public List obtenerListado(boolean toDTO);
}