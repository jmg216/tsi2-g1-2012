package com.geored.persistencia;

import java.util.List;

import javax.ejb.Local;

import com.geored.dominio.Empresa;
import com.geored.dto.EmpresaDTO;

@Local
public interface EmpresaDAO
{
	public Empresa insertar(Empresa entity);
	
	public void actualizar(Empresa entity);
	
	public void eliminar(Empresa entity);
	
	public Empresa obtener(Long id);
	
	public List<Empresa> obtenerListado();
	
	/**
	 * OPERACIONES DE TRANSFORMACION Entity <-> DTO
	 */
	public void dtoToEntity(EmpresaDTO source, Empresa target);
	
	public void entityToDto(Empresa source, EmpresaDTO target);
}