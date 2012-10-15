package com.geored.negocio;

import java.util.List;

import javax.ejb.Local;

import com.geored.dto.AdministradorDTO;
import com.geored.exceptions.NegocioException;

@Local
public interface AdminService 
{
	public Long insertar(AdministradorDTO administradorDTO) throws NegocioException;
	
	public void actualizar(AdministradorDTO administradorDTO)  throws NegocioException;
	
	public void eliminar(Long idAdministrador)  throws NegocioException;
	
	public AdministradorDTO obtener(Long idAdministrador)  throws NegocioException;
	
	public List<AdministradorDTO> obtenerListado();
}
