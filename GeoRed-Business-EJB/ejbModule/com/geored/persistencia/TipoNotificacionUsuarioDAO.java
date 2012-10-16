package com.geored.persistencia;

import javax.ejb.Local;

import com.geored.dominio.TipoNotificacionUsuario;
import com.geored.dto.TipoNotificacionUsuarioDTO;
import com.geored.persistencia.core.GenericDAO;

@Local
public interface TipoNotificacionUsuarioDAO extends GenericDAO<TipoNotificacionUsuario, TipoNotificacionUsuarioDTO>
{
}