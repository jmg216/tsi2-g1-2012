package com.geored.negocio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.jws.WebMethod;
import javax.jws.WebService;

import com.geored.dominio.Empresa;
import com.geored.dto.EmpresaDTO;
import com.geored.exceptions.DaoException;
import com.geored.exceptions.NegocioException;
import com.geored.persistencia.EmpresaDAO;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@WebService
public class EmpresaServiceImpl implements EmpresaService
{
	@EJB
	private EmpresaDAO empresaDAO;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public Long insertar(EmpresaDTO empresaDTO)  throws NegocioException, DaoException
	{
		Empresa empresaEntity = empresaDAO.toEntity(empresaDTO);

		empresaDAO.insertar(empresaEntity);
		
		return empresaEntity.getId();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public void actualizar(EmpresaDTO empresaDTO)  throws NegocioException, DaoException
	{
		Empresa empresaEntity = (Empresa) empresaDAO.obtener(empresaDTO.getId(), false);
		
		if(empresaEntity == null)
		{
			throw new NegocioException("Empresa no encontrada");
		}
		
		empresaDAO.toEntity(empresaDTO, empresaEntity);
		
		empresaDAO.actualizar(empresaEntity);					
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public void eliminar(Long idEmpresa)  throws NegocioException, DaoException
	{
		Empresa empresaEntity = (Empresa) empresaDAO.obtener(idEmpresa, false);
		
		if(empresaEntity == null)
		{
			throw new NegocioException("Empresa no encontrada");
		}
		
		empresaDAO.eliminar(empresaEntity);
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public EmpresaDTO obtener(Long idEmpresa)  throws NegocioException, DaoException
	{
		EmpresaDTO empresaDTO = (EmpresaDTO) empresaDAO.obtener(idEmpresa, true);
		
		if(empresaDTO == null)
		{
			throw new NegocioException("Empresa no encontrada");
		}
	
		return empresaDTO;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public List<EmpresaDTO> obtenerListado() throws DaoException
	{

		return empresaDAO.obtenerListado(true);		
	}
}