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
		Sitio sitioEntity = sitioDAO.toEntity(sitioDTO);
		
		sitioDAO.insertar(sitioEntity);
		
		return sitioEntity.getId();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public void actualizar(SitioDTO sitioDTO) throws NegocioException, DaoException
	{
		Sitio sitioEntity = (Sitio) sitioDAO.obtener(sitioDTO.getId(), false);
		
		if(sitioEntity == null)
		{
			throw new NegocioException("Sitio no encontrado");
		}
		
		sitioEntity = sitioDAO.toEntity(sitioDTO);
		
		sitioDAO.actualizar(sitioEntity);			
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public void eliminar(Long idSitio) throws NegocioException, DaoException
	{
		Sitio sitioEntity = (Sitio) sitioDAO.obtener(idSitio, false);
		
		if(sitioEntity == null)
		{
			throw new NegocioException("Sitio no encontrado");
		}
		
		sitioDAO.eliminar(sitioEntity);
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public SitioDTO obtener(Long idSitio) throws NegocioException, DaoException
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