package com.geored.persistencia;

import java.sql.Timestamp;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.geored.dominio.MensajeAmistad;
import com.geored.dto.MensajeAmistadDTO;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class MensajeAmistadDAOImpl extends GenericDAOBase<MensajeAmistad, MensajeAmistadDTO> implements MensajeAmistadDAO
{
	@Override
	public void toEntity(MensajeAmistadDTO source, MensajeAmistad target)
	{
		target.setMensaje(source.getMensaje());
		target.setFechaCreacion(source.getFechaCreacion() != null ? new Timestamp(source.getFechaCreacion().getTime()) : null);
	}

	@Override
	public void toDto(MensajeAmistad source, MensajeAmistadDTO target)
	{
		target.setId(source.getId());
		target.setFechaCreacion(source.getFechaCreacion());
		target.setMensaje(source.getMensaje());
		
		if(source.getAmistad() != null)
		{
			target.setIdAmistad(source.getAmistad().getId());
		}
		
		if(source.getRemitente() != null)
		{
			target.setIdRemitente(source.getRemitente().getId());
			target.setNombreRemitente(source.getRemitente().getNombre());
		}
		
	}
}