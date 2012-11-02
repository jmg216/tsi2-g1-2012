package com.geored.backoffice.managedBean.ofertas;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.xml.rpc.ServiceException;

import com.geored.negocio.DaoException;
import com.geored.negocio.OfertaDTO;
import com.geored.negocio.OfertaServiceImpl;
import com.geored.negocio.OfertaServiceImplServiceLocator;

@ManagedBean(name="listadoOfertaBean")
public class ListadoOfertasBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<OfertaDTO> ofertas;

	public ListadoOfertasBean() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init() 
	{	
		
		try 
		{
			OfertaServiceImpl ofertaWS = new OfertaServiceImplServiceLocator().getOfertaServiceImplPort();
			OfertaDTO[] ofertasN = ofertaWS.obtenerListado();
			ofertas = Arrays.asList(ofertasN);
			
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public List<OfertaDTO> getOfertas() {
		return ofertas;
	}

	public void setOfertas(List<OfertaDTO> ofertas) {
		this.ofertas = ofertas;
	}
	
	
}
