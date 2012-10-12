package com.geored.persistencia;

import java.util.Collection;

import javax.ejb.Local;

import com.geored.dominio.TematicaOferta;

@Local
public interface TematicaOfertaDAO
{
	public TematicaOferta insertar(TematicaOferta entity);
	
	public void actualizar(TematicaOferta entity);
	
	public void eliminar(TematicaOferta entity);
	
	public TematicaOferta obtener(Long id);
	
	public Collection<TematicaOferta> obtenerListado();
}