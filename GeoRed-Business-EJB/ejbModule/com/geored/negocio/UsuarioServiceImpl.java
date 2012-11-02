package com.geored.negocio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.jws.WebMethod;
import javax.jws.WebService;

import com.geored.dominio.Usuario;
import com.geored.dto.CheckInDTO;
import com.geored.dto.UsuarioDTO;
import com.geored.exceptions.DaoException;
import com.geored.exceptions.NegocioException;
import com.geored.persistencia.CheckInDAO;
import com.geored.persistencia.UsuarioDAO;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@WebService
public class UsuarioServiceImpl implements UsuarioService
{
	@EJB
	private UsuarioDAO usuarioDAO;
	
	@EJB
	private CheckInDAO checkInDAO;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public Long insertar(UsuarioDTO usuarioDTO) throws NegocioException, DaoException
	{
		try
		{
			Usuario usuarioEntity = new Usuario();
			
			usuarioDAO.dtoToEntity(usuarioDTO, usuarioEntity);
			
			usuarioDAO.insertar(usuarioEntity);
			
			return usuarioEntity.getId();
		}
		catch(Throwable e)
		{
			throw new DaoException(e);
		}
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public void actualizar(UsuarioDTO usuarioDTO) throws NegocioException, DaoException
	{
		try
		{
			Usuario usuarioEntity = (Usuario) usuarioDAO.obtener(usuarioDTO.getId(), false);
			
			if(usuarioEntity == null)
			{
				throw new NegocioException("Oferta no encontrada");
			}
			
			usuarioDAO.dtoToEntity(usuarioDTO, usuarioEntity);
			
			usuarioDAO.actualizar(usuarioEntity);			
		}
		catch(Throwable e)
		{
			throw new DaoException(e);
		}
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod 
	public void eliminar(Long idUsuario) throws NegocioException, DaoException
	{
		try
		{
			Usuario usuarioEntity = (Usuario) usuarioDAO.obtener(idUsuario, false);
			
			if(usuarioEntity == null)
			{
				throw new NegocioException("Usuario no encontrado");
			}
			
			usuarioDAO.eliminar(usuarioEntity);
		}
		catch(Throwable e)
		{
			throw new DaoException(e);
		}
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public UsuarioDTO obtener(Long idUsuario) throws NegocioException, DaoException
	{
		try
		{
			UsuarioDTO usuarioDTO = (UsuarioDTO) usuarioDAO.obtener(idUsuario, true);
			
			if(usuarioDTO == null)
			{
				throw new NegocioException("Usuario no encontrado");
			}
			
			return usuarioDTO;
		}
		catch(Throwable e)
		{
			throw new NegocioException(e);
		}
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public List<UsuarioDTO> obtenerListado() throws DaoException
	{
		try
		{
			return usuarioDAO.obtenerListado(true);
		}
		catch(Throwable e)
		{
			throw new DaoException(e);
		}
		
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public UsuarioDTO obtenerPorEmailYPass(String email, String pass) throws NegocioException, DaoException
	{
		try
		{
			UsuarioDTO usuarioDTO = (UsuarioDTO) usuarioDAO.obtenerUsuarioPorEmailYPass(email, pass, true);
			
			if(usuarioDTO == null)
			{
				throw new NegocioException("Usuario no encontrado");
			}
			
			return usuarioDTO;
		}
		catch(Throwable e)
		{
			throw new DaoException();
		}
	
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public List<CheckInDTO> obtenerListadoCheckIns() throws DaoException
	{
		try
		{
			return checkInDAO.obtenerListado(true);
		}
		catch(Throwable e)
		{
			throw new DaoException(e);
		}
	}
	
}