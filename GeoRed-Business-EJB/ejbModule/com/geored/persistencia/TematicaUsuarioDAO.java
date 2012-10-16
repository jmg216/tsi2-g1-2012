package com.geored.persistencia;

import javax.ejb.Local;

import com.geored.dominio.TematicaUsuario;
import com.geored.dto.TematicaUsuarioDTO;
import com.geored.persistencia.core.GenericDAO;

@Local
public interface TematicaUsuarioDAO extends GenericDAO<TematicaUsuario, TematicaUsuarioDTO>
{
}