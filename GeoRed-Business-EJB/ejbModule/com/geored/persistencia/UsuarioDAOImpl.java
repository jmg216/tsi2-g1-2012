package com.geored.persistencia;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.Query;

import com.geored.dominio.Usuario;
import com.geored.dto.TematicaDTO;
import com.geored.dto.UsuarioDTO;
import com.geored.exceptions.DaoException;
import com.geored.exceptions.NegocioException;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class UsuarioDAOImpl extends GenericDAOBase<Usuario, UsuarioDTO> implements UsuarioDAO
{
	@EJB
	private TematicaDAO tematicaDAO;
	
	@EJB
	private OfertaDAO ofertaDAO;
	
	@Override
	public void toEntity(UsuarioDTO source, Usuario target)
	{
		target.setEmail(source.getEmail());
		target.setPass(source.getPass());
		target.setConectado(source.getConectado());
		target.setNombre(source.getNombre());
		target.setGcmRegId(source.getGcmRegId());
		target.setUrlImagen(source.getUrlImagen());
	}

	@Override
	public void toDto(Usuario source, UsuarioDTO target)
	{
		target.setId(source.getId());
		target.setEmail(source.getEmail());
		target.setConectado(source.getConectado());
		target.setPass(source.getPass());
		target.setNombre(source.getNombre());
		target.setGcmRegId(source.getGcmRegId());
		target.setUrlImagen(source.getUrlImagen());
		
		target.setListaTematicasDTO(new ArrayList<TematicaDTO>());
		if(source.getListaTematicas() != null)
		{
			target.setListaTematicasDTO(tematicaDAO.toDtoList(source.getListaTematicas()));
		}
	}
	
	public Object obtenerUsuarioPorEmailYPass(String email, String pass, boolean toDTO) throws DaoException
	{
		try
		{
			Query query = em.createQuery("select u from com.geored.dominio.Usuario u where u.email = ?1 and u.pass = ?2");        
	        query.setParameter(1, email);        
	        query.setParameter(2, pass);
	        
	        Usuario usuarioEntity = ((Usuario) query.getSingleResult());
	        
	        if(toDTO)
	        {
	             return toDto(usuarioEntity);
	        }
	       
	        return usuarioEntity;
		}
		catch(Throwable e)
		{
			throw new DaoException(e.getMessage());		
		}		
    }

	@Override
	public Object obtenerUsuarioPorEmail(String email, boolean toDTO) throws NegocioException, DaoException
	{
		try
		{
			Query query = em.createQuery("select u from com.geored.dominio.Usuario u where u.email = ?1");        
	        query.setParameter(1, email);        
	        
	        Usuario usuarioEntity = ((Usuario) query.getSingleResult());
	        
	        if(toDTO)
	        {
	             return toDto(usuarioEntity);
	        }
	       
	        return usuarioEntity;
		}
		catch(Throwable e)
		{
			return null;
			//throw new DaoException(e.getMessage());	
			
		}	
	}

	@Override
	public List obtenerListadoConectados(boolean toDTO) throws DaoException
	{
		try
		{
			Query query = em.createQuery("select u from com.geored.dominio.Usuario u where u.conectado = 1");        
	        
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
	public List obtenerListadoPorTematica(List<Long> idsTematicas, boolean toDTO) throws DaoException
	{
		try
		{
			Query query = em.createQuery("select u from com.geored.dominio.Usuario u left join u.listaTematicas tematica where tematica.id in (?1) ");        	        
			query.setParameter(1, idsTematicas);
			
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
}