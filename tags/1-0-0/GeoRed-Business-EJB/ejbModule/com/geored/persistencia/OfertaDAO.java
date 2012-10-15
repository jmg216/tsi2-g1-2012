package com.geored.persistencia;

import java.util.List;

import javax.ejb.Local;

import com.geored.dominio.Oferta;
import com.geored.dto.OfertaDTO;

@Local
public interface OfertaDAO
{
	public Oferta insertar(Oferta entity);
	
	public void actualizar(Oferta entity);
	
	public void eliminar(Oferta entity);
	
	public Oferta obtener(Long id);
	
	public List<Oferta> obtenerListado();
	
	/**
	 * OPERACIONES DE TRANSFORMACION Entity <-> DTO
	 */
	public void dtoToEntity(OfertaDTO source, Oferta target);
	
	public void entityToDto(Oferta source, OfertaDTO target);
}