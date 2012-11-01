package com.geored.persistencia;

import java.util.List;

import javax.ejb.Local;

import com.geored.dominio.ContenidoSitio;
import com.geored.dto.ContenidoSitioDTO;
import com.geored.persistencia.core.EntityTransformer;
import com.geored.persistencia.core.GenericDAO;

@Local
public interface ContenidoSitioDAO extends GenericDAO<ContenidoSitio, ContenidoSitioDTO>
{
}