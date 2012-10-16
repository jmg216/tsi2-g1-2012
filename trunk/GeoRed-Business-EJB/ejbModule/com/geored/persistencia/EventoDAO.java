package com.geored.persistencia;

import javax.ejb.Local;

import com.geored.dominio.Evento;
import com.geored.dto.EventoDTO;
import com.geored.persistencia.core.GenericDAO;

@Local
public interface EventoDAO extends GenericDAO<Evento, EventoDTO>
{
}