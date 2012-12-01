package com.geored.negocio;

import java.util.ArrayList;
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

import com.geored.dominio.Sitio;
import com.geored.dominio.Tematica;
import com.geored.dto.SitioDTO;
import com.geored.dto.TematicaDTO;
import com.geored.exceptions.DaoException;
import com.geored.exceptions.NegocioException;
import com.geored.persistencia.SitioDAO;
import com.geored.persistencia.TematicaDAO;
import com.geored.utiles.JsonParamsMap;
import com.google.gson.Gson;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@WebService
public class SitioServiceImpl implements SitioService
{
	@EJB
	private SitioDAO sitioDAO;
	
	@EJB
	private TematicaDAO tematicaDAO;
	
	@WebMethod(operationName="androidInvocation")
	public String androidInvocation(@WebParam(name="methodName") String methodName, @WebParam(name="methodParams") String methodParams) throws NegocioException, DaoException
	{		
		JsonParamsMap params = new JsonParamsMap(methodParams);
		
		if(methodName.equals("insertar"))
		{		
			SitioDTO sitioDTO = (SitioDTO) params.getParam("sitioDTO", SitioDTO.class);
			
			return new Gson().toJson(insertar(sitioDTO));
		}
		else if(methodName.equals("actualizar"))
		{		
			SitioDTO sitioDTO = (SitioDTO) params.getParam("sitioDTO", SitioDTO.class);
			
			actualizar(sitioDTO);
		} 
		else if(methodName.equals("eliminar"))
		{		
			Long idSitio = (Long) params.getParam("idSitio", Long.class);
			
			eliminar(idSitio);
		}
		else if(methodName.equals("obtener"))
		{		
			Long idSitio = (Long) params.getParam("idSitio", Long.class);
			
			return new Gson().toJson(obtener(idSitio));
		}
		else if(methodName.equals("obtenerListado"))
		{		
			return new Gson().toJson(obtenerListado());
		}
		
		return "";
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public Long insertar(@WebParam(name="sitioDTO") SitioDTO sitioDTO) throws NegocioException, DaoException
	{
		if(sitioDAO.obtenerSitioPorNombre(sitioDTO.getNombre(), false) != null)
		{
			throw new NegocioException("Ya existe un sitio con ese nombre");
		}
		
		Sitio sitioEntity = sitioDAO.toEntity(sitioDTO);
		
		asociarTematicas(sitioDTO, sitioEntity);
		
		sitioDAO.insertar(sitioEntity);
		
		return sitioEntity.getId();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public void actualizar(@WebParam(name="sitioDTO") SitioDTO sitioDTO) throws NegocioException, DaoException
	{
		Sitio sitioEntity = (Sitio) sitioDAO.obtenerSitioPorNombre(sitioDTO.getNombre(), false);
		
		if(sitioEntity != null && !sitioEntity.getId().equals(sitioDTO.getId()))
		{
			throw new NegocioException("Ya existe un sitio con ese nombre");
		}
		
		// Si sigue no esta repetido sigo actualizando
		sitioEntity = (Sitio) sitioDAO.obtener(sitioDTO.getId(), false);
		
		if(sitioEntity == null)
		{
			throw new NegocioException("Sitio no encontrado");
		}
		
		sitioDAO.toEntity(sitioDTO, sitioEntity);
		
		asociarTematicas(sitioDTO, sitioEntity);
		
		sitioDAO.actualizar(sitioEntity);			
	}
	
	private void asociarTematicas(SitioDTO sitioDTO, Sitio sitioEntity) throws DaoException, NegocioException
	{
		// Cargo la lista de tematicas para el sitio
		if(sitioEntity.getListaTematicas() == null)
		{
			sitioEntity.setListaTematicas(new ArrayList<Tematica>());
		}
		else
		{
			sitioEntity.getListaTematicas().clear();
		}
		
		if(sitioDTO.getListaTematicasDTO() != null)
		{			
			for(TematicaDTO tematicaDTO : sitioDTO.getListaTematicasDTO())
			{
				Tematica tematica = (Tematica) tematicaDAO.obtener(tematicaDTO.getId(), false);
				
				if(tematica == null)
				{
					throw new NegocioException("La tematica (" + tematicaDTO.getId() + ") no existe");
				}
				
				sitioEntity.getListaTematicas().add(tematica);
			}
		}
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public void eliminar(@WebParam(name="idSitio") Long idSitio) throws NegocioException, DaoException
	{
		Sitio sitioEntity = (Sitio) sitioDAO.obtener(idSitio, false);
		
		if(sitioEntity == null)
		{
			throw new NegocioException("Sitio no encontrado");
		}
		
		if(sitioEntity.getListaTematicas() != null && !sitioEntity.getListaTematicas().isEmpty())
		{
			throw new NegocioException("El sitio no se puede eliminar, tiene tematicas asociadas");
		}
		
		sitioDAO.eliminar(sitioEntity);
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public SitioDTO obtener(@WebParam(name="idSitio") Long idSitio) throws NegocioException, DaoException
	{
		SitioDTO sitioDTO = (SitioDTO) sitioDAO.obtener(idSitio, true);
		
		if(sitioDTO == null)
		{
			throw new NegocioException("Sitio no encontrada");
		}
		
		return sitioDTO;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public List<SitioDTO> obtenerListado() throws DaoException
	{
		return sitioDAO.obtenerListado(true);
	}	
}