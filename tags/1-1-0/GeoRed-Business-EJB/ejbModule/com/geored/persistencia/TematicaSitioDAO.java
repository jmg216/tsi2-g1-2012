package com.geored.persistencia;

import javax.ejb.Local;

import com.geored.dominio.TematicaSitio;
import com.geored.dto.TematicaSitioDTO;
import com.geored.persistencia.core.GenericDAO;

@Local
public interface TematicaSitioDAO extends GenericDAO<TematicaSitio, TematicaSitioDTO>
{
}