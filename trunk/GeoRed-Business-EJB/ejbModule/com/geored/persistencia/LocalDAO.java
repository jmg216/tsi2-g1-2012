package com.geored.persistencia;

import java.util.Collection;

import com.geored.dominio.Local;

@javax.ejb.Local
public interface LocalDAO
{
	public Local insertar(Local entity);
	
	public void actualizar(Local entity);
	
	public void eliminar(Local entity);
	
	public Local obtener(Long id);
	
	public Collection<Local> obtenerListado();
}
