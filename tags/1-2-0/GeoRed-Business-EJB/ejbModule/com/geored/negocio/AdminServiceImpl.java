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

import com.geored.dominio.Administrador;
import com.geored.dto.AdministradorDTO;
import com.geored.exceptions.DaoException;
import com.geored.exceptions.NegocioException;
import com.geored.persistencia.AdministradorDAO;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@WebService
public class AdminServiceImpl implements AdminService
{
	@EJB
	private AdministradorDAO administradorDAO;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public Long insertar(AdministradorDTO administradorDTO) throws NegocioException, DaoException
	{
		try
		{
			Administrador administradorEntity = new Administrador();
			
			administradorDAO.dtoToEntity(administradorDTO, administradorEntity);
			
			administradorDAO.insertar(administradorEntity);
			
			return administradorEntity.getId();
		}
		catch(Throwable e)
		{
			throw new DaoException(e);
		}
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public void actualizar(AdministradorDTO administradorDTO) throws NegocioException, DaoException
	{
		try
		{
			Administrador administradorEntity = (Administrador) administradorDAO.obtener(administradorDTO.getId(), false);
			
			if(administradorEntity == null)
			{
				throw new NegocioException("Administrador no encontrado");
			}
			
			administradorDAO.dtoToEntity(administradorDTO, administradorEntity);
			
			administradorDAO.actualizar(administradorEntity);			
		}
		catch(Throwable e)
		{
			throw new DaoException(e);
		}
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED) 
	@WebMethod
	public void eliminar(Long idAdministrador) throws NegocioException, DaoException
	{
		try
		{
			Administrador administradorEntity = (Administrador) administradorDAO.obtener(idAdministrador, false);
			
			if(administradorEntity == null)
			{
				throw new NegocioException("Administrador no encontrado");
			}
			
			administradorDAO.eliminar(administradorEntity);
		}
		catch(Throwable e)
		{
			throw new DaoException(e);
		}
		
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public AdministradorDTO obtener(Long idAdministrador) throws NegocioException, DaoException
	{
		try
		{
			AdministradorDTO administradorDTO = (AdministradorDTO) administradorDAO.obtener(idAdministrador, true);
			
			if(administradorDTO == null)
			{
				throw new NegocioException("Administrador no encontrado");
			}
			
			return administradorDTO;
		}
		catch(Throwable e)
		{
			throw new DaoException(e);
		}
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public List<AdministradorDTO> obtenerListado() throws DaoException
	{
		try
		{
			return administradorDAO.obtenerListado(true);
		}
		catch(Throwable e)
		{
			throw new DaoException(e);
		}
	}

	@Override
	public AdministradorDTO obtenerAdminPorEmailYPass(String email, String pass) throws NegocioException, DaoException
	{
		try
		{
			AdministradorDTO adminDTO = (AdministradorDTO) administradorDAO.obtenerAdminPorEmailYPass(email, pass, true);
			
			if(adminDTO == null)
			{
				throw new NegocioException("Administrador no encontrado");
			}
			
			return adminDTO;
		}
		catch(Throwable e)
		{
			throw new DaoException(e);
		}
	}
}