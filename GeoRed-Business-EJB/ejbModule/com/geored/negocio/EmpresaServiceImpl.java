package com.geored.negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.jws.WebMethod;
import javax.jws.WebService;

import com.geored.dto.EmpresaDTO;
import com.geored.exceptions.NegocioException;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@WebService
public class EmpresaServiceImpl implements EmpresaService
{
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public Long insertar(EmpresaDTO EmpresaDTO)  throws NegocioException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public void actualizar(EmpresaDTO EmpresaDTO)  throws NegocioException
	{
		// TODO Auto-generated method stub
		
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public void eliminar(Long idAdministrador)  throws NegocioException
	{
		// TODO Auto-generated method stub
		
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public EmpresaDTO obtener(Long idAdministrador)  throws NegocioException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public List<EmpresaDTO> obtenerListado()
	{
		// TODO Auto-generated method stub
		return null;
	}
	
}