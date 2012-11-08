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

import com.geored.dto.TematicaDTO;
import com.geored.dto.TipoAdministradorDTO;
import com.geored.dto.TipoNotificacionDTO;
import com.geored.exceptions.DaoException;
import com.geored.persistencia.TematicaDAO;
import com.geored.persistencia.TipoAdministradorDAO;
import com.geored.persistencia.TipoNotificacionDAO;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@WebService
public class GlobalServiceImpl implements GlobalService
{
	@EJB
	private TipoAdministradorDAO tipoAdministradorDAO;
	
	@EJB
	private TematicaDAO tematicaDAO;
	
	@EJB
	private TipoNotificacionDAO tipoNotificacionDAO;
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public List<TipoAdministradorDTO> obtenerListadoTiposAdministradores() throws DaoException
	{
		try
		{		
			return tipoAdministradorDAO.obtenerListado(true);
		}
		catch(Throwable e)
		{
			throw new DaoException(e);
		}
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public List<TematicaDTO> obtenerListadoTematicas() throws DaoException
	{
		try
		{		
			return tematicaDAO.obtenerListado(true);
		}
		catch(Throwable e)
		{
			throw new DaoException(e);
		}
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public List<TipoNotificacionDTO> obtenerListadoTiposNotificaciones() throws DaoException
	{
		try
		{		
			return tipoNotificacionDAO.obtenerListado(true);
		}
		catch(Throwable e)
		{
			throw new DaoException(e);
		}
	}
	
	
	
}