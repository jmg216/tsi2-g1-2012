package com.geored.persistencia;

import java.util.List;

import javax.ejb.Local;

import com.geored.dominio.CompraOferta;
import com.geored.dto.CompraOfertaDTO;

@Local
public interface CompraOfertaDAO
{
	public CompraOferta insertar(CompraOferta entity);
	
	public void actualizar(CompraOferta entity);
	
	public void eliminar(CompraOferta entity);
	
	public CompraOferta obtener(Long id);
	
	public List<CompraOferta> obtenerListado();
	
	/**
	 * OPERACIONES DE TRANSFORMACION Entity <-> DTO
	 */
	public void dtoToEntity(CompraOfertaDTO source, CompraOferta target);
	
	public void entityToDto(CompraOferta source, CompraOfertaDTO target);
}