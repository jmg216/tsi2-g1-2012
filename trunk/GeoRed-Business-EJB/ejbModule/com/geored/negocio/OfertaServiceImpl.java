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

import com.geored.dominio.Oferta;
import com.geored.dto.OfertaDTO;
import com.geored.exceptions.NegocioException;
import com.geored.persistencia.OfertaDAO;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@WebService
public class OfertaServiceImpl implements OfertaService
{
	@EJB
	private OfertaDAO ofertaDAO;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public Long insertar(OfertaDTO ofertaDTO) throws NegocioException
	{
		try
		{
			Oferta ofertaEntity = new Oferta();
			
			ofertaDAO.dtoToEntity(ofertaDTO, ofertaEntity);
			
			ofertaDAO.insertar(ofertaEntity);
			
			return ofertaEntity.getId();
		}
		catch(Throwable e)
		{
			throw new NegocioException(e);
		}
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public void actualizar(OfertaDTO ofertaDTO) throws NegocioException
	{
		try
		{
			Oferta eventoEntity = (Oferta) ofertaDAO.obtener(ofertaDTO.getId(), false);
			
			if(eventoEntity == null)
			{
				throw new NegocioException("Oferta no encontrada");
			}
			
			ofertaDAO.dtoToEntity(ofertaDTO, eventoEntity);
			
			ofertaDAO.actualizar(eventoEntity);			
		}
		catch(Throwable e)
		{
			throw new NegocioException(e);
		}
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public void eliminar(Long idOferta) throws NegocioException
	{
		try
		{
			Oferta ofertaEntity = (Oferta) ofertaDAO.obtener(idOferta, false);
			
			if(ofertaEntity == null)
			{
				throw new NegocioException("Oferta no encontrada");
			}
			
			ofertaDAO.eliminar(ofertaEntity);
		}
		catch(Throwable e)
		{
			throw new NegocioException(e);
		}
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public OfertaDTO obtener(Long idOferta) throws NegocioException
	{
		try
		{
			OfertaDTO ofertaDTO = (OfertaDTO) ofertaDAO.obtener(idOferta, true);
			
			if(ofertaDTO == null)
			{
				throw new NegocioException("Oferta no encontrada");
			}
			
			return ofertaDTO;
		}
		catch(Throwable e)
		{
			throw new NegocioException(e);
		}
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public List<OfertaDTO> obtenerListado()
	{
		return ofertaDAO.obtenerListado(true);
	}
	
}
