package com.geored.backoffice.managedBean.ofertas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.geored.backoffice.managedBean.BaseBean;
import com.geored.backoffice.utiles.UtilesWeb;
import com.geored.negocio.LocalDTO;
import com.geored.negocio.OfertaDTO;

@ManagedBean(name="gestionOfertaBean")
@RequestScoped
public class GestionOfertaBean extends BaseBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6757255144084899088L;

	private static final String TO_LISTADO_OFERTAS = "to_listado_ofertas";

	private static final String OFERTA_DTO_KEY = "OFERTA_DTO_KEY"; 
	
	private OfertaDTO ofertaDTO = new OfertaDTO();

	private List<LocalDTO> listaLocales = new ArrayList<LocalDTO>();
	
	public GestionOfertaBean()
	{	
		ofertaDTO = (OfertaDTO) getFlashAttribute(OFERTA_DTO_KEY);
		
		if(ofertaDTO == null)
		{
			String idOferta = getRequestParameter("idOferta");
			
			if(UtilesWeb.isNullOrEmpty(idOferta))
			{
				ofertaDTO = new OfertaDTO();
			}
			else
			{
				try
				{
					ofertaDTO = getOfertaPort().obtener(Long.valueOf(idOferta));
				} 
				catch (Exception e)
				{
					handleWSException(e);
				} 
			}
			
			setFlashAttribute(OFERTA_DTO_KEY, ofertaDTO);
		}		
		
		cargarDatosIniciales();
	}
	
	private void cargarDatosIniciales()
	{
		try
		{
			LocalDTO[] arrayLocalesDTO = getEmpresaPort().obtenerListadoLocalesPorEmpresa(UtilesWeb.obtenerEmpresaAdministrada().getId());
					
			if(arrayLocalesDTO != null)
			{
				listaLocales = Arrays.asList(arrayLocalesDTO);
			}
		} 
		catch(Exception e)
		{
			handleWSException(e);
		}
	}

	public String guardarOferta()
	{
		return SUCCESS;
	}
	
	public String toListadoOfertas()
	{
		return TO_LISTADO_OFERTAS;
	}

	public OfertaDTO getOfertaDTO() 
	{
		return ofertaDTO;
	}

	public void setOfertaDTO(OfertaDTO ofertaDTO) 
	{
		this.ofertaDTO = ofertaDTO;
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
