package com.geored.negocio;

import java.util.List;

import javax.ejb.Local;

import com.geored.dto.TematicaDTO;
import com.geored.dto.TipoAdministradorDTO;
import com.geored.dto.TipoNotificacionDTO;
import com.geored.exceptions.DaoException;
import com.geored.exceptions.NegocioException;

@Local
public interface GlobalService
{
	// Metodo que atiende las solicitudes con contenido JSON, parsea e invoca el metodo correspondiente
	public String androidInvocation(String methodName, String methodParams) throws NegocioException, DaoException;
		
	public List<TipoAdministradorDTO> obtenerListadoTiposAdministradores() throws DaoException;
	
	public List<TematicaDTO> obtenerListadoTematicas() throws DaoException;
	
	public List<TipoNotificacionDTO> obtenerListadoTiposNotificaciones() throws DaoException;
}