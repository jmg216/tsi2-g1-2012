package com.geored.persistencia;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.geored.dominio.Tematica;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TematicaDAOImpl extends GenericDAOBase<Tematica> implements TematicaDAO
{
	
}