package com.geored.backoffice.managedBean.empresas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.geored.backoffice.managedBean.BaseBean;
import com.geored.backoffice.utiles.UtilesWeb;
import com.geored.negocio.EmpresaDTO;

@ManagedBean(name="listadoEmpresasBean")
@RequestScoped
public class ListadoEmpresasBean extends BaseBean implements Serializable
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 794033666609815070L;

	private static final String TO_GESTION_EMPRESA = "to_gestion_empresa";
	
	private Long idEmpresa;
	
	private List<EmpresaDTO> listaEmpresas = new ArrayList<EmpresaDTO>();
	
	public ListadoEmpresasBean()
	{
		try
		{	
			// Si es admin empresas solo traigo las del usuario autenticado
			
			EmpresaDTO[] arrayEmpresas = {};
			
			if(UtilesWeb.esAdministradorEmpresa())
			{
				arrayEmpresas = getEmpresaPort().obtenerListadoPorAdministrador(UtilesWeb.obtenerEmpresaAdministrada().getId());
			}
			else
			{
				arrayEmpresas = getEmpresaPort().obtenerListado();
			}
			
			if(arrayEmpresas != null)
			{
				listaEmpresas = Arrays.asList(arrayEmpresas);
			}
			else
			{
				listaEmpresas = new ArrayList<EmpresaDTO>();
			}
			
		} 
		catch (Exception e)
		{
			handleWSException(e);
		} 
	}
	
	public String eliminarEmpresa()
	{
		try
		{
			getEmpresaPort().eliminar(idEmpresa);
		}
		catch(Exception e)
		{
			handleWSException(e);
		}
		
		return SUCCESS;
	}
	
	public String toGestionEmpresa()
	{
		return TO_GESTION_EMPRESA;
	}
	
	public List<EmpresaDTO> getListaEmpresas()
	{
		return listaEmpresas;
	}

	public void setListaEmpresas(List<EmpresaDTO> listaEmpresas)
	{
		this.listaEmpresas = listaEmpresas;
	}

	public Long getIdEmpresa()
	{
		return idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa)
	{
		this.idEmpresa = idEmpresa;
	}
}
