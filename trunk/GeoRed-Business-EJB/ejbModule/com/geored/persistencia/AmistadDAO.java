package com.geored.persistencia;

import java.util.Collection;
import javax.ejb.Local;
import com.geored.dominio.Amistad;

@Local
public interface AmistadDAO
{
	public Amistad insertar(Amistad entity);
	
	public void actualizar(Amistad entity);
	
	public void eliminar(Amistad entity);
	
	public Amistad obtener(Long id);
	
	public Collection<Amistad> obtenerListado();
}