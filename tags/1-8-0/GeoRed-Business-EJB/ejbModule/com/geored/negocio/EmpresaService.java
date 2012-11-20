package com.geored.negocio;

import java.util.List;

import javax.ejb.Local;

import com.geored.dto.EmpresaDTO;
import com.geored.dto.LocalDTO;
import com.geored.exceptions.DaoException;
import com.geored.exceptions.NegocioException;

@Local
public interface EmpresaService
{
	public Long insertar(EmpresaDTO empresaDTO)  throws NegocioException, DaoException;
	
	public void actualizar(EmpresaDTO empresaDTO)  throws NegocioException, DaoException;
	
	public void eliminar(Long idEmpresa)  throws NegocioException, DaoException;
	
	public EmpresaDTO obtener(Long idEmpresa)  throws NegocioException, DaoException;
	
	public List<EmpresaDTO> obtenerListado() throws DaoException;
	
	public List<EmpresaDTO> obtenerListadoPorAdministrador(Long idAdministrador) throws DaoException;
	
	//Fuciones con locales
	public Long insertarLocal(LocalDTO localDTO) throws NegocioException, DaoException;
	
	public void actualizarLocal(LocalDTO localDTO) throws NegocioException, DaoException;
	
	public void eliminarLocal(Long idLocal) throws NegocioException, DaoException;
	
	public LocalDTO obtenerLocal(Long idLocal) throws NegocioException, DaoException;
	
	public List<LocalDTO> obtenerListadoLocales() throws DaoException;
	
	public List<LocalDTO> obtenerListadoLocalesPorEmpresa(Long idEmpresa) throws DaoException;
}