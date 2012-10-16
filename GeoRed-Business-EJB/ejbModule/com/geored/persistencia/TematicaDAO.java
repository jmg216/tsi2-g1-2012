package com.geored.persistencia;

import javax.ejb.Local;

import com.geored.dominio.Tematica;
import com.geored.dto.TematicaDTO;
import com.geored.persistencia.core.GenericDAO;

@Local
public interface TematicaDAO extends GenericDAO<Tematica, TematicaDTO>
{
}