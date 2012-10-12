package com.geored.negocio;

import java.util.List;

import javax.ejb.Local;

import com.geored.dto.AdministradorDTO;

@Local
public interface AdminService 
{
	public Long insertar(AdministradorDTO administradorDTO);
	
	public void actualizar(AdministradorDTO administradorDTO);
	
	public void eliminar(Long idAdministrador);
	
	public AdministradorDTO obtener(Long idAdministrador);
	
	public List<AdministradorDTO> obtenerListado();
}
