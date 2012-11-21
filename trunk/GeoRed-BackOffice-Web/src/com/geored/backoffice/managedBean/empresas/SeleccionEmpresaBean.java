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
		try
		{
			EmpresaDTO[] arrayEmpresasDTO = getEmpresaPort().obtenerListadoPorAdministrador(UtilesWeb.obtenerUsuarioAutenticado().getId());
			
			if(arrayEmpresasDTO != null)
			{
				listaEmpresas = Arrays.asList(arrayEmpresasDTO);
			}
		}
		catch(Exception e)
		{
			handleWSException(e);
		}
	}
	
	public String seleccionarEmpresa()
	{
		try
		{
			if(UtilesWeb.isNullOrZero(idEmpresa))
			{
				addBeanError("seleccionEmpresaForm:empresaSeleccionada", "Obligatorio");
			}
			else
			{
				EmpresaDTO empresaDTO = getEmpresaPort().obtener(idEmpresa);
				
				UtilesSeguridadWeb.guardarEmpresaAdministrada(empresaDTO);
				
				if(UtilesSeguridadWeb.obtenerUsuarioSeleccionEmpresa() != null)
				{
					UtilesSeguridadWeb.guardarUsuarioAutenticado(UtilesSeguridadWeb.obtenerUsuarioSeleccionEmpresa());
					
					UtilesSeguridadWeb.borrarUsuarioSeleccionEmpresa();
				}
				
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