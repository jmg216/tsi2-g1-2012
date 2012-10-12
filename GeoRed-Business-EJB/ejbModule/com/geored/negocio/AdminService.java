package com.geored.negocio;

import javax.ejb.Local;

import com.geored.dominio.Administrador;

@Local
public interface AdminService 
{
	public Long insertar(Administrador administrador);
}
