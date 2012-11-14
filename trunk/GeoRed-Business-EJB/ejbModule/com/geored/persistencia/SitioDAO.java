package com.geored.persistencia;

import javax.ejb.Local;

import com.geored.dominio.Sitio;
import com.geored.dto.SitioDTO;
import com.geored.exceptions.DaoException;
import com.geored.persistencia.core.GenericDAO;

@Local
public interface SitioDAO extends GenericDAO<Sitio, SitioDTO>
{
	public Object obtenerSitioPorNombre(String nombre, boolean toDTO) throws DaoException;
}