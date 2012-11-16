package com.geored.backoffice.managedBean.empresas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.geored.backoffice.managedBean.BaseBean;
import com.geored.backoffice.utiles.UtilesWeb;
import com.geored.negocio.AdministradorDTO;
import com.geored.negocio.EmpresaDTO;


@ManagedBean(name="gestionEmpresaBean")
@RequestScoped
public class GestionEmpresaBean extends BaseBean implements Serializable
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = -904426109389600335L;

	private static final String TO_LISTADO_EMPRESAS = "to_listado_empresas";
	
	private EmpresaDTO empresaDTO = new EmpresaDTO();
	
	private List<AdministradorDTO> listaAdministradores = new ArrayList<AdministradorDTO>();
	
	public GestionEmpresaBean()
	{	
		String idEmpresa = getRequestParameter("idEmpresa");                
		
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
			catch (Exception e)
			{
				addBeanError(e.getMessage());
			} 
		}
		
		cargarDatosIniciales();
	}
	
	private void cargarDatosIniciales()
	{
		try
		{
			AdministradorDTO[] arrayAdministradores = getAdminPort().obtenerListadoPorTipo(UtilesWeb.ID_TIPO_ADMIN_EMPRESA);
			
			if(arrayAdministradores != null)
			{
				listaAdministradores = Arrays.asList(arrayAdministradores);	
			}
			else
			{
				listaAdministradores = new ArrayList<AdministradorDTO>();
			}
		}
		catch (Exception e)
		{
			handleWSException(e);
		} 
	}
	
	public void guardarEmpresa()
	{
		addBeanMessage("Empresa guardada correctamente");
		
//		try
//		{
//			// Si estoy creando 
//			if(empresaDTO.getId() == null)
//			{
//				getEmpresaPort().insertar(empresaDTO);
//			}
//			else // Si estoy modificando
//			{
//				getEmpresaPort().actualizar(empresaDTO);
//			}
//		}
//		catch(NegocioException e)
//		{
//			addBeanError(e.getMessage());
//		} 
//		catch (DaoException e)
//		{
//			addBeanError(e.getMessage());
//		} 
//		catch (RemoteException e)
//		{
//			addBeanError(MSJ_ERROR_COMUNICACION_WS);
//		} 
//		catch (ServiceException e)
//		{
//			addBeanError(MSJ_ERROR_COMUNICACION_WS);
//		}
	}

	public String toListadoEmpresas()
	{
		return TO_LISTADO_EMPRESAS;
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
