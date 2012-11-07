package com.geored.persistencia;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.geored.dominio.Amistad;
import com.geored.dto.AmistadDTO;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AmistadDAOImpl extends GenericDAOBase<Amistad, AmistadDTO> implements AmistadDAO
{

	@Override
	public Amistad toEntity(AmistadDTO source)
	{		
		Amistad target = new Amistad();
		
		return target;
	}

	@Override
	public AmistadDTO toDto(Amistad source)
	{
		AmistadDTO target = new AmistadDTO();
		
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
		
		return target;
	}	
}