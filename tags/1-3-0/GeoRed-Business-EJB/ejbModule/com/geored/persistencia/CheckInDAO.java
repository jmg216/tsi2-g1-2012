package com.geored.persistencia;

import javax.ejb.Local;

import com.geored.dominio.CheckIn;
import com.geored.dto.CheckInDTO;
import com.geored.persistencia.core.GenericDAO;

@Local
public interface CheckInDAO extends GenericDAO<CheckIn, CheckInDTO>
{
}