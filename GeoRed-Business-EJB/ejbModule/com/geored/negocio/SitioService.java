package com.geored.negocio;

import java.util.List;

import javax.ejb.Local;

import com.geored.dto.SitioDTO;
import com.geored.exceptions.NegocioException;

@Local
public interface SitioService
{
	public Long insertar(SitioDTO sitioDTO)  throws NegocioException;
	
	public void actualizar(SitioDTO sitioDTO)  throws NegocioException;
	
	public void eliminar(Long idSitio)  throws NegocioException;
	
	public SitioDTO obtener(Long idSitio)  throws NegocioException;
	
	public List<SitioDTO> obtenerListado();
}