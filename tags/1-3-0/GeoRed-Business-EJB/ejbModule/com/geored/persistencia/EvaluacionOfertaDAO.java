package com.geored.persistencia;

import javax.ejb.Local;

import com.geored.dominio.EvaluacionOferta;
import com.geored.dto.EvaluacionOfertaDTO;
import com.geored.persistencia.core.GenericDAO;

@Local
public interface EvaluacionOfertaDAO extends GenericDAO<EvaluacionOferta, EvaluacionOfertaDTO>
{
}