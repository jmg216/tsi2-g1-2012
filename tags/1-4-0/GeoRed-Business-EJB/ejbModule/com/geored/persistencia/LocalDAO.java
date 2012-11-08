package com.geored.persistencia;

import com.geored.dominio.Local;
import com.geored.dto.LocalDTO;
import com.geored.persistencia.core.GenericDAO;

@javax.ejb.Local
public interface LocalDAO extends GenericDAO<Local, LocalDTO>
{
}
