package com.geored.persistencia;

import javax.ejb.Local;

import com.geored.dominio.TipoNotificacion;
import com.geored.dto.TipoNotificacionDTO;
import com.geored.persistencia.core.GenericDAO;

@Local
public interface TipoNotificacionDAO extends GenericDAO<TipoNotificacion, TipoNotificacionDTO>
{
}