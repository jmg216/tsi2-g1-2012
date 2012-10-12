package com.geored.persistencia;

import java.util.Collection;

import javax.ejb.Local;

import com.geored.dominio.TipoAdministrador;

@Local
public interface TipoAdministradorDAO
{
	public TipoAdministrador insertar(TipoAdministrador entity);
	
	public void actualizar(TipoAdministrador entity);
	
	public void eliminar(TipoAdministrador entity);
	
	public TipoAdministrador obtener(Long id);
	
	public Collection<TipoAdministrador> obtenerListado();
}