package com.geored.negocio;

import java.util.List;

import javax.ejb.Local;

import com.geored.dto.EventoDTO;

@Local
public interface EventoService
{
	public Long insertar(EventoDTO EventoDTO);
	
	public void actualizar(EventoDTO EventoDTO);
	
	public void eliminar(Long idAdministrador);
	
	public EventoDTO obtener(Long idAdministrador);
	
	public List<EventoDTO> obtenerListado();
}