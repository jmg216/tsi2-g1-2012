package com.geored.negocio;

import java.util.List;

import javax.ejb.Local;

import com.geored.dto.UsuarioDTO;
import com.geored.exceptions.NegocioException;

@Local
public interface UsuarioService
{
	public Long insertar(UsuarioDTO UsuarioDTO)  throws NegocioException;
	
	public void actualizar(UsuarioDTO UsuarioDTO)  throws NegocioException;
	
	public void eliminar(Long idAdministrador)  throws NegocioException;
	
	public UsuarioDTO obtener(Long idAdministrador)  throws NegocioException;
	
	public List<UsuarioDTO> obtenerListado();
}