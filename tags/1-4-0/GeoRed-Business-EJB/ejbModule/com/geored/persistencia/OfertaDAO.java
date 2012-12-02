package com.geored.persistencia;

import java.util.List;

import javax.ejb.Local;

import com.geored.dominio.Oferta;
import com.geored.dominio.Tematica;
import com.geored.dominio.Usuario;
import com.geored.dto.OfertaDTO;
import com.geored.persistencia.core.GenericDAO;

@Local
public interface OfertaDAO extends GenericDAO<Oferta, OfertaDTO>
{
	public Object buscarOfertasPorTematicas(List<Tematica> tematicas, Usuario u,  boolean toDTO);
}