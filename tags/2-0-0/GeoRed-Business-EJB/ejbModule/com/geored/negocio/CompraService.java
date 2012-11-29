package com.geored.negocio;

import java.util.List;

import javax.ejb.Local;

import com.geored.dto.CompraDTO;
import com.geored.exceptions.DaoException;
import com.geored.exceptions.NegocioException;

@Local
public interface CompraService
{
	// Metodo que atiende las solicitudes con contenido JSON, parsea e invoca el metodo correspondiente
	public String androidInvocation(String methodName, String methodParams) throws NegocioException, DaoException;
		
	public Long insertar(CompraDTO compraDTO) throws NegocioException, DaoException;
	
	public void actualizar(CompraDTO compraDTO) throws NegocioException, DaoException;
	
	public void eliminar(Long idCompra) throws NegocioException, DaoException;
	
	public CompraDTO obtener(Long idCompra) throws NegocioException, DaoException;
	
	public List<CompraDTO> obtenerListado() throws DaoException;
	
	public List<CompraDTO> obtenerListadoPorOferta(Long idOferta) throws DaoException;
}