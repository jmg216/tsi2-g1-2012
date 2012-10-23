package com.geored.persistencia;

import java.sql.Timestamp;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.geored.dominio.CheckIn;
import com.geored.dto.CheckInDTO;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class CheckInDAOImpl extends GenericDAOBase<CheckIn, CheckInDTO> implements CheckInDAO
{

	@Override
	public void dtoToEntity(CheckInDTO source, CheckIn target)
	{		
		target.setNombre(source.getNombre());
		target.setFechaCreacion(new Timestamp(source.getFechaCreacion().getTime()));
	}

	@Override
	public void entityToDto(CheckIn source, CheckInDTO target)
	{
		target.setId(source.getId());
		target.setNombre(source.getNombre());
		target.setFechaCreacion(source.getFechaCreacion());
		
		if(source.getUsuario() != null)
		{
			target.setIdUsuario(source.getUsuario().getId());
			target.setNombreUsuario(source.getUsuario().getNombre());
		}
		
		if(source.getSitio() != null)
		{
			target.setIdSitio(source.getSitio().getId());
			target.setNombreSitio(source.getSitio().getNombre());
		}	
	}	
}