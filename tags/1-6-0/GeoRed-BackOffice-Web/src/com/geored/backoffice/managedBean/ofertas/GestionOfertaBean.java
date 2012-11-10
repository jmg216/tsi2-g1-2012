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
import com.geored.backoffice.utiles.UtilesGeocoding;
import com.geored.backoffice.utiles.UtilesWeb;
import com.geored.negocio.DaoException;
import com.geored.negocio.EmpresaDTO;
import com.geored.negocio.LocalDTO;
import com.geored.negocio.NegocioException;
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
	
	private OfertaDTO ofertaDTO = new OfertaDTO();
	
	private EmpresaDTO empresaDTO = new EmpresaDTO();

	private List<LocalDTO> listaLocales = new ArrayList<LocalDTO>();
	
	private List<String> listaNombreLocales = new ArrayList<String>();
	
	public GestionOfertaBean()
	{	
		String idOferta = getRequestParameter("idOferta");
		String idEmpresa = getRequestParameter("idEmpresa");
		
		if(UtilesWeb.isNullOrEmpty(idOferta))
		{
			ofertaDTO = new OfertaDTO();
		}
		else
		{
			try
			{
				ofertaDTO = getOfertaPort().obtener(Long.valueOf(idOferta));
				
				listaLocales = Arrays.asList(getEmpresaPort().obtener(Long.valueOf(idEmpresa)).getListaLocalesDTO());
				
				for (LocalDTO local : listaLocales) {
						
					if (ofertaDTO.getIdLocal().equals(local.getId()))
					{
						String ubicacion = local.getUbicacionGeografica();
						listaNombreLocales.add(UtilesGeocoding.inverseGeocoding(ubicacion));
					}
				}
				
			} 
			catch (NegocioException e)
			{
				addBeanError(e.getMessage());
			} 
			catch (DaoException e)
			{
				addBeanError(e.getMessage());
			} 
			catch (RemoteException e)
			{
				addBeanError(MSJ_ERROR_COMUNICACION_WS);
			} 
			catch (ServiceException e)
			{
				addBeanError(MSJ_ERROR_COMUNICACION_WS);
			}
		}
	}

	public void guardarOferta()
	{
		addBeanMessage("Oferta guardada correctamente");
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

	public List<LocalDTO> getListaLocales() {
		return listaLocales;
	}

	public void setListaLocales(List<LocalDTO> listaLocales) {
		this.listaLocales = listaLocales;
	}

	public EmpresaDTO getEmpresaDTO() {
		return empresaDTO;
	}

	public void setEmpresaDTO(EmpresaDTO empresaDTO) {
		this.empresaDTO = empresaDTO;
	}

	public List<String> getListaNombreLocales() {
		return listaNombreLocales;
	}

	public void setListaNombreLocales(List<String> listaNombreLocales) {
		this.listaNombreLocales = listaNombreLocales;
	}
	
}
