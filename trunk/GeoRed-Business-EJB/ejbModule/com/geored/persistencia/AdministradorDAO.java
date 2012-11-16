package com.geored.persistencia;

import java.util.List;

import javax.ejb.Local;

import com.geored.dominio.Administrador;
import com.geored.dto.AdministradorDTO;
import com.geored.exceptions.DaoException;
import com.geored.persistencia.core.GenericDAO;

@Local
public interface AdministradorDAO extends GenericDAO<Administrador, AdministradorDTO>
{
	public Object obtenerAdminPorEmailYPass(String email, String pass, boolean toDTO) throws DaoException;
	
	public Object obtenerAdminPorEmail(String email, boolean toDTO) throws DaoException;
	
	public List obtenerListadoPorTipo(Long idTipoAdmin, boolean toDTO) throws DaoException;
}