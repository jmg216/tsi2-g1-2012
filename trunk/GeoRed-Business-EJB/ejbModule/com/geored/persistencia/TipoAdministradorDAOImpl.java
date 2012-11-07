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
	public TipoAdministrador toEntity(TipoAdministradorDTO source)
	{
		TipoAdministrador target = new TipoAdministrador();
		
		target.setNombre(source.getNombre());
		
		return target;
	}

	@Override
	public TipoAdministradorDTO toDto(TipoAdministrador source)
	{
		TipoAdministradorDTO target = new TipoAdministradorDTO();
		
		target.setId(source.getId());
		target.setNombre(source.getNombre());
		
		return target;
	}	
}