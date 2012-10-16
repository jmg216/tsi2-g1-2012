package com.geored.persistencia;

import javax.ejb.Local;

import com.geored.dominio.TematicaOferta;
import com.geored.dto.TematicaOfertaDTO;
import com.geored.persistencia.core.GenericDAO;

@Local
public interface TematicaOfertaDAO extends GenericDAO<TematicaOferta, TematicaOfertaDTO>
{
}