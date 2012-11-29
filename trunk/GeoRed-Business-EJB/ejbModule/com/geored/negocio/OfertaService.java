package com.geored.negocio;

import java.util.List;

import javax.ejb.Local;

import com.geored.dto.OfertaDTO;
import com.geored.exceptions.DaoException;
import com.geored.exceptions.NegocioException;

@Local
public interface OfertaService
{
	// Metodo que atiende las solicitudes con contenido JSON, parsea e invoca el metodo correspondiente
	public String androidInvocation(String methodName, String methodParams) throws NegocioException, DaoException;
		
	public Long insertar(OfertaDTO ofertaDTO)  throws NegocioException, DaoException;
	
	public void actualizar(OfertaDTO ofertaDTO)  throws NegocioException, DaoException;
	
	public void eliminar(Long idOferta)  throws NegocioException, DaoException;
	
	public OfertaDTO obtener(Long idOferta)  throws NegocioException, DaoException;
	
	public List<OfertaDTO> obtenerListado() throws DaoException;
	
	public List<OfertaDTO> obtenerListadoPorEmpresa(Long idEmpresa) throws DaoException;
}