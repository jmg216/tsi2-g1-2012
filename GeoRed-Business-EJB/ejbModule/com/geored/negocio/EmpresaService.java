package com.geored.negocio;

import java.util.List;

import javax.ejb.Local;

import com.geored.dto.EmpresaDTO;
import com.geored.exceptions.NegocioException;

@Local
public interface EmpresaService
{
	public Long insertar(EmpresaDTO EmpresaDTO)  throws NegocioException;
	
	public void actualizar(EmpresaDTO EmpresaDTO)  throws NegocioException;
	
	public void eliminar(Long idAdministrador)  throws NegocioException;
	
	public EmpresaDTO obtener(Long idAdministrador)  throws NegocioException;
	
	public List<EmpresaDTO> obtenerListado();
}