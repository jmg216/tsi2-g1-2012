package com.geored.negocio;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.jws.WebMethod;
import javax.jws.WebService;

import com.geored.dominio.Administrador;
import com.geored.dominio.Empresa;
import com.geored.dominio.Local;
import com.geored.dto.EmpresaDTO;
import com.geored.dto.LocalDTO;
import com.geored.exceptions.DaoException;
import com.geored.exceptions.NegocioException;
import com.geored.persistencia.AdministradorDAO;
import com.geored.persistencia.EmpresaDAO;
import com.geored.persistencia.LocalDAO;
import com.geored.utiles.UtilesNegocio;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@WebService
public class EmpresaServiceImpl implements EmpresaService
{
	@EJB
	private EmpresaDAO empresaDAO;
	
	@EJB
	private LocalDAO localDAO;
	
	@EJB 
	private AdministradorDAO administradorDAO;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public Long insertar(EmpresaDTO empresaDTO)  throws NegocioException, DaoException
	{
		if(empresaDAO.obtenerPorNombre(empresaDTO.getNombre(), false) != null)
		{
			throw new NegocioException("Ya existe una empresa con este nombre");
		}

		empresaDTO.setFechaCreacion(new Date());
		
		Empresa empresaEntity = empresaDAO.toEntity(empresaDTO);
		
		Administrador adminEntity = (Administrador) administradorDAO.obtener(empresaDTO.getIdAdministrador(), false);
		
		if(adminEntity == null)
		{
			throw new NegocioException("Administrador no encontrado");
		}
		
		empresaEntity.setAdministrador(adminEntity);

		empresaDAO.insertar(empresaEntity);
		
		UtilesNegocio.enviarMailAdministrador(adminEntity, empresaEntity.getNombre());
		
		return empresaEntity.getId();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public void actualizar(EmpresaDTO empresaDTO)  throws NegocioException, DaoException
	{
		Empresa empresaEntity = (Empresa) empresaDAO.obtenerPorNombre(empresaDTO.getNombre(), false);
		
		if(empresaEntity != null && !empresaEntity.getId().equals(empresaDTO.getId()))
		{
			throw new NegocioException("Ya existe una empresa con ese nombre");
		}
		
		empresaEntity = (Empresa) empresaDAO.obtener(empresaDTO.getId(), false);
		
		if(empresaEntity == null)
		{
			throw new NegocioException("Empresa no encontrada");
		}
		
		empresaDAO.toEntity(empresaDTO, empresaEntity);
		
		empresaDAO.actualizar(empresaEntity);					
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public void eliminar(Long idEmpresa)  throws NegocioException, DaoException
	{
		Empresa empresaEntity = (Empresa) empresaDAO.obtener(idEmpresa, false);
		
		if(empresaEntity == null)
		{
			throw new NegocioException("Empresa no encontrada");
		}
		
		if(empresaEntity.getListaLocales() != null && !empresaEntity.getListaLocales().isEmpty())
		{
			throw new NegocioException("La empresa no se puede eliminar, tiene locales asociados");
		}
		
		empresaDAO.eliminar(empresaEntity);
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public EmpresaDTO obtener(Long idEmpresa)  throws NegocioException, DaoException
	{
		EmpresaDTO empresaDTO = (EmpresaDTO) empresaDAO.obtener(idEmpresa, true);
		
		if(empresaDTO == null)
		{
			throw new NegocioException("Empresa no encontrada");
		}
	
		return empresaDTO;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public List<EmpresaDTO> obtenerListado() throws DaoException
	{
		return empresaDAO.obtenerListado(true);		
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public LocalDTO obtenerLocal(Long idLocal) throws NegocioException, DaoException
	{
		LocalDTO localDTO = (LocalDTO) localDAO.obtener(idLocal, true);
		
		if(localDTO == null)
		{
			throw new NegocioException("Local no encontrado");
		}
		
		return localDTO;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public Long insertarLocal(LocalDTO localDTO) throws NegocioException, DaoException
	{
		if(localDAO.obtenerLocalPorNombreYEmpresa(localDTO.getNombre(), localDTO.getIdEmpresa(), false) != null)
		{
			throw new NegocioException("Ya existe un local con ese nombre para la empresa seleccionada");
		}
		
		Local localEntity = localDAO.toEntity(localDTO);

		if(localDTO.getIdEmpresa() != null)
		{
			Empresa empresaEntity = (Empresa) empresaDAO.obtener(localDTO.getIdEmpresa(), false);
			
			if(empresaEntity == null)
			{
				throw new NegocioException("Empresa no encontrada");
			}
			
			localEntity.setEmpresa(empresaEntity);
		}
		
		localDAO.insertar(localEntity);
		
		return localEntity.getId();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public void actualizarLocal(LocalDTO localDTO) throws NegocioException, DaoException
	{
		Local localEntity = (Local) localDAO.obtenerLocalPorNombreYEmpresa(localDTO.getNombre(), localDTO.getIdEmpresa(), false); 
		
		if(localEntity != null && !localEntity.getId().equals(localDTO.getId()))
		{
			throw new NegocioException("Ya existe un local con ese nombre para la empresa seleccionada");
		}
		
		localEntity = (Local) localDAO.obtener(localDTO.getId(), false);

		if(localEntity == null)
		{
			throw new NegocioException("Local no encontrado");
		}
		
		localDAO.toEntity(localDTO, localEntity);
		
		localDAO.actualizar(localEntity);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public void eliminarLocal(Long idLocal) throws NegocioException, DaoException
	{
		Local localEntity = (Local) localDAO.obtener(idLocal, false);
		
		if(localEntity == null)
		{
			throw new NegocioException("Local no encontrado");
		}
		
		if(localEntity.getListaOfertas() != null && !localEntity.getListaOfertas().isEmpty())
		{
			throw new NegocioException("El local no se puede eliminar, tiene ofertas asociadas");
		}
		
		localDAO.eliminar(localEntity);
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public List<LocalDTO> obtenerListadoLocales() throws DaoException
	{
		return localDAO.obtenerListado(true);
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public List<EmpresaDTO> obtenerListadoPorAdministrador(Long idAdministrador) throws DaoException
	{
		return empresaDAO.obtenerListadoPorAdministrador(idAdministrador, true);
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public List<LocalDTO> obtenerListadoLocalesPorEmpresa(Long idEmpresa) throws DaoException
	{
		return localDAO.obtenerListadoPorEmpresa(idEmpresa, true);
	}
}