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

import com.geored.dominio.Compra;
import com.geored.dominio.Oferta;
import com.geored.dominio.Usuario;
import com.geored.dto.CompraDTO;
import com.geored.exceptions.DaoException;
import com.geored.exceptions.NegocioException;
import com.geored.persistencia.CompraDAO;
import com.geored.persistencia.OfertaDAO;
import com.geored.persistencia.UsuarioDAO;
import com.geored.utiles.JsonParamsMap;
import com.google.gson.Gson;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@WebService
public class CompraServiceImpl implements CompraService
{
	@EJB
	private CompraDAO compraDAO;
	
	@EJB
	private UsuarioDAO usuarioDAO;
	
	@EJB
	private OfertaDAO ofertaDAO;
	
	@WebMethod
	public String androidInvocation(@WebParam(name="methodName") String methodName, @WebParam(name="methodParams") String methodParams) throws NegocioException, DaoException
	{		
		JsonParamsMap params = new JsonParamsMap(methodParams);
		
		if(methodName.equals("insertar"))
		{		
			CompraDTO compraDTO = (CompraDTO) params.getParam("compraDTO", CompraDTO.class);
			
			return new Gson().toJson(insertar(compraDTO));
		}
		else if(methodName.equals("actualizar"))
		{		
			CompraDTO compraDTO = (CompraDTO) params.getParam("compraDTO", CompraDTO.class);
			
			actualizar(compraDTO);
		} 
		else if(methodName.equals("eliminar"))
		{		
			Long idCompra = (Long) params.getParam("idCompra", Long.class);
			
			eliminar(idCompra);
		}
		else if(methodName.equals("obtener"))
		{		
			Long idCompra = (Long) params.getParam("idCompra", Long.class);
			
			return new Gson().toJson(obtener(idCompra));
		}
		else if(methodName.equals("obtenerListado"))
		{		
			return new Gson().toJson(obtenerListado());
		}
		
		return "";
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public Long insertar(@WebParam(name="compraDTO") CompraDTO compraDTO) throws NegocioException, DaoException
	{
		
		Compra compraEntity = compraDAO.toEntity(compraDTO);
		
		Usuario usuarioEntity = (Usuario) usuarioDAO.obtener(compraDTO.getIdUsuario(), false);
		
		if(usuarioEntity == null)
		{
			throw new NegocioException("Usuario no encontrado");
		}
		
		Oferta ofertaEntity = (Oferta) ofertaDAO.obtener(compraDTO.getIdOferta(), false);
		
		if(ofertaEntity == null)
		{
			throw new NegocioException("Oferta no encontrada");
		}
		
		compraEntity.setUsuario(usuarioEntity);
		
		compraEntity.setOferta(ofertaEntity);
		
		compraDAO.insertar(compraEntity);
		
		return compraEntity.getId();	
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public void actualizar(@WebParam(name="compraDTO") CompraDTO compraDTO) throws NegocioException, DaoException
	{
		Compra compraEntity = (Compra) compraDAO.obtener(compraDTO.getId(), false);
		
		if(compraEntity == null)
		{
			throw new NegocioException("Compra no encontrada");
		}
		
		Usuario usuarioEntity = (Usuario) usuarioDAO.obtener(compraDTO.getIdUsuario(), false);
		
		if(usuarioEntity == null)
		{
			throw new NegocioException("Usuario no encontrado");
		}
		
		Oferta ofertaEntity = (Oferta) ofertaDAO.obtener(compraDTO.getIdOferta(), false);
		
		if(ofertaEntity == null)
		{
			throw new NegocioException("Oferta no encontrada");
		}
		
		compraDAO.toEntity(compraDTO, compraEntity);
		
		compraEntity.setUsuario(usuarioEntity);
		
		compraEntity.setOferta(ofertaEntity);
		
		compraDAO.actualizar(compraEntity);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public void eliminar(@WebParam(name="idCompra") Long idCompra) throws NegocioException, DaoException
	{
		Compra compraEntity = (Compra) compraDAO.obtener(idCompra, false);
		
		if(compraEntity == null)
		{
			throw new NegocioException("Compra no encontrada");
		}
		
		compraDAO.eliminar(compraEntity);
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public CompraDTO obtener(@WebParam(name="idCompra") Long idCompra) throws NegocioException, DaoException
	{
		CompraDTO compraDTO = (CompraDTO) compraDAO.obtener(idCompra, true);
		
		if(compraDTO == null)
		{
			throw new NegocioException("Compra no encontrada");
		}
		
		return compraDTO;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public List<CompraDTO> obtenerListado() throws DaoException
	{
		return compraDAO.obtenerListado(true);
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public List<CompraDTO> obtenerListadoPorOferta(@WebParam(name="idOferta") Long idOferta) throws DaoException
	{
		return compraDAO.obtenerListadoPorOferta(idOferta, true);
	}
}