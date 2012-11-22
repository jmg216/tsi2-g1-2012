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
import javax.jws.WebService;

import com.geored.dominio.Local;
import com.geored.dominio.Oferta;
import com.geored.dominio.Tematica;
import com.geored.dto.OfertaDTO;
import com.geored.dto.TematicaDTO;
import com.geored.exceptions.DaoException;
import com.geored.exceptions.NegocioException;
import com.geored.persistencia.LocalDAO;
import com.geored.persistencia.OfertaDAO;
import com.geored.persistencia.TematicaDAO;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@WebService
public class OfertaServiceImpl implements OfertaService
{
	@EJB
	private OfertaDAO ofertaDAO;
	
	@EJB
	private LocalDAO localDAO;
	
	@EJB
	private TematicaDAO tematicaDAO;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public Long insertar(OfertaDTO ofertaDTO) throws NegocioException, DaoException
	{
		if(ofertaDAO.obtenerPorNombreYLocal(ofertaDTO.getNombre(), ofertaDTO.getIdLocal(), false) != null)
		{
			throw new NegocioException("Ya existe una oferta con este nombre para el local indicado");
		}
		
		Oferta ofertaEntity = ofertaDAO.toEntity(ofertaDTO);
		
		Local localEntity = (Local) localDAO.obtener(ofertaDTO.getIdLocal(), false);
		
		if(localEntity == null)
		{
			throw new NegocioException("Local no encontrado");
		}
		
		ofertaEntity.setLocal(localEntity);
		
		asociarTematicas(ofertaDTO, ofertaEntity);
		
		ofertaDAO.insertar(ofertaEntity);
		
		return ofertaEntity.getId();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public void actualizar(OfertaDTO ofertaDTO) throws NegocioException, DaoException
	{
		Oferta ofertaEntity = (Oferta) ofertaDAO.obtenerPorNombreYLocal(ofertaDTO.getNombre(), ofertaDTO.getIdLocal(), false);
		
		if(ofertaEntity != null && !ofertaEntity.getId().equals(ofertaDTO.getId()))
		{	
			throw new NegocioException("Ya existe una oferta con este nombre para el local indicado");
		}		
				
		ofertaEntity = (Oferta) ofertaDAO.obtener(ofertaDTO.getId(), false);
		
		if(ofertaEntity == null)
		{
			throw new NegocioException("Oferta no encontrada");
		}
		
		ofertaDAO.toEntity(ofertaDTO, ofertaEntity);
		
		Local localEntity = (Local) localDAO.obtener(ofertaDTO.getIdLocal(), false);
		
		if(localEntity == null)
		{
			throw new NegocioException("Local no encontrado");
		}
		
		ofertaEntity.setLocal(localEntity);
		
		asociarTematicas(ofertaDTO, ofertaEntity);
		
		ofertaDAO.actualizar(ofertaEntity);			
	}
	
	private void asociarTematicas(OfertaDTO ofertaDTO, Oferta ofertaEntity) throws DaoException, NegocioException
	{
		// Cargo la lista de tematicas para la oferta
		if(ofertaEntity.getListaTematicas() == null)
		{
			ofertaEntity.setListaTematicas(new ArrayList<Tematica>());
		}
		else
		{
			ofertaEntity.getListaTematicas().clear();
		}
		
		if(ofertaDTO.getListaTematicasDTO() != null)
		{			
			for(TematicaDTO tematicaDTO : ofertaDTO.getListaTematicasDTO())
			{
				Tematica tematica = (Tematica) tematicaDAO.obtener(tematicaDTO.getId(), false);
				
				if(tematica == null)
				{
					throw new NegocioException("La tematica (" + tematicaDTO.getId() + ") no existe");
				}
				
				ofertaEntity.getListaTematicas().add(tematica);
			}
		}
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public void eliminar(Long idOferta) throws NegocioException, DaoException
	{
		Oferta ofertaEntity = (Oferta) ofertaDAO.obtener(idOferta, false);
		
		if(ofertaEntity == null)
		{
			throw new NegocioException("Oferta no encontrada");
		}
		
		ofertaDAO.eliminar(ofertaEntity);
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public OfertaDTO obtener(Long idOferta) throws NegocioException, DaoException
	{
		OfertaDTO ofertaDTO = (OfertaDTO) ofertaDAO.obtener(idOferta, true);
		
		if(ofertaDTO == null)
		{
			throw new NegocioException("Oferta no encontrada");
		}
		
		return ofertaDTO;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public List<OfertaDTO> obtenerListado() throws DaoException
	{
		return ofertaDAO.obtenerListado(true);		
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public List<OfertaDTO> obtenerListadoPorEmpresa(Long idEmpresa) throws DaoException
	{
		return ofertaDAO.obtenerListadoPorEmpresa(idEmpresa, true);
	}
}
