package com.geored.negocio;

import java.util.List;

import javax.ejb.Local;

import com.geored.dto.OfertaDTO;

@Local
public interface OfertaService
{
	public Long insertar(OfertaDTO OfertaDTO);
	
	public void actualizar(OfertaDTO OfertaDTO);
	
	public void eliminar(Long idAdministrador);
	
	public OfertaDTO obtener(Long idAdministrador);
	
	public List<OfertaDTO> obtenerListado();
}