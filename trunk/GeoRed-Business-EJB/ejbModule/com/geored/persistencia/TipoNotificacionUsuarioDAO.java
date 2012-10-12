package com.geored.persistencia;

import java.util.Collection;

import javax.ejb.Local;

import com.geored.dominio.TipoNotificacionUsuario;

@Local
public interface TipoNotificacionUsuarioDAO
{
	public TipoNotificacionUsuario insertar(TipoNotificacionUsuario entity);
	
	public void actualizar(TipoNotificacionUsuario entity);
	
	public void eliminar(TipoNotificacionUsuario entity);
	
	public TipoNotificacionUsuario obtener(Long id);
	
	public Collection<TipoNotificacionUsuario> obtenerListado();
}