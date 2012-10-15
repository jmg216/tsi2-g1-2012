package com.geored.persistencia;

import java.util.List;

import javax.ejb.Local;

import com.geored.dominio.TematicaEvento;
import com.geored.dto.TematicaEventoDTO;

@Local
public interface TematicaEventoDAO
{
	public TematicaEvento insertar(TematicaEvento entity);
	
	public void actualizar(TematicaEvento entity);
	
	public void eliminar(TematicaEvento entity);
	
	public TematicaEvento obtener(Long id);
	
	public List<TematicaEvento> obtenerListado();
	
	/**
	 * OPERACIONES DE TRANSFORMACION Entity <-> DTO
	 */
	public void dtoToEntity(TematicaEventoDTO source, TematicaEvento target);
	
	public void entityToDto(TematicaEvento source, TematicaEventoDTO target);
}