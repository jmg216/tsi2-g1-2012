package com.geored.persistencia;

import java.util.List;

import javax.ejb.Local;

import com.geored.dominio.Amistad;
import com.geored.dto.AmistadDTO;
import com.geored.exceptions.DaoException;
import com.geored.persistencia.core.GenericDAO;

@Local
public interface AmistadDAO extends GenericDAO<Amistad, AmistadDTO>
{
	public List obtenerAmistadesUsuario(Long idUsuario, boolean soloConectados, boolean toDTO) throws DaoException;
	
	public boolean sonAmigos(Long idUsuario, Long idAmigo) throws DaoException;
}