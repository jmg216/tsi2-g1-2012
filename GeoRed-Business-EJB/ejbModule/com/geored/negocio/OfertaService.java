package com.geored.negocio;

import java.util.List;

import javax.ejb.Local;

import com.geored.dto.OfertaDTO;
import com.geored.exceptions.NegocioException;

@Local
public interface OfertaService
{
	public Long insertar(OfertaDTO ofertaDTO)  throws NegocioException;
	
	public void actualizar(OfertaDTO ofertaDTO)  throws NegocioException;
	
	public void eliminar(Long idOferta)  throws NegocioException;
	
	public OfertaDTO obtener(Long idOferta)  throws NegocioException;
	
	public List<OfertaDTO> obtenerListado();
}