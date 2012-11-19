package com.geored.persistencia;

import java.util.List;

import javax.ejb.Local;

import com.geored.dominio.Empresa;
import com.geored.dto.EmpresaDTO;
import com.geored.exceptions.DaoException;
import com.geored.persistencia.core.GenericDAO;

@Local
public interface EmpresaDAO extends GenericDAO<Empresa, EmpresaDTO>
{
	public Object obtenerPorNombre(String nombre, boolean toDTO) throws DaoException;
	
	public List obtenerListadoPorAdministrador(Long idAdministrador, boolean toDTO) throws DaoException;
}