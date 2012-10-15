package com.geored.persistencia;

import java.util.List;

import javax.ejb.Local;

import com.geored.dominio.Usuario;
import com.geored.dto.UsuarioDTO;

@Local
public interface UsuarioDAO
{
	public Usuario insertar(Usuario entity);
	
	public void actualizar(Usuario entity);
	
	public void eliminar(Usuario entity);
	
	public Usuario obtener(Long id);
	
	public List<Usuario> obtenerListado();
	
	/**
	 * OPERACIONES DE TRANSFORMACION Entity <-> DTO
	 */
	public void dtoToEntity(UsuarioDTO source, Usuario target);
	
	public void entityToDto(Usuario source, UsuarioDTO target);
}