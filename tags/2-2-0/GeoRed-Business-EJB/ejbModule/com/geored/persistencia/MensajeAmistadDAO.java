package com.geored.persistencia;

import javax.ejb.Local;

import com.geored.dominio.MensajeAmistad;
import com.geored.dto.MensajeAmistadDTO;
import com.geored.persistencia.core.GenericDAO;

@Local
public interface MensajeAmistadDAO extends GenericDAO<MensajeAmistad, MensajeAmistadDTO>
{	
}