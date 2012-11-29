package com.geored.persistencia;

import java.util.List;

import javax.ejb.Local;

import com.geored.dominio.Compra;
import com.geored.dto.CompraDTO;
import com.geored.exceptions.DaoException;
import com.geored.persistencia.core.GenericDAO;

@Local
public interface CompraDAO extends GenericDAO<Compra, CompraDTO>
{
	public List obtenerListadoPorOferta(Long idOferta, boolean toDTO) throws DaoException;
}