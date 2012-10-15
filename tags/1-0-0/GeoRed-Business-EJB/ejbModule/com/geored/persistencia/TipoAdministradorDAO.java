package com.geored.persistencia;

import java.util.List;

import javax.ejb.Local;

import com.geored.dominio.TipoAdministrador;
import com.geored.dto.TipoAdministradorDTO;

@Local
public interface TipoAdministradorDAO
{
	public TipoAdministrador insertar(TipoAdministrador entity);
	
	public void actualizar(TipoAdministrador entity);
	
	public void eliminar(TipoAdministrador entity);
	
	public TipoAdministrador obtener(Long id);
	
	public List<TipoAdministrador> obtenerListado();
	
	/**
	 * OPERACIONES DE TRANSFORMACION Entity <-> DTO
	 */
	public void dtoToEntity(TipoAdministradorDTO source, TipoAdministrador target);
	
	public void entityToDto(TipoAdministrador source, TipoAdministradorDTO target);
}