package com.geored.persistencia;

import java.util.List;

import javax.ejb.Local;

import com.geored.dominio.Tematica;
import com.geored.dto.TematicaDTO;

@Local
public interface TematicaDAO
{
	public Tematica insertar(Tematica entity);
	
	public void actualizar(Tematica entity);
	
	public void eliminar(Tematica entity);
	
	public Tematica obtener(Long id);
	
	public List<Tematica> obtenerListado();
	
	/**
	 * OPERACIONES DE TRANSFORMACION Entity <-> DTO
	 */
	public void dtoToEntity(TematicaDTO source, Tematica target);
	
	public void entityToDto(Tematica source, TematicaDTO target);
}