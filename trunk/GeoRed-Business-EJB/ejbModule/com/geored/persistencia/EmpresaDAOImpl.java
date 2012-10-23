package com.geored.persistencia;

import java.sql.Timestamp;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.geored.dominio.Empresa;
import com.geored.dto.EmpresaDTO;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class EmpresaDAOImpl extends GenericDAOBase<Empresa, EmpresaDTO> implements EmpresaDAO
{

	@Override
	public void dtoToEntity(EmpresaDTO source, Empresa target)
	{
		target.setNombre(source.getNombre());
		target.setDescripcion(source.getDescripcion());
		target.setFechaCreacion(new Timestamp(source.getFechaCreacion().getTime()));
		target.setLogoUrl(source.getLogoUrl());
	}

	@Override
	public void entityToDto(Empresa source, EmpresaDTO target)
	{
		target.setId(source.getId());
		target.setNombre(source.getNombre());
		target.setDescripcion(source.getDescripcion());
		target.setFechaCreacion(source.getFechaCreacion());
		target.setLogoUrl(source.getLogoUrl());
		
		if(source.getAdministrador() != null)
		{
			target.setIdAministrador(source.getAdministrador().getId());
			target.setNombreAdministrador(source.getAdministrador().getNombre());
		}		
	}	
}