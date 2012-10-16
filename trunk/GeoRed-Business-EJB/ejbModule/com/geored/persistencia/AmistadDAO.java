package com.geored.persistencia;

import javax.ejb.Local;

import com.geored.dominio.Amistad;
import com.geored.dto.AmistadDTO;
import com.geored.persistencia.core.GenericDAO;

@Local
public interface AmistadDAO extends GenericDAO<Amistad, AmistadDTO>
{
}