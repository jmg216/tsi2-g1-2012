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
	
	private EmpresaDTO empresaDTO = new EmpresaDTO();
	
	private List<AdministradorDTO> listaAdministradores = new ArrayList<AdministradorDTO>();
	
	@PostConstruct
	public void init()
	{	
		String idEmpresa = getParameter("idEmpresa");                
		
		if(idEmpresa == null)
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
				addMessage(e.getMessage());
			} 
			catch (DaoException e)
			{
				addMessage(e.getMessage());
			} 
			catch (RemoteException e)
			{
				addMessage(MSJ_ERROR_COMUNICACION_WS);
			} 
			catch (ServiceException e)
			{
				addMessage(MSJ_ERROR_COMUNICACION_WS);
			}
		}
	}
	
	@PostConstruct
	private void cargarDatosIniciales()
	{
		try
		{
			listaAdministradores = Arrays.asList(getAdministradorPort().obtenerListado());
		}
		catch (DaoException e)
		{
			addMessage(e.getMessage());
		} 
		catch (RemoteException e)
		{
			addMessage(MSJ_ERROR_COMUNICACION_WS);
		} 
		catch (ServiceException e)
		{
			addMessage(MSJ_ERROR_COMUNICACION_WS);
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
			addMessage(e.getMessage());
		} 
		catch (DaoException e)
		{
			addMessage(e.getMessage());
		} 
		catch (RemoteException e)
		{
			addMessage(MSJ_ERROR_COMUNICACION_WS);
		} 
		catch (ServiceException e)
		{
			addMessage(MSJ_ERROR_COMUNICACION_WS);
		}
		
		return SUCCESS;
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
}
