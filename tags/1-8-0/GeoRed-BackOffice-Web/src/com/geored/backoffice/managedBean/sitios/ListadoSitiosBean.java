package com.geored.backoffice.managedBean.sitios;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.geored.backoffice.managedBean.BaseBean;
import com.geored.negocio.SitioDTO;

@ManagedBean(name="listadoSitiosBean")
@RequestScoped
public class ListadoSitiosBean extends BaseBean implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -285130153830430998L;
	
	private static final String TO_GESTION_SITIO = "to_gestion_sitio";
	
	private Long idSitio;
	
	private List<SitioDTO> listaSitios = new ArrayList<SitioDTO>();

	public ListadoSitiosBean()
	{
		try 
		{
			SitioDTO[] arraySitios = getSitioPort().obtenerListado();
			
			if(arraySitios != null)
			{
				listaSitios = Arrays.asList(arraySitios);
			}
			else
			{
				listaSitios = new ArrayList<SitioDTO>();
			}
		} 
		catch (Exception e) 
		{
			handleWSException(e);
		} 
	}
	
	public String eliminarSitio()
	{
		try
		{
			getSitioPort().eliminar(idSitio);
		} 
		catch (Exception e)
		{
			handleWSException(e);
		}
		
		return SUCCESS;
	}
	
	public String toGestionSitio()
	{
		return TO_GESTION_SITIO;
	}

	public Long getIdSitio()
	{
		return idSitio;
	}

	public void setIdSitio(Long idSitio)
	{
		this.idSitio = idSitio;
	}

	public List<SitioDTO> getListaSitios()
	{
		return listaSitios;
	}

	public void setListaSitios(List<SitioDTO> listaSitios)
	{
		this.listaSitios = listaSitios;
	}
	
	
}
