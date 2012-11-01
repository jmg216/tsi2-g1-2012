package com.geored.negocio;

import java.util.List;

import javax.ejb.Local;

import com.geored.dto.EmpresaDTO;
import com.geored.exceptions.DaoException;
import com.geored.exceptions.NegocioException;

@Local
public interface EmpresaService
{
	public Long insertar(EmpresaDTO empresaDTO)  throws NegocioException, DaoException;
	
	public void actualizar(EmpresaDTO empresaDTO)  throws NegocioException, DaoException;
	
	public void eliminar(Long idEmpresa)  throws NegocioException, DaoException;
	
	public EmpresaDTO obtener(Long idEmpresa)  throws NegocioException, DaoException;
	
	public List<EmpresaDTO> obtenerListado() throws DaoException;
}