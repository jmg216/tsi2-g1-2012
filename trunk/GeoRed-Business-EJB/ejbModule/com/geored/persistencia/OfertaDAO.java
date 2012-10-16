package com.geored.persistencia;

import javax.ejb.Local;

import com.geored.dominio.Oferta;
import com.geored.dto.OfertaDTO;
import com.geored.persistencia.core.GenericDAO;

@Local
public interface OfertaDAO extends GenericDAO<Oferta, OfertaDTO>
{
}