package com.geored.persistencia;

import javax.ejb.Local;

import com.geored.dominio.CompraOferta;
import com.geored.dto.CompraOfertaDTO;
import com.geored.persistencia.core.GenericDAO;

@Local
public interface CompraOfertaDAO extends GenericDAO<CompraOferta, CompraOfertaDTO>
{
}