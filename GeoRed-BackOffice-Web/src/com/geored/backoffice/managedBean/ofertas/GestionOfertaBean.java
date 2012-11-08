package com.geored.backoffice.managedBean.ofertas;

import java.io.Serializable;
import java.rmi.RemoteException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.xml.rpc.ServiceException;

import com.geored.backoffice.managedBean.BaseBean;
import com.geored.backoffice.utiles.UtilesWeb;
import com.geored.negocio.DaoException;
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
	
	public GestionOfertaBean()
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
}
