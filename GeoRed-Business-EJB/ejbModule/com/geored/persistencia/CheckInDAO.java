package com.geored.persistencia;

import java.util.Collection;
import com.geored.dominio.CheckIn;
import javax.ejb.Local;

@Local
public interface CheckInDAO
{
	public CheckIn insertar(CheckIn entity);
	
	public void actualizar(CheckIn entity);
	
	public void eliminar(CheckIn entity);
	
	public CheckIn obtener(Long id);
	
	public Collection<CheckIn> obtenerListado();
}