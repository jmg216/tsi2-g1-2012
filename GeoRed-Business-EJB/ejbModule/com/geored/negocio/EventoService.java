package com.geored.negocio;

import java.util.List;

import javax.ejb.Local;

import com.geored.dto.EventoDTO;
import com.geored.exceptions.NegocioException;

@Local
public interface EventoService
{
	public Long insertar(EventoDTO EventoDTO)  throws NegocioException;
	
	public void actualizar(EventoDTO EventoDTO)  throws NegocioException;
	
	public void eliminar(Long idAdministrador)  throws NegocioException;
	
	public EventoDTO obtener(Long idAdministrador)  throws NegocioException;
	
	public List<EventoDTO> obtenerListado();
}