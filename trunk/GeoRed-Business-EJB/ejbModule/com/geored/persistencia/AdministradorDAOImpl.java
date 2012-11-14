package com.geored.persistencia;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.geored.dominio.Administrador;
import com.geored.dto.AdministradorDTO;
import com.geored.exceptions.DaoException;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AdministradorDAOImpl extends GenericDAOBase<Administrador, AdministradorDTO> implements AdministradorDAO
{	
	@Override
	public void toEntity(AdministradorDTO source, Administrador target)
	{
		target.setEmail(source.getEmail());
		target.setPass(source.getPass());
		target.setNombre(source.getNombre());
	}

	@Override
	public void toDto(Administrador source, AdministradorDTO target)
	{
		target.setId(source.getId());		
		target.setEmail(source.getEmail());
		target.setPass(source.getPass());
		target.setNombre(source.getNombre());
		
		if(source.getTipoAdministrador() != null)
		{						
			target.setIdTipoAdministrador(source.getTipoAdministrador().getId());
			target.setNombreTipoAdministrador(source.getTipoAdministrador().getNombre());
		}
	}

	@Override
	public Object obtenerAdminPorEmailYPass(String email, String pass, boolean toDTO) throws DaoException
	{
		try
		{
			Query query = em.createQuery("select a from com.geored.dominio.Administrador a where a.email = ?1 and a.pass = ?2");        
	        query.setParameter(1, email);        
	        query.setParameter(2, pass);
	        
	        Administrador adminEntity = null;
	        
	        try
	        {
	        	 adminEntity = (Administrador) query.getSingleResult();
	        	 
	        	 if(toDTO)
	             {        	
	             	return toDto(adminEntity);
	             }
	        }
	        catch(NoResultException e)
	        {
	        	return null;
	        }
	        
	        return adminEntity;
		}
		catch(Throwable e)
		{
			throw new DaoException(e.getMessage());
		}
	}

	@Override
	public Object obtenerAdminPorEmail(String email, boolean toDTO) throws DaoException
	{
		try
		{
			Query query = em.createQuery("select a from com.geored.dominio.Administrador a where a.email = ?1");        
	        query.setParameter(1, email);        
	        
	        Administrador adminEntity = null;
	        
	        try
	        {
	        	 adminEntity = (Administrador) query.getSingleResult();
	        	 
	        	 if(toDTO)
	             {        	
	             	return toDto(adminEntity);
	             }
	        }
	        catch(NoResultException e)
	        {
	        	return null;
	        }
	        
	        return adminEntity;
		}
		catch(Throwable e)
		{
			throw new DaoException(e.getMessage());
		}
	}
}