package com.geored.persistencia;

import java.util.List;

import javax.ejb.Local;

import com.geored.dominio.EvaluacionOferta;
import com.geored.dto.EvaluacionOfertaDTO;

@Local
public interface EvaluacionOfertaDAO
{
	public EvaluacionOferta insertar(EvaluacionOferta entity);
	
	public void actualizar(EvaluacionOferta entity);
	
	public void eliminar(EvaluacionOferta entity);
	
	public EvaluacionOferta obtener(Long id);
	
	public List<EvaluacionOferta> obtenerListado();
	
	/**
	 * OPERACIONES DE TRANSFORMACION Entity <-> DTO
	 */
	public void dtoToEntity(EvaluacionOfertaDTO source, EvaluacionOferta target);
	
	public void entityToDto(EvaluacionOferta source, EvaluacionOfertaDTO target);
}