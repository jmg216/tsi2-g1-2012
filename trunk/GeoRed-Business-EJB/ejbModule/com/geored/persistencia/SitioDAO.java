package com.geored.persistencia;

import java.util.Collection;

import javax.ejb.Local;

import com.geored.dominio.Sitio;

@Local
public interface SitioDAO
{
	public Sitio insertar(Sitio entity);
	
	public void actualizar(Sitio entity);
	
	public void eliminar(Sitio entity);
	
	public Sitio obtener(Long id);
	
	public Collection<Sitio> obtenerListado();
}