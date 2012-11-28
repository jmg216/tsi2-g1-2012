package com.geored.negocio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.geored.dominio.Usuario;
import com.geored.dto.CheckInDTO;
import com.geored.dto.UsuarioDTO;
import com.geored.exceptions.DaoException;
import com.geored.exceptions.NegocioException;
import com.geored.persistencia.CheckInDAO;
import com.geored.persistencia.UsuarioDAO;
import com.google.gson.Gson;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@WebService
public class UsuarioServiceImpl implements UsuarioService
{
	@EJB
	private UsuarioDAO usuarioDAO;
	
	@EJB
	private CheckInDAO checkInDAO;
	
	@WebMethod(operationName="androidInvocation")
	public String androidInvocation(@WebParam(name="jsonBody") String jsonBody, @WebParam(name="methodName") String methodName) throws NegocioException, DaoException
	{
		Gson gson = new Gson();
		
		if(methodName.equals("insertar"))
		{
			UsuarioDTO usuarioDTO = gson.fromJson(jsonBody, UsuarioDTO.class);
			
			Long idUsuario = insertar(usuarioDTO);
			
			return gson.toJson(idUsuario);
		}
		else if(methodName.equals("actualizar"))
		{
			UsuarioDTO usuarioDTO = gson.fromJson(jsonBody, UsuarioDTO.class);
			
			actualizar(usuarioDTO);
		}
		else if(methodName.equals("eliminar"))
		{
			Long idUsuario = gson.fromJson(jsonBody, Long.class);
			
			eliminar(idUsuario);
		}
		else if(methodName.equals("obtener"))
		{
			Long idUsuario = gson.fromJson(jsonBody, Long.class);
			
			UsuarioDTO usuarioDTO = obtener(idUsuario);
			
			return gson.toJson(usuarioDTO);
		}
		else if(methodName.equals("obtenerListado"))
		{
			return gson.toJson(obtenerListado());
		}
		else if(methodName.equals("obtenerPorEmailYPass"))
		{
			String email = gson.fromJson(jsonBody, String.class);
			String pass = gson.fromJson(jsonBody, String.class);
			
			UsuarioDTO usuarioDTO = obtenerPorEmailYPass(email, pass);
			
			return gson.toJson(usuarioDTO);
		}
		else if(methodName.equals("obtenerListadoCheckIns"))
		{
			return gson.toJson(obtenerListadoCheckIns());
		}
	
		return "";
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod(operationName="insertar")
	public Long insertar(@WebParam(name="usuarioDTO") UsuarioDTO usuarioDTO) throws NegocioException, DaoException
	{
		Usuario usuarioEntity = usuarioDAO.toEntity(usuarioDTO);
		
		usuarioDAO.insertar(usuarioEntity);
		
		return usuarioEntity.getId();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod(operationName="actualizar")
	public void actualizar(@WebParam(name="usuarioDTO") UsuarioDTO usuarioDTO) throws NegocioException, DaoException
	{
		Usuario usuarioEntity = (Usuario) usuarioDAO.obtener(usuarioDTO.getId(), false);
		
		if(usuarioEntity == null)
		{
			throw new NegocioException("Oferta no encontrada");
		}
		
		usuarioDAO.toEntity(usuarioDTO, usuarioEntity);
		
		usuarioDAO.actualizar(usuarioEntity);			
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod(operationName="eliminar") 
	public void eliminar(@WebParam(name="idUsuario") Long idUsuario) throws NegocioException, DaoException
	{
		Usuario usuarioEntity = (Usuario) usuarioDAO.obtener(idUsuario, false);
		
		if(usuarioEntity == null)
		{
			throw new NegocioException("Usuario no encontrado");
		}
		
		usuarioDAO.eliminar(usuarioEntity);
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod(operationName="obtener")
	public UsuarioDTO obtener(@WebParam(name="idUsuario") Long idUsuario) throws NegocioException, DaoException
	{
		UsuarioDTO usuarioDTO = (UsuarioDTO) usuarioDAO.obtener(idUsuario, true);
		
		if(usuarioDTO == null)
		{
			throw new NegocioException("Usuario no encontrado");
		}
		
		return usuarioDTO;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod(operationName="obtenerListado")
	public List<UsuarioDTO> obtenerListado() throws DaoException
	{
		return usuarioDAO.obtenerListado(true);
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod(operationName="obtenerPorEmailYPass")
	public UsuarioDTO obtenerPorEmailYPass(@WebParam(name="email") String email, @WebParam(name="pass") String pass) throws NegocioException, DaoException
	{
		UsuarioDTO usuarioDTO = (UsuarioDTO) usuarioDAO.obtenerUsuarioPorEmailYPass(email, pass, true);
		
		if(usuarioDTO == null)
		{
			throw new NegocioException("Usuario no encontrado");
		}
		
		return usuarioDTO;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod(operationName="obtenerListadoCheckIns")
	public List<CheckInDTO> obtenerListadoCheckIns() throws DaoException
	{
		return checkInDAO.obtenerListado(true);
	}	
}