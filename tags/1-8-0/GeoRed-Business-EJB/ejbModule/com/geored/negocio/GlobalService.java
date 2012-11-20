package com.geored.negocio;

import java.util.List;

import javax.ejb.Local;

import com.geored.dto.TematicaDTO;
import com.geored.dto.TipoAdministradorDTO;
import com.geored.dto.TipoNotificacionDTO;
import com.geored.exceptions.DaoException;

@Local
public interface GlobalService
{
	public List<TipoAdministradorDTO> obtenerListadoTiposAdministradores() throws DaoException;
	
	public List<TematicaDTO> obtenerListadoTematicas() throws DaoException;
	
	public List<TipoNotificacionDTO> obtenerListadoTiposNotificaciones() throws DaoException;
}