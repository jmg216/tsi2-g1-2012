package com.geored.persistencia;

import java.util.List;

import com.geored.dominio.Local;
import com.geored.dto.LocalDTO;
import com.geored.exceptions.DaoException;
import com.geored.persistencia.core.GenericDAO;

@javax.ejb.Local
public interface LocalDAO extends GenericDAO<Local, LocalDTO>
{
	public Object obtenerLocalPorNombreYEmpresa(String nombre, Long idEmpresa, boolean toDTO) throws DaoException;
	
	public List obtenerListadoPorEmpresa(Long idEmpresa, boolean toDTO) throws DaoException;
}
