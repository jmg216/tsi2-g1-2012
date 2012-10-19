package com.geored.negocio;

import java.util.List;

import javax.ejb.Local;

import com.geored.dto.EventoDTO;
import com.geored.exceptions.DaoException;
import com.geored.exceptions.NegocioException;

@Local
public interface EventoService
{
	public Long insertar(EventoDTO eventoDTO)  throws NegocioException, DaoException;
	
	public void actualizar(EventoDTO eventoDTO)  throws NegocioException, DaoException;
	
	public void eliminar(Long idEvento)  throws NegocioException, DaoException;
	
	public EventoDTO obtener(Long idEvento)  throws NegocioException, DaoException;
	
	public List<EventoDTO> obtenerListado() throws DaoException;
}