package com.geored.persistencia;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.geored.dominio.Administrador;
import com.geored.persistencia.core.BaseDAO;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AdministradorDAOImpl extends BaseDAO<Administrador> implements AdministradorDAO
{
}