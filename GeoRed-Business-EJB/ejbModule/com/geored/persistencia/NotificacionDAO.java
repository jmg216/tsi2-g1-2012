package com.geored.persistencia;

import java.util.List;

import javax.ejb.Local;

import com.geored.dominio.Notificacion;
import com.geored.dto.NotificacionDTO;
import com.geored.exceptions.DaoException;
import com.geored.persistencia.core.GenericDAO;

@Local
public interface NotificacionDAO extends GenericDAO<Notificacion, NotificacionDTO>
{
	public List obtenerListadoPorTipoYUsuarioDestino(Long idTipoNotificacion, Long idUsuarioDestino, boolean toDTO) throws DaoException;
}