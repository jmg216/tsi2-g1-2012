package com.geored.persistencia;

import java.sql.Timestamp;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.Query;

import com.geored.dominio.Compra;
import com.geored.dto.CompraDTO;
import com.geored.exceptions.DaoException;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class CompraDAOImpl extends GenericDAOBase<Compra, CompraDTO> implements CompraDAO
{
	@Override
	public void toEntity(CompraDTO source, Compra target)
	{
		target.setFechaCreacion(new Timestamp(source.getFechaCreacion().getTime()));
	}

	@Override
	public void toDto(Compra source, CompraDTO target)
	{
		target.setId(source.getId());
		target.setFechaCreacion(source.getFechaCreacion());
		
		if(source.getUsuario() != null)
		{
			target.setIdUsuario(source.getUsuario().getId());
			target.setNombreUsuario(source.getUsuario().getNombre());
		}
		
		if(source.getOferta() != null)
		{
			target.setIdOferta(source.getOferta().getId());
			target.setNombreOferta(source.getOferta().getNombre());
		}
	}

	@Override
	public List obtenerListadoPorOferta(Long idOferta, boolean toDTO) throws DaoException
	{
		try
		{
			Query query = em.createQuery("select c from com.geored.dominio.Compra c where c.oferta.id = ?1");        
	        query.setParameter(1, idOferta);        
	        
	        List<Compra> listaComprasEntity = query.getResultList();
        	 
        	if(toDTO)
            {        	
        		return toDtoList(listaComprasEntity);
            }
	        
	        return listaComprasEntity;
		}
		catch(Throwable e)
		{
			throw new DaoException(e.getMessage());
		}
	}	
}