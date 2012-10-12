package com.geored.persistencia;

import java.util.Collection;

import javax.ejb.Local;

import com.geored.dominio.Evento;

@Local
public interface EventoDAO
{
	public Evento insertar(Evento entity);
	
	public void actualizar(Evento entity);
	
	public void eliminar(Evento entity);
	
	public Evento obtener(Long id);
	
	public Collection<Evento> obtenerListado();
}