package com.geored.negocio;

import java.util.List;

import javax.ejb.Local;

import com.geored.dto.CheckInDTO;
import com.geored.dto.UsuarioDTO;
import com.geored.exceptions.DaoException;
import com.geored.exceptions.NegocioException;

@Local
public interface UsuarioService
{
	// Metodo que atiende las solicitudes con contenido JSON, parsea e invoca el metodo correspondiente
	public String androidInvocation(String jsonBody, String methodName) throws NegocioException, DaoException;
	
	public Long insertar(UsuarioDTO usuarioDTO)  throws NegocioException, DaoException;
	
	public void actualizar(UsuarioDTO usuarioDTO)  throws NegocioException, DaoException;
	
	public void eliminar(Long idUsuario)  throws NegocioException, DaoException;
	
	public UsuarioDTO obtener(Long idUsuario)  throws NegocioException, DaoException;
	
	public List<UsuarioDTO> obtenerListado() throws DaoException;
	
	public UsuarioDTO obtenerPorEmailYPass(String email, String pass) throws NegocioException, DaoException;
	
	// OPERACIONES CON CHECK-INS
	public List<CheckInDTO> obtenerListadoCheckIns() throws DaoException;
}