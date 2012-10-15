package com.geored.persistencia;

import java.util.List;

import javax.ejb.Local;

import com.geored.dominio.Administrador;
import com.geored.dominio.ContenidoSitio;
import com.geored.dto.AdministradorDTO;

@Local
public interface ContenidoSitioDAO
{
	public ContenidoSitio insertar(ContenidoSitio entity);
	
	public void actualizar(ContenidoSitio entity);
	
	public void eliminar(ContenidoSitio entity);
	
	public ContenidoSitio obtener(Long id);
	
	public List<ContenidoSitio> obtenerListado();
	
	/**
	 * OPERACIONES DE TRANSFORMACION Entity <-> DTO
	 */
	public void dtoToEntity(AdministradorDTO source, Administrador target);
	
	public void entityToDto(Administrador source, AdministradorDTO target);
}