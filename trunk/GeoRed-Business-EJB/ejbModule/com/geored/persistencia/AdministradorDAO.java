package com.geored.persistencia;

import javax.ejb.Local;

import com.geored.dominio.Administrador;
import com.geored.dto.AdministradorDTO;
import com.geored.persistencia.core.GenericDAO;

@Local
public interface AdministradorDAO extends GenericDAO<Administrador, AdministradorDTO>
{
}