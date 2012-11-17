package com.geored.backoffice.managedBean.empresas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.geored.backoffice.managedBean.BaseBean;
import com.geored.backoffice.utiles.UtilesSeguridadWeb;
import com.geored.backoffice.utiles.UtilesWeb;
import com.geored.negocio.EmpresaDTO;

@ManagedBean(name="seleccionEmpresaBean")
@RequestScoped
public class SeleccionEmpresaBean extends BaseBean implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8685940588253930044L;
	
	private List<EmpresaDTO> listaEmpresas = new ArrayList<EmpresaDTO>();
	
	private Long idEmpresa;
	
	public SeleccionEmpresaBean()
	{
		listaEmpresas = Arrays.asList(UtilesWeb.obtenerUsuarioAutenticado().getListaEmpresasDTO());
	}
	
	public String seleccionarEmpresa()
	{
		try
		{
			if(idEmpresa == null)
			{
				addBeanError("Debe seleccionar una empresa");
			}
			else
			{
				EmpresaDTO empresaDTO = getEmpresaPort().obtener(idEmpresa);
				
				UtilesSeguridadWeb.guardarEmpresaAdministrada(empresaDTO);
				
				return TO_INDEX;
			}
		}
		catch(Exception e)
		{
			handleWSException(e);
		}	
		
		return SUCCESS;
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