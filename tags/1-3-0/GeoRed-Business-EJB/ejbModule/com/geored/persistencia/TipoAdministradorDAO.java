package com.geored.persistencia;

import javax.ejb.Local;

import com.geored.dominio.TipoAdministrador;
import com.geored.dto.TipoAdministradorDTO;
import com.geored.persistencia.core.GenericDAO;

@Local
public interface TipoAdministradorDAO extends GenericDAO<TipoAdministrador, TipoAdministradorDTO>
{
}