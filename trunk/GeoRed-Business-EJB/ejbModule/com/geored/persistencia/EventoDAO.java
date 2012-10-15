package com.geored.persistencia;

import java.util.List;

import javax.ejb.Local;

import com.geored.dominio.Evento;
import com.geored.dto.EventoDTO;

@Local
public interface EventoDAO
{
	public Evento insertar(Evento entity);
	
	public void actualizar(Evento entity);
	
	public void eliminar(Evento entity);
	
	public Evento obtener(Long id);
	
	public List<Evento> obtenerListado();
	
	/**
	 * OPERACIONES DE TRANSFORMACION Entity <-> DTO
	 */
	public void dtoToEntity(EventoDTO source, Evento target);
	
	public void entityToDto(Evento source, EventoDTO target);
}