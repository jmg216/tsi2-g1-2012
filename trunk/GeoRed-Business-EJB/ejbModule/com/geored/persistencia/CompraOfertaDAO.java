package com.geored.persistencia;

import java.util.Collection;

import javax.ejb.Local;

import com.geored.dominio.CompraOferta;

@Local
public interface CompraOfertaDAO
{
	public CompraOferta insertar(CompraOferta entity);
	
	public void actualizar(CompraOferta entity);
	
	public void eliminar(CompraOferta entity);
	
	public CompraOferta obtener(Long id);
	
	public Collection<CompraOferta> obtenerListado();
}