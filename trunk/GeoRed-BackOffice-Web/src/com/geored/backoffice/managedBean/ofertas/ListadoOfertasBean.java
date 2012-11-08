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
			OfertaDTO[] arrayOfertas = getOfertaPort().obtenerListado();
			
			if(arrayOfertas != null)
			{
				listaOfertas = Arrays.asList(arrayOfertas);
			}
			else
			{
				listaOfertas = new ArrayList<OfertaDTO>();
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
}
