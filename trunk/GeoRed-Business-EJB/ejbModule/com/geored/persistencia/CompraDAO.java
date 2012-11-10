package com.geored.persistencia;

import javax.ejb.Local;

import com.geored.dominio.Compra;
import com.geored.dto.CompraDTO;
import com.geored.persistencia.core.GenericDAO;

@Local
public interface CompraDAO extends GenericDAO<Compra, CompraDTO>
{
}