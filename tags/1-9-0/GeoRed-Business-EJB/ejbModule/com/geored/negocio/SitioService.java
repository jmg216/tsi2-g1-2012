package com.geored.negocio;

import java.util.List;

import javax.ejb.Local;

import com.geored.dto.SitioDTO;
import com.geored.exceptions.DaoException;
import com.geored.exceptions.NegocioException;

@Local
public interface SitioService
{
	public Long insertar(SitioDTO sitioDTO)  throws NegocioException, DaoException;
	
	public void actualizar(SitioDTO sitioDTO)  throws NegocioException, DaoException;
	
	public void eliminar(Long idSitio)  throws NegocioException, DaoException;
	
	public SitioDTO obtener(Long idSitio)  throws NegocioException, DaoException;
	
	public List<SitioDTO> obtenerListado() throws DaoException;
}