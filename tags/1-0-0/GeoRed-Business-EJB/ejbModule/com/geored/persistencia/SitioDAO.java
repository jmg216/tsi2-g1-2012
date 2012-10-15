package com.geored.persistencia;

import java.util.List;

import javax.ejb.Local;

import com.geored.dominio.Sitio;
import com.geored.dto.SitioDTO;

@Local
public interface SitioDAO
{
	public Sitio insertar(Sitio entity);
	
	public void actualizar(Sitio entity);
	
	public void eliminar(Sitio entity);
	
	public Sitio obtener(Long id);
	
	public List<Sitio> obtenerListado();
	
	/**
	 * OPERACIONES DE TRANSFORMACION Entity <-> DTO
	 */
	public void dtoToEntity(SitioDTO source, Sitio target);
	
	public void entityToDto(Sitio source, SitioDTO target);
}