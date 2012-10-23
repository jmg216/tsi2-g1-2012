package com.geored.persistencia.core;

/**
 * Define las operaciones genéricas de transformacion DTO <-> Entity.
 * Sera implementada por cada DAOImpl en particular.
 */
public interface EntityTransformer<EntityType, DtoType>
{
	public void dtoToEntity(DtoType source, EntityType target);
	
	public void entityToDto(EntityType source, DtoType target);
}