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

import com.geored.dominio.Sitio;
import com.geored.dto.SitioDTO;
import com.geored.exceptions.DaoException;
import com.geored.exceptions.NegocioException;
import com.geored.persistencia.SitioDAO;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@WebService
public class SitioServiceImpl implements SitioService
{
	@EJB
	private SitioDAO sitioDAO;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public Long insertar(SitioDTO sitioDTO) throws NegocioException, DaoException
	{
		try
		{
			Sitio sitioEntity = new Sitio();
			
			sitioDAO.dtoToEntity(sitioDTO, sitioEntity);
			
			sitioDAO.insertar(sitioEntity);
			
			return sitioEntity.getId();
		}
		catch(Throwable e)
		{
			throw new DaoException(e);
		}
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public void actualizar(SitioDTO sitioDTO) throws NegocioException, DaoException
	{
		try
		{
			Sitio sitioEntity = (Sitio) sitioDAO.obtener(sitioDTO.getId(), false);
			
			if(sitioEntity == null)
			{
				throw new NegocioException("Sitio no encontrado");
			}
			
			sitioDAO.dtoToEntity(sitioDTO, sitioEntity);
			
			sitioDAO.actualizar(sitioEntity);			
		}
		catch(Throwable e)
		{
			throw new DaoException(e);
		}
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public void eliminar(Long idSitio) throws NegocioException, DaoException
	{
		try
		{
			Sitio sitioEntity = (Sitio) sitioDAO.obtener(idSitio, false);
			
			if(sitioEntity == null)
			{
				throw new NegocioException("Sitio no encontrado");
			}
			
			sitioDAO.eliminar(sitioEntity);
		}
		catch(Throwable e)
		{
			throw new DaoException(e);
		}
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public SitioDTO obtener(Long idSitio) throws NegocioException, DaoException
	{
		try
		{
			SitioDTO sitioDTO = (SitioDTO) sitioDAO.obtener(idSitio, true);
			
			if(sitioDTO == null)
			{
				throw new NegocioException("Sitio no encontrada");
			}
			
			return sitioDTO;
		}
		catch(Throwable e)
		{
			throw new DaoException(e);
		}
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public List<SitioDTO> obtenerListado() throws DaoException
	{
		try
		{
			return sitioDAO.obtenerListado(true);
		}
		catch(Throwable e)
		{
			throw new DaoException(e);
		}
		
	}
	
}