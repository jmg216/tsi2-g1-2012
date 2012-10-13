package com.geored.persistencia;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.geored.dominio.Evento;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class EventoDAOImpl extends GenericDAOBase<Evento> implements EventoDAO
{
	
}