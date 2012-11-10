package com.geored.backoffice.managedBean.ofertas;

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
import com.geored.negocio.LocalDTO;
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
	
	private List<LocalDTO> listaLocales = new ArrayList<LocalDTO>();
	
	private List<OfertaDTO> listadoOfertas = new ArrayList<OfertaDTO>();
	
	private List<OfertaDTO> listaPublicar = new ArrayList<OfertaDTO>();
	
	private OfertaDTO ofertaDTO = new OfertaDTO();

	public ListadoOfertasBean() 
	{
		try 
		{
			String idEmpresa = getRequestParameter("idEmpresa");
			
			listaLocales = Arrays.asList(getEmpresaPort().obtener(Long.valueOf(idEmpresa)).getListaLocalesDTO());
			
			listaOfertas = Arrays.asList(getOfertaPort().obtenerListado());
			
			for (OfertaDTO oferta : listaOfertas) 
			{
				for (LocalDTO local : listaLocales) {
					
					if (oferta.getIdLocal().equals(local.getId()))
					{
						listadoOfertas.add(oferta);
					}
				}
			}
			
			if(listadoOfertas != null)
			{
				listaPublicar = listadoOfertas;
			}
			else
			{
				listaPublicar = new ArrayList<OfertaDTO>();
			}
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

	public List<LocalDTO> getListaLocales() {
		return listaLocales;
	}

	public void setListaLocales(List<LocalDTO> listaLocales) {
		this.listaLocales = listaLocales;
	}

	public List<OfertaDTO> getListadoOfertas() {
		return listadoOfertas;
	}

	public void setListadoOfertas(List<OfertaDTO> listadoOfertas) {
		this.listadoOfertas = listadoOfertas;
	}

	public List<OfertaDTO> getListaPublicar() {
		return listaPublicar;
	}

	public void setListaPublicar(List<OfertaDTO> listaPublicar) {
		this.listaPublicar = listaPublicar;
	}

	public OfertaDTO getOfertaDTO() {
		return ofertaDTO;
	}

	public void setOfertaDTO(OfertaDTO ofertaDTO) {
		this.ofertaDTO = ofertaDTO;
	}
	
	
}
