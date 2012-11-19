package com.geored.backoffice.managedBean.ofertas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.geored.backoffice.managedBean.BaseBean;
import com.geored.backoffice.utiles.UtilesWeb;
import com.geored.negocio.OfertaDTO;

@ManagedBean(name="listadoOfertasBean")
@RequestScoped
public class ListadoOfertasBean extends BaseBean implements Serializable
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4689434236912827528L;

	private static final String TO_GESTION_OFERTA = "to_gestion_oferta";
	
	private Long idOferta;
	
	private List<OfertaDTO> listaOfertas = new ArrayList<OfertaDTO>();

	public ListadoOfertasBean()
	{
		try 
		{
			OfertaDTO[] arrayOfertasDTO = getOfertaPort().obtenerListadoPorEmpresa(UtilesWeb.obtenerEmpresaAdministrada().getId());
				
			if(arrayOfertasDTO != null)
			{
				listaOfertas = Arrays.asList(arrayOfertasDTO);
			}			
		} 
		catch (Exception e) 
		{
			handleWSException(e);
		}
	}
	
	public String toGestionOferta()
	{
		return TO_GESTION_OFERTA;
	}

	public Long getIdOferta()
	{
		return idOferta;
	}

	public void setIdOferta(Long idOferta)
	{
		this.idOferta = idOferta;
	}

	public List<OfertaDTO> getListaOfertas()
	{
		return listaOfertas;
	}

	public void setListaOfertas(List<OfertaDTO> listaOfertas)
	{
		this.listaOfertas = listaOfertas;
	}
}
