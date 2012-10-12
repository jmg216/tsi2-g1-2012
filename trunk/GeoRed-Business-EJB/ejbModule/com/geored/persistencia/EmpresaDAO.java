package com.geored.persistencia;

import java.util.Collection;

import javax.ejb.Local;

import com.geored.dominio.Empresa;

@Local
public interface EmpresaDAO
{
	public Empresa insertar(Empresa entity);
	
	public void actualizar(Empresa entity);
	
	public void eliminar(Empresa entity);
	
	public Empresa obtener(Long id);
	
	public Collection<Empresa> obtenerListado();
}