package com.geored.negocio;

import java.util.List;

import javax.ejb.Local;

import com.geored.dto.AdministradorDTO;
import com.geored.exceptions.DaoException;
import com.geored.exceptions.NegocioException;

@Local
public interface AdminService 
{
	// Metodo que atiende las solicitudes con contenido JSON, parsea e invoca el metodo correspondiente
	public String androidInvocation(String methodName, String methodParams) throws NegocioException, DaoException;
		
	public Long insertar(AdministradorDTO administradorDTO) throws NegocioException, DaoException;
	
	public void actualizar(AdministradorDTO administradorDTO)  throws NegocioException, DaoException;
	
	public void eliminar(Long idAdministrador)  throws NegocioException, DaoException;
	
	public AdministradorDTO obtener(Long idAdministrador)  throws NegocioException, DaoException;
	
	public List<AdministradorDTO> obtenerListado() throws DaoException;
	
	public List<AdministradorDTO> obtenerListadoPorTipo(Long idTipoAdmin) throws DaoException;
	
	public AdministradorDTO obtenerAdminPorEmailYPass(String email, String pass) throws NegocioException, DaoException;
}
