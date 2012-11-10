package com.geored.backoffice.managedBean.sitios;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.geored.backoffice.managedBean.BaseBean;
import com.geored.backoffice.utiles.UtilesWeb;
import com.geored.negocio.SitioDTO;
import com.geored.negocio.TematicaDTO;

@ManagedBean(name="gestionSitioBean")
@RequestScoped
public class GestionSitioBean extends BaseBean implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8834025396990537040L;
	
	private static final String TO_LISTADO_SITIOS = "to_listado_sitios";
	
	private SitioDTO sitioDTO = new SitioDTO();
	
	private List<TematicaDTO> listaTematicas = new ArrayList<TematicaDTO>();
	
	public GestionSitioBean()
	{	
		String idSitio = getRequestParameter("idSitio");                
		
		if(UtilesWeb.isNullOrEmpty(idSitio))
		{
			sitioDTO = new SitioDTO();
		}
		else
		{
			try
			{
				sitioDTO = getSitioPort().obtener(Long.valueOf(idSitio));
			} 
			catch (Exception e)
			{
				addBeanError(e.getMessage());
			} 
		}
		
		cargarDatoIniciales();
	}

	private void cargarDatoIniciales()
	{
		try
		{
			listaTematicas = Arrays.asList(getGlobalPort().obtenerListadoTematicas());
		} 
		catch (Exception e)
		{
			handleWSException(e);
		}
	}
	
	public void guardarSitio()
	{
		addBeanMessage("Sitio guardado correctamente");
	}
	
	public String toListadoSitios()
	{
		return TO_LISTADO_SITIOS;
	}

	public SitioDTO getSitioDTO()
	{
		return sitioDTO;
	}

	public void setSitioDTO(SitioDTO sitioDTO)
	{
		this.sitioDTO = sitioDTO;
	}

	public List<TematicaDTO> getListaTematicas()
	{
		return listaTematicas;
	}

	public void setListaTematicas(List<TematicaDTO> listaTematicas)
	{
		this.listaTematicas = listaTematicas;
	}
}
