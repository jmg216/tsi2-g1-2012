package com.geored.persistencia;

import java.util.Collection;

import javax.ejb.Local;

import com.geored.dominio.Tematica;

@Local
public interface TematicaDAO
{
	public Tematica insertar(Tematica entity);
	
	public void actualizar(Tematica entity);
	
	public void eliminar(Tematica entity);
	
	public Tematica obtener(Long id);
	
	public Collection<Tematica> obtenerListado();
}