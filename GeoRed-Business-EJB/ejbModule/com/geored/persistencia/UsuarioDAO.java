package com.geored.persistencia;

import javax.ejb.Local;

import com.geored.dominio.Usuario;
import com.geored.dto.UsuarioDTO;
import com.geored.persistencia.core.GenericDAO;

@Local
public interface UsuarioDAO extends GenericDAO<Usuario, UsuarioDTO>
{
}