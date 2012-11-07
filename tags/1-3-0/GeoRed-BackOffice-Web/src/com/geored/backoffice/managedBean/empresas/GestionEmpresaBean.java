package com.geored.backoffice.managedBean.empresas;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.xml.rpc.ServiceException;

import com.geored.backoffice.managedBean.BaseBean;
import com.geored.backoffice.utiles.UtilesWeb;
import com.geored.negocio.AdministradorDTO;
import com.geored.negocio.DaoException;
import com.geored.negocio.EmpresaDTO;
import com.geored.negocio.NegocioException;


@ManagedBean(name="gestionEmpresaBean")
@RequestScoped
public class GestionEmpresaBean extends BaseBean implements Serializable
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String TO_LISTADO = "to_listado";
	
	private AdministradorDTO administradorDTO = new AdministradorDTO();
	
	private EmpresaDTO empresaDTO = new EmpresaDTO();
	
	private List<AdministradorDTO> listaAdministradores = new ArrayList<AdministradorDTO>();
	
	public GestionEmpresaBean()
	{	
		String idEmpresa = getParameter("idEmpresa");                
		
		if(UtilesWeb.isNullOrEmpty(idEmpresa))
		{
			empresaDTO = new EmpresaDTO();
		}
		else
		{
			try
			{
				empresaDTO = getEmpresaPort().obtener(Long.valueOf(idEmpresa));
			} 
			catch (NegocioException e)
			{
				addError(e.getMessage());
			} 
			catch (DaoException e)
			{
				addError(e.getMessage());
			} 
			catch (RemoteException e)
			{
				addError(MSJ_ERROR_COMUNICACION_WS);
			} 
			catch (ServiceException e)
			{
				addError(MSJ_ERROR_COMUNICACION_WS);
			}
		}
		
		cargarDatosIniciales();
	}
	
	private void cargarDatosIniciales()
	{
		try
		{
			listaAdministradores = Arrays.asList(getAdministradorPort().obtenerListado());
		}
		catch (DaoException e)
		{
			addError(e.getMessage());
		} 
		catch (RemoteException e)
		{
			addError(MSJ_ERROR_COMUNICACION_WS);
		} 
		catch (ServiceException e)
		{
			addError(MSJ_ERROR_COMUNICACION_WS);
		}
	}
	
	public String guardarEmpresa()
	{
		try
		{
			// Si estoy creando 
			if(empresaDTO.getId() == null)
			{
				getEmpresaPort().insertar(empresaDTO);
			}
			else // Si estoy modificando
			{
				getEmpresaPort().actualizar(empresaDTO);
			}
		}
		catch(NegocioException e)
		{
			addError(e.getMessage());
		} 
		catch (DaoException e)
		{
			addError(e.getMessage());
		} 
		catch (RemoteException e)
		{
			addError(MSJ_ERROR_COMUNICACION_WS);
		} 
		catch (ServiceException e)
		{
			addError(MSJ_ERROR_COMUNICACION_WS);
		}
		
		return SUCCESS;
	}
	
	public void guardarAdministrador()
	{
		try
		{
			if(getAdministradorDTO() != null)
			{
				if(UtilesWeb.isNullOrEmpty(getAdministradorDTO().getEmail()))
				{
					addError("Email es obligatorio");
				}
				
				getAdministradorDTO().setIdTipoAdministrador(UtilesWeb.ID_TIPO_ADMIN_EMPRESA);
				
				getAdministradorDTO().setPass(UtilesWeb.encriptarMD5(UtilesWeb.DEFAULT_PASS));
				
				getAdministradorPort().insertar(getAdministradorDTO());
			}
		} 
		catch (NegocioException e)
		{
			addError(e.getMessage());
		} 
		catch (DaoException e)
		{
			addError(e.getMessage());
		} 
		catch (RemoteException e)
		{
			addError(MSJ_ERROR_COMUNICACION_WS);
		} 
		catch (ServiceException e)
		{
			addError(MSJ_ERROR_COMUNICACION_WS);
		}
		
		cargarDatosIniciales();
	}

	public String toListado()
	{
		return TO_LISTADO;
	}

	public EmpresaDTO getEmpresaDTO()
	{
		return empresaDTO;
	}

	public void setEmpresaDTO(EmpresaDTO empresaDTO)
	{
		this.empresaDTO = empresaDTO;
	}

	public List<AdministradorDTO> getListaAdministradores()
	{
		return listaAdministradores;
	}

	public void setListaAdministradores(List<AdministradorDTO> listaAdministradores)
	{
		this.listaAdministradores = listaAdministradores;
	}

	public AdministradorDTO getAdministradorDTO()
	{
		return administradorDTO;
	}

	public void setAdministradorDTO(AdministradorDTO administradorDTO)
	{
		this.administradorDTO = administradorDTO;
	}
}
