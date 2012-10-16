package com.geored.negocio;

import java.util.List;

import javax.ejb.Local;

import com.geored.dto.EmpresaDTO;
import com.geored.exceptions.NegocioException;

@Local
public interface EmpresaService
{
	public Long insertar(EmpresaDTO empresaDTO)  throws NegocioException;
	
	public void actualizar(EmpresaDTO empresaDTO)  throws NegocioException;
	
	public void eliminar(Long idEmpresa)  throws NegocioException;
	
	public EmpresaDTO obtener(Long idEmpresa)  throws NegocioException;
	
	public List<EmpresaDTO> obtenerListado();
}