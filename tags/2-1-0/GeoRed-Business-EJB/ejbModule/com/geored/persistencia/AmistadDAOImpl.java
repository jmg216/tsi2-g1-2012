package com.geored.persistencia;

import javax.ejb.EJB;
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
	@EJB
	private MensajeAmistadDAO mensajeAmistadDAO;
	
	@Override
	public void toEntity(AmistadDTO source, Amistad target)
	{		
	}

	@Override
	public void toDto(Amistad source, AmistadDTO target)
	{
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
		
		if(source.getListaMensajes() != null)
		{
			target.setListaMensajesDTO(mensajeAmistadDAO.toDtoList(source.getListaMensajes()));
		}
	}	
}