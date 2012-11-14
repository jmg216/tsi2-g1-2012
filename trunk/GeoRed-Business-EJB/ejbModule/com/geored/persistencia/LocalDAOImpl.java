package com.geored.persistencia;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.geored.dominio.Local;
import com.geored.dto.LocalDTO;
import com.geored.dto.OfertaDTO;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class LocalDAOImpl extends GenericDAOBase<Local, LocalDTO> implements LocalDAO
{
	@EJB
	private OfertaDAO ofertaDAO;
	
	@Override
	public void toEntity(LocalDTO source, Local target)
	{
		target.setNombre(source.getNombre());
		target.setDireccion(source.getDireccion());
		target.setUbicacionGeografica(source.getUbicacionGeografica());
	}

	@Override
	public void toDto(Local source, LocalDTO target)
	{
		target.setId(source.getId());
		target.setNombre(source.getNombre());
		target.setDireccion(source.getDireccion());
		target.setUbicacionGeografica(source.getUbicacionGeografica());
		
		if(source.getEmpresa() != null)
		{
			target.setIdEmpresa(source.getEmpresa().getId());
			target.setNombreEmpresa(source.getEmpresa().getNombre());
		}		
		
		target.setListaOfertas(new ArrayList<OfertaDTO>());
		if(source.getListaOfertas() != null)
		{
			target.setListaOfertas(ofertaDAO.toDtoList(source.getListaOfertas()));
		}
	}
}