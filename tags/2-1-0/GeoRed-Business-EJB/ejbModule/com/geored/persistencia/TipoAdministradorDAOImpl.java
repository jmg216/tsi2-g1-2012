package com.geored.persistencia;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.geored.dominio.TipoAdministrador;
import com.geored.dto.TipoAdministradorDTO;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TipoAdministradorDAOImpl extends GenericDAOBase<TipoAdministrador, TipoAdministradorDTO> implements TipoAdministradorDAO
{

	@Override
	public void toEntity(TipoAdministradorDTO source, TipoAdministrador target)
	{
		target.setNombre(source.getNombre());
	}

	@Override
	public void toDto(TipoAdministrador source, TipoAdministradorDTO target)
	{
		target.setId(source.getId());
		target.setNombre(source.getNombre());
	}	
}