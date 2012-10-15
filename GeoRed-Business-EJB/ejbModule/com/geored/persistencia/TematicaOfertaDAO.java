package com.geored.persistencia;

import java.util.List;

import javax.ejb.Local;

import com.geored.dominio.TematicaOferta;
import com.geored.dto.TematicaOfertaDTO;

@Local
public interface TematicaOfertaDAO
{
	public TematicaOferta insertar(TematicaOferta entity);
	
	public void actualizar(TematicaOferta entity);
	
	public void eliminar(TematicaOferta entity);
	
	public TematicaOferta obtener(Long id);
	
	public List<TematicaOferta> obtenerListado();
	
	/**
	 * OPERACIONES DE TRANSFORMACION Entity <-> DTO
	 */
	public void dtoToEntity(TematicaOfertaDTO source, TematicaOferta target);
	
	public void entityToDto(TematicaOferta source, TematicaOfertaDTO target);
}