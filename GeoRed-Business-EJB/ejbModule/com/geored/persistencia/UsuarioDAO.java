package com.geored.persistencia;

import javax.ejb.Local;

import com.geored.dominio.Usuario;
import com.geored.dto.UsuarioDTO;
import com.geored.exceptions.DaoException;
import com.geored.persistencia.core.GenericDAO;

@Local
public interface UsuarioDAO extends GenericDAO<Usuario, UsuarioDTO>
{
	public Object obtenerUsuarioPorEmailYPass(String email, String pass, boolean toDTO) throws DaoException;
}