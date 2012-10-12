package com.geored.persistencia;

import java.util.Collection;

import javax.ejb.Local;

import com.geored.dominio.Oferta;

@Local
public interface OfertaDAO
{
	public Oferta insertar(Oferta entity);
	
	public void actualizar(Oferta entity);
	
	public void eliminar(Oferta entity);
	
	public Oferta obtener(Long id);
	
	public Collection<Oferta> obtenerListado();
}