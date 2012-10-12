package com.geored.persistencia;

import java.util.Collection;

import javax.ejb.Local;

import com.geored.dominio.EvaluacionOferta;

@Local
public interface EvaluacionOfertaDAO
{
	public EvaluacionOferta insertar(EvaluacionOferta entity);
	
	public void actualizar(EvaluacionOferta entity);
	
	public void eliminar(EvaluacionOferta entity);
	
	public EvaluacionOferta obtener(Long id);
	
	public Collection<EvaluacionOferta> obtenerListado();
}