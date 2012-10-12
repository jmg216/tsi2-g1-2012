package com.geored.persistencia;

import java.util.Collection;

import javax.ejb.Local;

import com.geored.dominio.ContenidoSitio;

@Local
public interface ContenidoSitioDAO
{
	public ContenidoSitio insertar(ContenidoSitio entity);
	
	public void actualizar(ContenidoSitio entity);
	
	public void eliminar(ContenidoSitio entity);
	
	public ContenidoSitio obtener(Long id);
	
	public Collection<ContenidoSitio> obtenerListado();
}