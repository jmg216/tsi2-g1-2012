package com.geored.persistencia;

import java.util.Collection;

import javax.ejb.Local;

import com.geored.dominio.TipoNotificacion;

@Local
public interface TipoNotificacionDAO
{
	public TipoNotificacion insertar(TipoNotificacion entity);
	
	public void actualizar(TipoNotificacion entity);
	
	public void eliminar(TipoNotificacion entity);
	
	public TipoNotificacion obtener(Long id);
	
	public Collection<TipoNotificacion> obtenerListado();
}