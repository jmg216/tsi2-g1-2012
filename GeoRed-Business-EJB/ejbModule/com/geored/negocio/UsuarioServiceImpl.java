package com.geored.negocio;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.jws.WebService;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@WebService
public class UsuarioServiceImpl implements UsuarioService
{
	
}