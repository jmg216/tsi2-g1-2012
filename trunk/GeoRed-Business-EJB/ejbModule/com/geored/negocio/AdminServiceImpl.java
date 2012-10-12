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

import com.geored.dto.AdministradorDTO;
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
	public Long insertar(AdministradorDTO administradorDTO)
	{
		return null;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public void actualizar(AdministradorDTO administradorDTO)
	{
		// TODO Auto-generated method stub
		
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public void eliminar(Long idAdministrador)
	{
		// TODO Auto-generated method stub
		
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public AdministradorDTO obtener(Long idAdministrador)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public List<AdministradorDTO> obtenerListado()
	{
		// TODO Auto-generated method stub
		return null;
	}
}