package com.geored.negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.jws.WebMethod;
import javax.jws.WebService;

import com.geored.dto.SitioDTO;
import com.geored.exceptions.NegocioException;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@WebService
public class SitioServiceImpl implements SitioService
{
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public Long insertar(SitioDTO SitioDTO) throws NegocioException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public void actualizar(SitioDTO SitioDTO) throws NegocioException
	{
		// TODO Auto-generated method stub
		
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public void eliminar(Long idAdministrador) throws NegocioException
	{
		// TODO Auto-generated method stub
		
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public SitioDTO obtener(Long idAdministrador) throws NegocioException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public List<SitioDTO> obtenerListado()
	{
		// TODO Auto-generated method stub
		return null;
	}
	
}