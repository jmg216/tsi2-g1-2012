package com.geored.backoffice.managedBean.locales;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.geored.backoffice.managedBean.BaseBean;
import com.geored.backoffice.utiles.UtilesSeguridadWeb;
import com.geored.negocio.LocalDTO;

@ManagedBean(name="listadoLocalesBean")
@RequestScoped
public class ListadoLocalesBean extends BaseBean implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -285130153830430998L;
	
	private static final String TO_GESTION_LOCAL = "to_gestion_local";
	
	private Long idLocal;
	
	private List<LocalDTO> listaLocales = new ArrayList<LocalDTO>();

	public ListadoLocalesBean() 
	{
		try 
		{
			LocalDTO[] arrayLocales = getEmpresaPort().obtenerListadoLocalesPorEmpresa(UtilesSeguridadWeb.obtenerEmpresaAdministrada().getId());
			
			if(arrayLocales != null)
			{
				listaLocales = Arrays.asList(arrayLocales);
			}
			else
			{
				listaLocales = new ArrayList<LocalDTO>();
			}
		} 
		catch (Exception e) 
		{
			handleWSException(e);
		} 
	}
	
	public String eliminarLocal()
	{
		try
		{
			getEmpresaPort().eliminarLocal(getIdLocal());
		} 
		catch (Exception e)
		{
			handleWSException(e);
		}
		
		return SUCCESS;
	}
	
	public String toGestionLocal()
	{
		return TO_GESTION_LOCAL;
	}

	public Long getIdLocal()
	{
		return idLocal;
	}

	public void setIdLocal(Long idLocal)
	{
		this.idLocal = idLocal;
	}

	public List<LocalDTO> getListaLocales()
	{
		return listaLocales;
	}

	public void setListaLocales(List<LocalDTO> listaLocales)
	{
		this.listaLocales = listaLocales;
	}	
}
