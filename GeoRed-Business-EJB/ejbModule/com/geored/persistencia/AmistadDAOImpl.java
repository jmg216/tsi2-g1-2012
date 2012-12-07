package com.geored.persistencia;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.Query;

import com.geored.dominio.Amistad;
import com.geored.dominio.Usuario;
import com.geored.dto.AmistadDTO;
import com.geored.exceptions.DaoException;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AmistadDAOImpl extends GenericDAOBase<Amistad, AmistadDTO> implements AmistadDAO
{
	@EJB
	private MensajeAmistadDAO mensajeAmistadDAO;
	
	@Override
	public void toEntity(AmistadDTO source, Amistad target)
	{		
	}

	@Override
	public void toDto(Amistad source, AmistadDTO target)
	{
		target.setId(source.getId());
		
		if(source.getUsuarioA() != null)
		{
			target.setIdUsuarioA(source.getUsuarioA().getId());
			target.setNombreUsuarioA(source.getUsuarioA().getNombre());
		}
		
		if(source.getUsuarioB() != null)
		{
			target.setIdUsuarioB(source.getUsuarioB().getId());
			target.setNombreUsuarioB(source.getUsuarioB().getNombre());
		}	
		
		if(source.getListaMensajes() != null)
		{
			target.setListaMensajesDTO(mensajeAmistadDAO.toDtoList(source.getListaMensajes()));
		}
	}

	@Override
	public List obtenerAmistadesUsuario(Long idUsuario, boolean soloConectados, boolean toDTO) throws DaoException
	{
		try
		{
			String strQuery = "select a from com.geored.dominio.Amistad a where (a.usuarioA.id = ?1 or a.usuarioB.id = ?1)";
			
			if(soloConectados)
			{
				strQuery += " and a.conectado = 1";
			}
			
			Query query = em.createQuery(strQuery);        
	        query.setParameter(1, idUsuario);        
	        
	        List listaUsuarios = query.getResultList();
	        
	        if(toDTO)
	        {
	             return toDtoList(listaUsuarios);
	        }
	       
	        return listaUsuarios;
		}
		catch(Throwable e)
		{
			throw new DaoException(e.getMessage());		
		}
	}	
	
	
	@Override
	public Object obtenerAmistadPorUsuarios(Long idUsuarioA, Long idUsuarioB, boolean toDTO) throws DaoException
	{
		try
		{
			String strQuery = "select a from com.geored.dominio.Amistad a where ((a.usuarioA.id = ?1 and a.usuarioB.id = ?2) or (a.usuarioA.id = ?2 and a.usuarioB.id = ?1))";			
			
			Query query = em.createQuery(strQuery);        
	        query.setParameter(1, idUsuarioA);        
	        query.setParameter(2, idUsuarioB); 
	        
	        return (query.getSingleResult() != null);	        
		}
		catch(Throwable e)
		{
			throw new DaoException(e.getMessage());
		}
	}		
}