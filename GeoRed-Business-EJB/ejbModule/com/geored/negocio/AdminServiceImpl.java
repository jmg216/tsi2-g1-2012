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
import com.geored.dominio.TipoAdministrador;
import com.geored.dto.AdministradorDTO;
import com.geored.exceptions.DaoException;
import com.geored.exceptions.NegocioException;
import com.geored.persistencia.AdministradorDAO;
import com.geored.persistencia.TipoAdministradorDAO;
import com.geored.utiles.UtilesNegocio;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@WebService
public class AdminServiceImpl implements AdminService
{
	@EJB
	private AdministradorDAO administradorDAO;
	
	@EJB
	private TipoAdministradorDAO tipoAdministradorDAO;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public Long insertar(AdministradorDTO administradorDTO) throws NegocioException, DaoException
	{
		//Verifico no exista otro administrador con el mismo email
		if(administradorDAO.obtenerAdminPorEmail(administradorDTO.getEmail(), false) != null)
		{
			throw new NegocioException("Ya existe un administrador con el email ingresado");
		}
		
		Administrador administradorEntity = administradorDAO.toEntity(administradorDTO);
		
		TipoAdministrador tipoAdministradorEntity = (TipoAdministrador) tipoAdministradorDAO.obtener(administradorDTO.getIdTipoAdministrador(), false);
		
		if(tipoAdministradorEntity == null)
		{
			throw new NegocioException("Tipo administrador no encontrado");
		}
		
		administradorEntity.setTipoAdministrador(tipoAdministradorEntity);				
		
		administradorDAO.insertar(administradorEntity);
		
		return administradorEntity.getId();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public void actualizar(AdministradorDTO administradorDTO) throws NegocioException, DaoException
	{
		//Verifico no exista otro administrador con el mismo email
		Administrador administradorEntity = (Administrador) administradorDAO.obtenerAdminPorEmail(administradorDTO.getEmail(), false);
		if(administradorEntity != null && !administradorEntity.getId().equals(administradorDTO.getId()))
		{
			throw new NegocioException("Ya existe un administrador con el email ingresado");
		}
		
		// Si no existe otro con el mismo email lo guardo
		administradorEntity = (Administrador) administradorDAO.obtener(administradorDTO.getId(), false);
		
		if(administradorEntity == null)
		{
			throw new NegocioException("Administrador no encontrado");
		}
		
		administradorDAO.toEntity(administradorDTO, administradorEntity);
		
		administradorDAO.actualizar(administradorEntity);			
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED) 
	@WebMethod
	public void eliminar(Long idAdministrador) throws NegocioException, DaoException
	{
		if(UtilesNegocio.ID_ADMIN_PRINCIPAL.equals(idAdministrador))
		{
			throw new NegocioException("No se puede eliminar el administrador principal");
		}
		
		Administrador administradorEntity = (Administrador) administradorDAO.obtener(idAdministrador, false);
		
		if(administradorEntity == null)
		{
			throw new NegocioException("Administrador no encontrado");
		}
		
		if(administradorEntity.getListaEmpresas() != null && !administradorEntity.getListaEmpresas().isEmpty())
		{
			throw new NegocioException("El administrador no se puede eliminar, tiene empresas asociadas");
		}
		
		try
		{
			administradorDAO.eliminar(administradorEntity);
		}
		catch(Exception e)
		{
			throw e;
		}
				
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public AdministradorDTO obtener(Long idAdministrador) throws NegocioException, DaoException
	{
		AdministradorDTO administradorDTO = (AdministradorDTO) administradorDAO.obtener(idAdministrador, true);
		
		if(administradorDTO == null)
		{
			throw new NegocioException("Administrador no encontrado");
		}
		
		return administradorDTO;	
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public List<AdministradorDTO> obtenerListado() throws DaoException
	{
		return administradorDAO.obtenerListado(true);		
	}

	@Override
	public AdministradorDTO obtenerAdminPorEmailYPass(String email, String pass) throws NegocioException, DaoException
	{
		AdministradorDTO adminDTO = (AdministradorDTO) administradorDAO.obtenerAdminPorEmailYPass(email, pass, true);
		
		if(adminDTO == null)
		{
			throw new NegocioException("Administrador no encontrado");
		}
		
		return adminDTO;
	}
}