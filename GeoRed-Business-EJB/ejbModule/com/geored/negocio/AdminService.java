package com.geored.negocio;

import javax.ejb.Local;

import com.geored.dto.AdministradorDTO;

@Local
public interface AdminService 
{
	public Long insertar(AdministradorDTO administradorDTO);
}
