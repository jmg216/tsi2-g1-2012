package com.geored.persistencia;

import java.util.List;

import com.geored.dominio.Local;
import com.geored.dto.LocalDTO;

@javax.ejb.Local
public interface LocalDAO
{
	public Local insertar(Local entity);
	
	public void actualizar(Local entity);
	
	public void eliminar(Local entity);
	
	public Local obtener(Long id);
	
	public List<Local> obtenerListado();
	
	/**
	 * OPERACIONES DE TRANSFORMACION Entity <-> DTO
	 */
	public void dtoToEntity(LocalDTO source, Local target);
	
	public void entityToDto(Local source, LocalDTO target);
}
