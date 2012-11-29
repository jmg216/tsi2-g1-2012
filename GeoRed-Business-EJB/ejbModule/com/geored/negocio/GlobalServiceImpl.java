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

import com.geored.dto.OfertaDTO;
import com.geored.dto.TematicaDTO;
import com.geored.dto.TipoAdministradorDTO;
import com.geored.dto.TipoNotificacionDTO;
import com.geored.exceptions.DaoException;
import com.geored.exceptions.NegocioException;
import com.geored.persistencia.TematicaDAO;
import com.geored.persistencia.TipoAdministradorDAO;
import com.geored.persistencia.TipoNotificacionDAO;
import com.geored.utiles.JsonParamsMap;
import com.google.gson.Gson;

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
	
	@WebMethod(operationName="androidInvocation")
	public String androidInvocation(@WebParam(name="methodName") String methodName, @WebParam(name="methodParams") String methodParams) throws NegocioException, DaoException
	{		
		JsonParamsMap params = new JsonParamsMap(methodParams);
		
		if(methodName.equals("obtenerListadoTiposAdministradores"))
		{		
			return new Gson().toJson(obtenerListadoTiposAdministradores());
		}
		else if(methodName.equals("obtenerListadoTematicas"))
		{
			return new Gson().toJson(obtenerListadoTematicas());
		}
		else if(methodName.equals("obtenerListadoTiposNotificaciones"))
		{
			return new Gson().toJson(obtenerListadoTiposNotificaciones());
		}
		
		return "";
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public List<TipoAdministradorDTO> obtenerListadoTiposAdministradores() throws DaoException
	{
		return tipoAdministradorDAO.obtenerListado(true);
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public List<TematicaDTO> obtenerListadoTematicas() throws DaoException
	{
		return tematicaDAO.obtenerListado(true);
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public List<TipoNotificacionDTO> obtenerListadoTiposNotificaciones() throws DaoException
	{
		return tipoNotificacionDAO.obtenerListado(true);
	}
}