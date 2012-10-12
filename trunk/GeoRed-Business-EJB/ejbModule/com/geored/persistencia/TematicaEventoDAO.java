package com.geored.persistencia;

import java.util.Collection;

import javax.ejb.Local;

import com.geored.dominio.TematicaEvento;

@Local
public interface TematicaEventoDAO
{
	public TematicaEvento insertar(TematicaEvento entity);
	
	public void actualizar(TematicaEvento entity);
	
	public void eliminar(TematicaEvento entity);
	
	public TematicaEvento obtener(Long id);
	
	public Collection<TematicaEvento> obtenerListado();
}