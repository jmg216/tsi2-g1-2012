package com.geored.negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.jws.WebMethod;
import javax.jws.WebService;

import com.geored.dto.OfertaDTO;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@WebService
public class OfertaServiceImpl implements OfertaService
{
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public Long insertar(OfertaDTO OfertaDTO)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public void actualizar(OfertaDTO OfertaDTO)
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
	public OfertaDTO obtener(Long idAdministrador)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public List<OfertaDTO> obtenerListado()
	{
		// TODO Auto-generated method stub
		return null;
	}
	
}
