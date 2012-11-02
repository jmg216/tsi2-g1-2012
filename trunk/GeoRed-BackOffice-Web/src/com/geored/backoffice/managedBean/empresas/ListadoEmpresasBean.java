package com.geored.backoffice.managedBean.empresas;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.xml.rpc.ServiceException;

import com.geored.backoffice.managedBean.BaseBean;
import com.geored.negocio.DaoException;
import com.geored.negocio.EmpresaDTO;
import com.geored.negocio.EmpresaServiceImpl;
import com.geored.negocio.EmpresaServiceImplServiceLocator;


@ManagedBean(name="listadoEmpresasBean")
@SessionScoped
public class ListadoEmpresasBean extends BaseBean implements Serializable
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<EmpresaDTO> listaEmpresas;
	
	public ListadoEmpresasBean()
	{
		try
		{
			EmpresaServiceImpl empresaWS = new EmpresaServiceImplServiceLocator().getEmpresaServiceImplPort();
			
			EmpresaDTO[] arrayEmpresaDTO = empresaWS.obtenerListado();
			
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

	public String crearEmpresa()
	{
		return null;
	}
	
	public String editarEmpresa()
	{
		return null;
	}
	
	public List<EmpresaDTO> getListaEmpresas()
	{
		return listaEmpresas;
	}

	public void setListaEmpresas(List<EmpresaDTO> listaEmpresas)
	{
		this.listaEmpresas = listaEmpresas;
	}
}
