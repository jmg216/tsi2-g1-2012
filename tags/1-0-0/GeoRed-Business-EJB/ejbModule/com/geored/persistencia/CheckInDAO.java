package com.geored.persistencia;

import java.util.List;

import javax.ejb.Local;

import com.geored.dominio.CheckIn;
import com.geored.dto.CheckInDTO;

@Local
public interface CheckInDAO
{
	public CheckIn insertar(CheckIn entity);
	
	public void actualizar(CheckIn entity);
	
	public void eliminar(CheckIn entity);
	
	public CheckIn obtener(Long id);
	
	public List<CheckIn> obtenerListado();
	
	/**
	 * OPERACIONES DE TRANSFORMACION Entity <-> DTO
	 */
	public void dtoToEntity(CheckInDTO source, CheckIn target);
	
	public void entityToDto(CheckIn source, CheckInDTO target);
}