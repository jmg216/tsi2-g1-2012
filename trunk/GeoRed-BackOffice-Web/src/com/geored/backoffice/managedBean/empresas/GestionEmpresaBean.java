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

	private static final int VALIDAR_CREAR = 1;
	
	private static final int VALIDAR_MODIFICAR = 2;
	
	private static final String EMPRESA_DTO_KEY = "EMPRESA_DTO_KEY";
	
	private static final String TO_LISTADO_EMPRESAS = "to_listado_empresas";
	
	private EmpresaDTO empresaDTO = new EmpresaDTO();
	
	private List<AdministradorDTO> listaAdministradores = new ArrayList<AdministradorDTO>();
	
	public GestionEmpresaBean()
	{	
		empresaDTO = (EmpresaDTO) getFlashAttribute(EMPRESA_DTO_KEY);
		
		if(empresaDTO == null)
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
			
			setFlashAttribute(EMPRESA_DTO_KEY, empresaDTO);
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
	
	public String guardarEmpresa()
	{		
		try
		{
			// Si estoy creando 
			if(UtilesWeb.isNullOrZero(empresaDTO.getId()))
			{
				if(validar(VALIDAR_CREAR))
				{
					getEmpresaPort().insertar(empresaDTO);
					
					addBeanMessage("Empresa guardada correctamente");
				}				
			}
			else // Si estoy modificando
			{
				if(validar(VALIDAR_MODIFICAR))
				{
					getEmpresaPort().actualizar(empresaDTO);
					
					addBeanMessage("Empresa guardada correctamente");
				}				
			}				
		}
		catch(Exception e)
		{
			handleWSException(e);
		} 
		
		return SUCCESS;
	}

	private boolean validar(int opValidar)
	{
		boolean isValid = true;
		
		if(opValidar == VALIDAR_CREAR)
		{
			if(UtilesWeb.isNullOrEmpty(getEmpresaDTO().getNombre()))
			{
				addBeanError("El campo 'Nombre' es obligatorio");
				isValid = false;
			}
			if(UtilesWeb.isNullOrZero(getEmpresaDTO().getIdAdministrador()))
			{
				addBeanError("El campo 'Administrador' es obligatorio");
				isValid = false;
			}
		}
		else if(opValidar == VALIDAR_MODIFICAR)
		{
			
		}
		
		return isValid;
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
