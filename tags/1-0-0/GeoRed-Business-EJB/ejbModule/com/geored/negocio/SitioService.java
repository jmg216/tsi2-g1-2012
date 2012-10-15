package com.geored.negocio;

import java.util.List;

import javax.ejb.Local;

import com.geored.dto.SitioDTO;
import com.geored.exceptions.NegocioException;

@Local
public interface SitioService
{
	public Long insertar(SitioDTO SitioDTO)  throws NegocioException;
	
	public void actualizar(SitioDTO SitioDTO)  throws NegocioException;
	
	public void eliminar(Long idAdministrador)  throws NegocioException;
	
	public SitioDTO obtener(Long idAdministrador)  throws NegocioException;
	
	public List<SitioDTO> obtenerListado();
}