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
import javax.jws.WebParam;
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
import com.geored.utiles.JsonParamsMap;
import com.geored.utiles.UtilesNegocio;
import com.google.gson.Gson;

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
	
	@WebMethod(operationName="androidInvocation")
	public String androidInvocation(@WebParam(name="methodName") String methodName, @WebParam(name="methodParams") String methodParams) throws NegocioException, DaoException
	{		
		JsonParamsMap params = new JsonParamsMap(methodParams);
		
		if(methodName.equals("insertar"))
		{		
			EmpresaDTO empresaDTO = (EmpresaDTO) params.getParam("empresaDTO", EmpresaDTO.class);
			
			return new Gson().toJson(insertar(empresaDTO));
		}
		else if(methodName.equals("actualizar"))
		{		
			EmpresaDTO empresaDTO = (EmpresaDTO) params.getParam("empresaDTO", EmpresaDTO.class);
			
			actualizar(empresaDTO);
		} 
		else if(methodName.equals("eliminar"))
		{		
			Long idEmpresa = (Long) params.getParam("idEmpresa", Long.class);
			
			eliminar(idEmpresa);
		}
		else if(methodName.equals("obtener"))
		{		
			Long idEmpresa = (Long) params.getParam("idEmpresa", Long.class);
			
			return new Gson().toJson(obtener(idEmpresa));
		}
		else if(methodName.equals("obtenerListado"))
		{		
			return new Gson().toJson(obtenerListado());
		}
		else if(methodName.equals("obtenerListadoPorAdministrador"))
		{		
			Long idAdministrador = (Long) params.getParam("idAdministrador", Long.class);
			
			return new Gson().toJson(obtenerListadoPorAdministrador(idAdministrador));
		}
		else if(methodName.equals("insertarLocal"))
		{		
			LocalDTO localDTO = (LocalDTO) params.getParam("localDTO", LocalDTO.class);
			
			return new Gson().toJson(insertarLocal(localDTO));
		}
		else if(methodName.equals("actualizarLocal"))
		{		
			LocalDTO localDTO = (LocalDTO) params.getParam("localDTO", LocalDTO.class);
			
			actualizarLocal(localDTO);
		} 
		else if(methodName.equals("eliminarLocal"))
		{		
			Long idLocal = (Long) params.getParam("idLocal", Long.class);
			
			eliminarLocal(idLocal);
		}
		else if(methodName.equals("obtenerLocal"))
		{		
			Long idLocal = (Long) params.getParam("idLocal", Long.class);
			
			return new Gson().toJson(obtenerLocal(idLocal));
		}
		else if(methodName.equals("obtenerListadoLocales"))
		{		
			return new Gson().toJson(obtenerListadoLocales());
		}
		else if(methodName.equals("obtenerListadoLocalesPorEmpresa"))
		{		
			Long idEmpresa= (Long) params.getParam("idEmpresa", Long.class);
			
			return new Gson().toJson(obtenerListadoLocalesPorEmpresa(idEmpresa));
		}
		
		
		return "";
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@WebMethod
	public Long insertar(@WebParam(name="empresaDTO") EmpresaDTO empresaDTO)  throws NegocioException, DaoException
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
	public void actualizar(@WebParam(name="empresaDTO") EmpresaDTO empresaDTO)  throws NegocioException, DaoException
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
	public void eliminar(@WebParam(name="idEmpres") Long idEmpresa)  throws NegocioException, DaoException
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
	public EmpresaDTO obtener(@WebParam(name="idEmpresa") Long idEmpresa)  throws NegocioException, DaoException
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
	public LocalDTO obtenerLocal(@WebParam(name="idLocal") Long idLocal) throws NegocioException, DaoException
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
	public Long insertarLocal(@WebParam(name="localDTO") LocalDTO localDTO) throws NegocioException, DaoException
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
	public void actualizarLocal(@WebParam(name="localDTO") LocalDTO localDTO) throws NegocioException, DaoException
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
	public void eliminarLocal(@WebParam(name="idLocal") Long idLocal) throws NegocioException, DaoException
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
	public List<EmpresaDTO> obtenerListadoPorAdministrador(@WebParam(name="idAdministrador") Long idAdministrador) throws DaoException
	{
		return empresaDAO.obtenerListadoPorAdministrador(idAdministrador, true);
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	@WebMethod
	public List<LocalDTO> obtenerListadoLocalesPorEmpresa(@WebParam(name="idEmpres") Long idEmpresa) throws DaoException
	{
		return localDAO.obtenerListadoPorEmpresa(idEmpresa, true);
	}
}