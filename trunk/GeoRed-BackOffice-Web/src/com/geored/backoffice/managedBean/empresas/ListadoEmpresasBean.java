package com.geored.backoffice.managedBean.empresas;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.xml.rpc.ServiceException;

import com.geored.backoffice.managedBean.BaseBean;
import com.geored.negocio.DaoException;
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
			listaEmpresas = Arrays.asList(getEmpresaPort().obtenerListado());
		} 
		catch (ServiceException e)
		{
			addBeanError(MSJ_ERROR_COMUNICACION_WS);
		} 
		catch (DaoException e)
		{
			addBeanError(e.getMessage());
		} 
		catch (RemoteException e)
		{
			addBeanError(MSJ_ERROR_COMUNICACION_WS);
		}
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
