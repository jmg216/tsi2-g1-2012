package com.geored.backoffice.managedBean.ofertas;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.xml.rpc.ServiceException;

import com.geored.backoffice.managedBean.BaseBean;
import com.geored.negocio.DaoException;
import com.geored.negocio.OfertaDTO;

@ManagedBean(name="listadoOfertaBean")
@RequestScoped
public class ListadoOfertasBean extends BaseBean implements Serializable
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4689434236912827528L;

	private static final String TO_GESTION = "to_gestion";
	
	private List<OfertaDTO> ofertas;
	
	private Long idOferta;

	public ListadoOfertasBean() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init() 
	{	
		
		try 
		{
			OfertaDTO[] ofertasN = getOfertaPort().obtenerListado();
			ofertas = Arrays.asList(ofertasN);
			
		} catch (ServiceException e) 
		{
			addMessage(MSJ_ERROR_COMUNICACION_WS);
			
		} catch (DaoException e) 
		{
			addMessage(e.getMessage());
			
		} catch (RemoteException e) 
		
		{
			addMessage(MSJ_ERROR_COMUNICACION_WS);
		}
		
	}
	
	public String toGestion()
	{
		return TO_GESTION;
	}

	public Long getIdOferta() {
		return idOferta;
	}

	public void setIdOferta(Long idOferta) {
		this.idOferta = idOferta;
	}

	public List<OfertaDTO> getOfertas() {
		return ofertas;
	}

	public void setOfertas(List<OfertaDTO> ofertas) {
		this.ofertas = ofertas;
	}
	
	
}
