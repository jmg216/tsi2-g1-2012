package com.geored.persistencia;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.geored.dominio.Administrador;
import com.geored.dto.AdministradorDTO;
import com.geored.dto.EmpresaDTO;
import com.geored.exceptions.DaoException;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AdministradorDAOImpl extends GenericDAOBase<Administrador, AdministradorDTO> implements AdministradorDAO
{	
	@EJB
	private EmpresaDAO empresaDAO;
	
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
		
		target.setListaEmpresasDTO(new ArrayList<EmpresaDTO>());
		if(source.getListaEmpresas() != null)
		{
			target.setListaEmpresasDTO(empresaDAO.toDtoList(source.getListaEmpresas()));
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
	        
	        try
	        {
	        	Administrador adminEntity = (Administrador) query.getSingleResult();
	        	 
	        	 if(toDTO)
	             {        	
	             	return toDto(adminEntity);
	             }
	        	 
	        	 return adminEntity;
	        }
	        catch(NoResultException e)
	        {
	        	return null;
	        }
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
	        
	        try
	        {
	        	 Administrador adminEntity = (Administrador) query.getSingleResult();
	        	 
	        	 if(toDTO)
	             {        	
	             	return toDto(adminEntity);
	             }
	        	 
	        	 return adminEntity;
	        }
	        catch(NoResultException e)
	        {
	        	return null;
	        }
		}
		catch(Throwable e)
		{
			throw new DaoException(e.getMessage());
		}
	}

	@Override
	public List obtenerListadoPorTipo(Long idTipoAdmin, boolean toDTO) throws DaoException
	{
		try
		{
			Query query = em.createQuery("SELECT a FROM com.geored.dominio.Administrador a where a.tipoAdministrador.id = ?1");
			query.setParameter(1, idTipoAdmin);
			
			List<Administrador> listaAdministradores = query.getResultList();
			
			if(toDTO)
			{			
				return toDtoList(listaAdministradores);			
			}
			
			return listaAdministradores;
		}
		catch(Throwable e)
		{
			throw new DaoException(e.getMessage());
		}
	}
}