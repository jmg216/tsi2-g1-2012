package com.geored.persistencia;

import java.sql.Timestamp;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.geored.dominio.Empresa;
import com.geored.dominio.Local;
import com.geored.dto.EmpresaDTO;
import com.geored.dto.LocalDTO;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class EmpresaDAOImpl extends GenericDAOBase<Empresa, EmpresaDTO> implements EmpresaDAO
{
	@EJB
	private LocalDAO localDAO;
	
	@Override
	public Empresa toEntity(EmpresaDTO source)
	{
		Empresa target = new Empresa();
		
		target.setNombre(source.getNombre());
		target.setDescripcion(source.getDescripcion());	
		target.setUrlImagen(source.getUrlImagen());
		target.setFechaCreacion(new Timestamp(source.getFechaCreacion().getTime()));
		
		return target;
	}

	@Override
	public EmpresaDTO toDto(Empresa source)
	{
		EmpresaDTO target = new EmpresaDTO();
		
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
		
		return target;
	}	
}