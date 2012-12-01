package com.geored.persistencia;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.geored.dominio.Empresa;
import com.geored.dto.EmpresaDTO;
import com.geored.dto.LocalDTO;
import com.geored.exceptions.DaoException;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class EmpresaDAOImpl extends GenericDAOBase<Empresa, EmpresaDTO> implements EmpresaDAO
{
	@EJB
	private LocalDAO localDAO;
	
	@Override
	public void toEntity(EmpresaDTO source, Empresa target)
	{
		target.setNombre(source.getNombre());
		target.setDescripcion(source.getDescripcion());	
		target.setUrlImagen(source.getUrlImagen());
		
		if(source.getFechaCreacion() != null)
		{
			target.setFechaCreacion(new Timestamp(source.getFechaCreacion().getTime()));
		}
		
	}

	@Override
	public void toDto(Empresa source, EmpresaDTO target)
	{
		target.setId(source.getId());
		target.setNombre(source.getNombre());
		target.setDescripcion(source.getDescripcion());
		target.setUrlImagen(source.getUrlImagen());
		target.setFechaCreacion(source.getFechaCreacion());
		
		if(source.getAdministrador() != null)
		{
			target.setIdAdministrador(source.getAdministrador().getId());
			target.setNombreAdministrador(source.getAdministrador().getNombre());
		}		
		
		target.setListaLocalesDTO(new ArrayList<LocalDTO>());
		if(source.getListaLocales() != null)
		{			
			target.setListaLocalesDTO(localDAO.toDtoList(source.getListaLocales()));
		}
	}

	@Override
	public List obtenerListadoPorAdministrador(Long idAdministrador, boolean toDTO) throws DaoException
	{
		try
		{
			Query query = em.createQuery("SELECT e FROM com.geored.dominio.Empresa e where e.administrador.id = ?1");
			query.setParameter(1, idAdministrador);
			
			List<Empresa> listaEmpresas = query.getResultList();
			
			if(toDTO)
			{			
				return toDtoList(listaEmpresas);			
			}
			
			return listaEmpresas;
		}
		catch(Throwable e)
		{
			throw new DaoException(e.getMessage());
		}
	}

	@Override
	public Object obtenerPorNombre(String nombre, boolean toDTO) throws DaoException
	{
		try
		{
			Query query = em.createQuery("select e from com.geored.dominio.Empresa e where e.nombre = ?1");        
	        query.setParameter(1, nombre);      	       
	        
	        try
	        {
	        	 Empresa empresaEntity = (Empresa) query.getSingleResult();
	        	 
	        	 if(toDTO)
	             {        	
	             	return toDto(empresaEntity);
	             }
	        	 
	        	 return empresaEntity;
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
}