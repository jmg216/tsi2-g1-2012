package com.geored.persistencia;

import java.util.Collection;

import javax.ejb.Local;

import com.geored.dominio.TematicaSitio;

@Local
public interface TematicaSitioDAO
{
	public TematicaSitio insertar(TematicaSitio entity);
	
	public void actualizar(TematicaSitio entity);
	
	public void eliminar(TematicaSitio entity);
	
	public TematicaSitio obtener(Long id);
	
	public Collection<TematicaSitio> obtenerListado();
}