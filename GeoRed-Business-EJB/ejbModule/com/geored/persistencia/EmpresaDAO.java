package com.geored.persistencia;

import javax.ejb.Local;

import com.geored.dominio.Empresa;
import com.geored.dto.EmpresaDTO;
import com.geored.persistencia.core.GenericDAO;

@Local
public interface EmpresaDAO extends GenericDAO<Empresa, EmpresaDTO>
{
}