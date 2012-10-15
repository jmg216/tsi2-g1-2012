package com.geored.persistencia;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.geored.dominio.Empresa;
import com.geored.dto.EmpresaDTO;
import com.geored.persistencia.core.GenericDAOBase;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class EmpresaDAOImpl extends GenericDAOBase<Empresa> implements EmpresaDAO
{

	@Override
	public void dtoToEntity(EmpresaDTO source, Empresa target)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void entityToDto(Empresa source, EmpresaDTO target)
	{
		// TODO Auto-generated method stub
		
	}
	
}