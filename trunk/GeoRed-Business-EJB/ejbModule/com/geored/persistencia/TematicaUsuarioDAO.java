package com.geored.persistencia;

import java.util.Collection;

import javax.ejb.Local;

import com.geored.dominio.TematicaUsuario;

@Local
public interface TematicaUsuarioDAO
{
	public TematicaUsuario insertar(TematicaUsuario entity);
	
	public void actualizar(TematicaUsuario entity);
	
	public void eliminar(TematicaUsuario entity);
	
	public TematicaUsuario obtener(Long id);
	
	public Collection<TematicaUsuario> obtenerListado();
}