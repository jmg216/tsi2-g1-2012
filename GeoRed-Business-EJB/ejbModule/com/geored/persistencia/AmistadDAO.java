package com.geored.persistencia;

import java.util.List;

import javax.ejb.Local;

import com.geored.dominio.Amistad;
import com.geored.dto.AmistadDTO;

@Local
public interface AmistadDAO
{
	public Amistad insertar(Amistad entity);
	
	public void actualizar(Amistad entity);
	
	public void eliminar(Amistad entity);
	
	public Amistad obtener(Long id);
	
	public List<Amistad> obtenerListado();
	
	/**
	 * OPERACIONES DE TRANSFORMACION Entity <-> DTO
	 */
	public void dtoToEntity(AmistadDTO source, Amistad target);
	
	public void entityToDto(Amistad source, AmistadDTO target);
}