package com.geored.persistencia;

import java.util.Collection;

import javax.ejb.Local;

import com.geored.dominio.Notificacion;

@Local
public interface NotificacionDAO
{
	public Notificacion insertar(Notificacion entity);
	
	public void actualizar(Notificacion entity);
	
	public void eliminar(Notificacion entity);
	
	public Notificacion obtener(Long id);
	
	public Collection<Notificacion> obtenerListado();
}