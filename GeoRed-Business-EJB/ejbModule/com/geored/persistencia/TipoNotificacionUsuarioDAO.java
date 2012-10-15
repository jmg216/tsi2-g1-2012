package com.geored.persistencia;

import java.util.List;

import javax.ejb.Local;

import com.geored.dominio.TipoNotificacionUsuario;
import com.geored.dto.TipoNotificacionUsuarioDTO;

@Local
public interface TipoNotificacionUsuarioDAO
{
	public TipoNotificacionUsuario insertar(TipoNotificacionUsuario entity);
	
	public void actualizar(TipoNotificacionUsuario entity);
	
	public void eliminar(TipoNotificacionUsuario entity);
	
	public TipoNotificacionUsuario obtener(Long id);
	
	public List<TipoNotificacionUsuario> obtenerListado();
	
	/**
	 * OPERACIONES DE TRANSFORMACION Entity <-> DTO
	 */
	public void dtoToEntity(TipoNotificacionUsuarioDTO source, TipoNotificacionUsuario target);
	
	public void entityToDto(TipoNotificacionUsuario source, TipoNotificacionUsuarioDTO target);
}