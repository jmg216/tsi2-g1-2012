package com.geored.negocio;

import java.util.List;

import javax.ejb.Local;

import com.geored.dto.OfertaDTO;
import com.geored.exceptions.NegocioException;

@Local
public interface OfertaService
{
	public Long insertar(OfertaDTO OfertaDTO)  throws NegocioException;
	
	public void actualizar(OfertaDTO OfertaDTO)  throws NegocioException;
	
	public void eliminar(Long idAdministrador)  throws NegocioException;
	
	public OfertaDTO obtener(Long idAdministrador)  throws NegocioException;
	
	public List<OfertaDTO> obtenerListado();
}