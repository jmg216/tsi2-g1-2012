package com.geored.negocio;

import java.util.List;

import javax.ejb.Local;

import com.geored.dto.UsuarioDTO;
import com.geored.exceptions.NegocioException;

@Local
public interface UsuarioService
{
	public Long insertar(UsuarioDTO usuarioDTO)  throws NegocioException;
	
	public void actualizar(UsuarioDTO usuarioDTO)  throws NegocioException;
	
	public void eliminar(Long idUsuario)  throws NegocioException;
	
	public UsuarioDTO obtener(Long idUsuario)  throws NegocioException;
	
	public List<UsuarioDTO> obtenerListado();
}