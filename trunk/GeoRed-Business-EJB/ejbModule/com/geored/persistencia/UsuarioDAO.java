package com.geored.persistencia;

import java.util.Collection;

import javax.ejb.Local;

import com.geored.dominio.Usuario;

@Local
public interface UsuarioDAO
{
	public Usuario insertar(Usuario entity);
	
	public void actualizar(Usuario entity);
	
	public void eliminar(Usuario entity);
	
	public Usuario obtener(Long id);
	
	public Collection<Usuario> obtenerListado();
}