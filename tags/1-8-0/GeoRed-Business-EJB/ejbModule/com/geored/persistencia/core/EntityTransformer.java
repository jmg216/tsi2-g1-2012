package com.geored.persistencia.core;

import java.util.List;

/**
 * Define las operaciones genéricas de transformacion DTO <-> Entity.
 * Sera implementada por cada DAOImpl en particular.
 */
public interface EntityTransformer<EntityType, DtoType>
{
	// TO ENTITY
	public EntityType toEntity(DtoType source);
	
	public void toEntity(DtoType source, EntityType target);
	
	// TO DTO
	public DtoType toDto(EntityType source);
	
	public void toDto(EntityType source, DtoType target);
	
	// TRANSFORMACION DE COLECCIONES
	public List<EntityType> toEntityList(List<DtoType> listaDtos);
	
	public List<DtoType> toDtoList(List<EntityType> listaEntities);

	
}
