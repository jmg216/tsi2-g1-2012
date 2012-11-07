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
	public CheckIn toEntity(CheckInDTO source)
	{		
		CheckIn target = new CheckIn();
		
		target.setNombre(source.getNombre());
		target.setFechaCreacion(new Timestamp(source.getFechaCreacion().getTime()));
		
		return target;
	}

	@Override
	public CheckInDTO toDto(CheckIn source)
	{
		CheckInDTO target = new CheckInDTO();
		
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
		
		return target;
	}	
}