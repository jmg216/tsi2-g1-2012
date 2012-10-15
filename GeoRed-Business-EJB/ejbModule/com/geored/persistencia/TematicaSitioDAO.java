package com.geored.persistencia;

import java.util.List;

import javax.ejb.Local;

import com.geored.dominio.TematicaSitio;
import com.geored.dto.TematicaSitioDTO;

@Local
public interface TematicaSitioDAO
{
	public TematicaSitio insertar(TematicaSitio entity);
	
	public void actualizar(TematicaSitio entity);
	
	public void eliminar(TematicaSitio entity);
	
	public TematicaSitio obtener(Long id);
	
	public List<TematicaSitio> obtenerListado();
	
	/**
	 * OPERACIONES DE TRANSFORMACION Entity <-> DTO
	 */
	public void dtoToEntity(TematicaSitioDTO source, TematicaSitio target);
	
	public void entityToDto(TematicaSitio source, TematicaSitioDTO target);
}