package com.geored.negocio;

import java.util.List;

import javax.ejb.Local;

import com.geored.dto.UsuarioDTO;

@Local
public interface UsuarioService
{
	public Long insertar(UsuarioDTO UsuarioDTO);
	
	public void actualizar(UsuarioDTO UsuarioDTO);
	
	public void eliminar(Long idAdministrador);
	
	public UsuarioDTO obtener(Long idAdministrador);
	
	public List<UsuarioDTO> obtenerListado();
}