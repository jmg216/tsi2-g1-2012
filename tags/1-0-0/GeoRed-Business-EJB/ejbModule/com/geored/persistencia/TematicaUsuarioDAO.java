package com.geored.persistencia;

import java.util.List;

import javax.ejb.Local;

import com.geored.dominio.TematicaUsuario;
import com.geored.dto.TematicaUsuarioDTO;

@Local
public interface TematicaUsuarioDAO
{
	public TematicaUsuario insertar(TematicaUsuario entity);
	
	public void actualizar(TematicaUsuario entity);
	
	public void eliminar(TematicaUsuario entity);
	
	public TematicaUsuario obtener(Long id);
	
	public List<TematicaUsuario> obtenerListado();
	
	/**
	 * OPERACIONES DE TRANSFORMACION Entity <-> DTO
	 */
	public void dtoToEntity(TematicaUsuarioDTO source, TematicaUsuario target);
	
	public void entityToDto(TematicaUsuario source, TematicaUsuarioDTO target);
}