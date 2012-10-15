package com.geored.negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.jws.WebMethod;
import javax.jws.WebService;

import com.geored.dto.EventoDTO;
import com.geored.exceptions.NegocioException;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@WebService
public class EventoServiceImpl implements EventoService
{
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public Long insertar(EventoDTO EventoDTO)  throws NegocioException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public void actualizar(EventoDTO EventoDTO)  throws NegocioException
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
	public EventoDTO obtener(Long idAdministrador)  throws NegocioException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public List<EventoDTO> obtenerListado()
	{
		// TODO Auto-generated method stub
		return null;
	}
	
}