package com.geored.persistencia;

import javax.ejb.Local;

import com.geored.dominio.Evento;
import com.geored.dto.EventoDTO;
import com.geored.exceptions.DaoException;
import com.geored.persistencia.core.GenericDAO;

@Local
public interface EventoDAO extends GenericDAO<Evento, EventoDTO>
{
	public Object obtenerPorNombre(String nombre, boolean toDTO) throws DaoException;
}