package com.geored.persistencia.core;

import java.util.List;

/**
 * Define las operaciones genéricas de transformacion DTO <-> Entity.
 * Sera implementada por cada DAOImpl en particular.
 */
public interface EntityTransformer<EntityType, DtoType>
{
	public EntityType toEntity(DtoType source);
	
	public DtoType toDto(EntityType source);
	
	// TRANSFORMACION DE COLECCIONES
	public List<EntityType> toEntityList(List<DtoType> listaDtos);
	
	public List<DtoType> toDtoList(List<EntityType> listaEntities);

	
}
