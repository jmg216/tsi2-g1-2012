package com.geored.persistencia;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.geored.dominio.Amistad;
import com.geored.persistencia.core.BaseDAO;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AmistadDAOImpl extends BaseDAO<Amistad> implements AmistadDAO
{	
}