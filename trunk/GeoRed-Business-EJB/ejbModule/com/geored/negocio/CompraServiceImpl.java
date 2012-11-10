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

import com.geored.dominio.Compra;
import com.geored.dominio.Oferta;
import com.geored.dominio.Usuario;
import com.geored.dto.CompraDTO;
import com.geored.exceptions.DaoException;
import com.geored.exceptions.NegocioException;
import com.geored.persistencia.CompraDAO;
import com.geored.persistencia.OfertaDAO;
import com.geored.persistencia.UsuarioDAO;

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
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public Long insertar(CompraDTO compraDTO) throws NegocioException, DaoException
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
	public void actualizar(CompraDTO compraDTO) throws NegocioException, DaoException
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
		
		compraEntity.setUsuario(usuarioEntity);
		
		compraEntity.setOferta(ofertaEntity);
		
		compraDAO.actualizar(compraEntity);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public void eliminar(Long idCompra) throws NegocioException, DaoException
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
	public CompraDTO obtener(Long idCompra) throws NegocioException, DaoException
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
}