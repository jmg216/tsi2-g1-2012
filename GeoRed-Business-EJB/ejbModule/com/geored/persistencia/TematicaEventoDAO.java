package com.geored.persistencia;

import javax.ejb.Local;

import com.geored.dominio.TematicaEvento;
import com.geored.dto.TematicaEventoDTO;
import com.geored.persistencia.core.GenericDAO;

@Local
public interface TematicaEventoDAO extends GenericDAO<TematicaEvento, TematicaEventoDTO>
{
}