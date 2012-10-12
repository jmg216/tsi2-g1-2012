package com.geored.negocio;

import java.util.List;

import javax.ejb.Local;

import com.geored.dto.EmpresaDTO;

@Local
public interface EmpresaService
{
	public Long insertar(EmpresaDTO EmpresaDTO);
	
	public void actualizar(EmpresaDTO EmpresaDTO);
	
	public void eliminar(Long idAdministrador);
	
	public EmpresaDTO obtener(Long idAdministrador);
	
	public List<EmpresaDTO> obtenerListado();
}