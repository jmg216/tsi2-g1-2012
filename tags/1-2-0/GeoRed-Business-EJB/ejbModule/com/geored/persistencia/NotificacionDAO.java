package com.geored.persistencia;

import javax.ejb.Local;

import com.geored.dominio.Notificacion;
import com.geored.dto.NotificacionDTO;
import com.geored.persistencia.core.GenericDAO;

@Local
public interface NotificacionDAO extends GenericDAO<Notificacion, NotificacionDTO>
{
}