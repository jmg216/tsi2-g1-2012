package com.geored.persistencia;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.geored.dominio.Local;
import com.geored.dto.LocalDTO;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class LocalDAOImpl extends GenericDAOBase<Local, LocalDTO> implements LocalDAO
{

	@Override
	public void dtoToEntity(LocalDTO source, Local target)
	{
		target.setNombre(source.getNombre());
		target.setUbicacionGeografica(source.getUbicacionGeografica());
	}

	@Override
	public void entityToDto(Local source, LocalDTO target)
	{
		target.setId(source.getId());
		target.setNombre(source.getNombre());
		target.setUbicacionGeografica(source.getUbicacionGeografica());
		
		if(source.getEmpresa() != null)
		{
			target.setIdEmpresa(source.getEmpresa().getId());
			target.setNombreEmpresa(source.getEmpresa().getNombre());
		}		
	}
}