package com.geored.negocio;

import java.util.List;

import javax.ejb.Local;

import com.geored.dto.SitioDTO;

@Local
public interface SitioService
{
	public Long insertar(SitioDTO SitioDTO);
	
	public void actualizar(SitioDTO SitioDTO);
	
	public void eliminar(Long idAdministrador);
	
	public SitioDTO obtener(Long idAdministrador);
	
	public List<SitioDTO> obtenerListado();
}