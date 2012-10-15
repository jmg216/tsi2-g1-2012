package com.geored.persistencia;

import java.util.List;

import javax.ejb.Local;

import com.geored.dominio.Notificacion;
import com.geored.dto.NotificacionDTO;

@Local
public interface NotificacionDAO
{
	public Notificacion insertar(Notificacion entity);
	
	public void actualizar(Notificacion entity);
	
	public void eliminar(Notificacion entity);
	
	public Notificacion obtener(Long id);
	
	public List<Notificacion> obtenerListado();
	
	/**
	 * OPERACIONES DE TRANSFORMACION Entity <-> DTO
	 */
	public void dtoToEntity(NotificacionDTO source, Notificacion target);
	
	public void entityToDto(Notificacion source, NotificacionDTO target);
}