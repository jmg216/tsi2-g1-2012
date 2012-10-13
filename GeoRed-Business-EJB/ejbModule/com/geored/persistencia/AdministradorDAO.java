package com.geored.persistencia;

import java.util.Collection;

import javax.ejb.Local;

import com.geored.dominio.Administrador;
import com.geored.dto.AdministradorDTO;

@Local
public interface AdministradorDAO
{
	public Administrador insertar(Administrador entity);
	
	public void actualizar(Administrador entity);
	
	public void eliminar(Administrador entity);
	
	public Administrador obtener(Long id);
	
	public Collection<Administrador> obtenerListado();
	
	/**
	 * OPERACIONES DE TRANSFORMACION Entity <-> DTO
	 */
	public void dtoToEntity(AdministradorDTO source, Administrador target);
	
	public void entityToDto(Administrador source, AdministradorDTO target);
	
}