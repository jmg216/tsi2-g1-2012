package com.geored.persistencia;

import java.util.List;

import javax.ejb.Local;

import com.geored.dominio.TipoNotificacion;
import com.geored.dto.TipoNotificacionDTO;

@Local
public interface TipoNotificacionDAO
{
	public TipoNotificacion insertar(TipoNotificacion entity);
	
	public void actualizar(TipoNotificacion entity);
	
	public void eliminar(TipoNotificacion entity);
	
	public TipoNotificacion obtener(Long id);
	
	public List<TipoNotificacion> obtenerListado();
	
	/**
	 * OPERACIONES DE TRANSFORMACION Entity <-> DTO
	 */
	public void dtoToEntity(TipoNotificacionDTO source, TipoNotificacion target);
	
	public void entityToDto(TipoNotificacion source, TipoNotificacionDTO target);
}