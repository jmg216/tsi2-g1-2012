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

	private static final String TO_GESTION = "to_gestion";
	
	private Long idEmpresa;
	
	private List<EmpresaDTO> listaEmpresas = new ArrayList<EmpresaDTO>();
	
	public ListadoEmpresasBean()
	{
		try
		{
			EmpresaDTO[] arrayEmpresaDTO = getEmpresaPort().obtenerListado();
			
			listaEmpresas = Arrays.asList(arrayEmpresaDTO);
		} 
		catch (ServiceException e)
		{
			addMessage(MSJ_ERROR_COMUNICACION_WS);
		} 
		catch (DaoException e)
		{
			addMessage(e.getMessage());
		} 
		catch (RemoteException e)
		{
			addMessage(MSJ_ERROR_COMUNICACION_WS);
		}
	}
	
	public String toGestion()
	{
		return TO_GESTION;
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
