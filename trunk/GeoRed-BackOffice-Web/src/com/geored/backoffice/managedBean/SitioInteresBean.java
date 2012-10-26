
package com.geored.backoffice.managedBean;

import java.io.Serializable;
import java.rmi.RemoteException;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.xml.rpc.ServiceException;


import com.geored.negocio.AdminServiceImplServiceLocator;
import com.geored.negocio.AdministradorDTO;
import com.geored.negocio.DaoException;
import com.geored.negocio.NegocioException;
import com.geored.negocio.SitioDTO;
import com.geored.negocio.SitioServiceImpl;
import com.geored.negocio.SitioServiceImplService;
import com.geored.negocio.SitioServiceImplServiceLocator;


@ManagedBean(name="sitioInteresBean")
@SessionScoped
public class SitioInteresBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String descripcion;
	private String imagenes;
	private String ubicacion;
	
	private SitioServiceImpl sitioWS;
	private SitioServiceImplServiceLocator locator;
	// Faltan las tematicas para los sitios private TematicaSitio ts;
	
	public String getNombre()
	{
		return this.nombre;
	}
	
	public String getDescripcion()
	{
		return this.descripcion;
	}
	
	public String getImagenes()
	{
		return this.imagenes;
	}
	
	public String getUbicacion()
	{
		return this.ubicacion;
	}
	
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	
	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}
	
	public void setImagenes(String imagenes)
	{
		this.imagenes = imagenes;
	}
	
	public void setUbicacion(String ubicacion)
	{
		this.ubicacion = ubicacion;
	}
	
	public void crearSitio() throws ServiceException
	{
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
		
		locator = new SitioServiceImplServiceLocator ();
		sitioWS = locator.getSitioServiceImplPort();
		
		SitioDTO sitio = null;
		
		sitio.setDescripcion(descripcion);
		sitio.setNombre(nombre);
		sitio.setUbicacionGeografica(ubicacion);
		
		try
		{
			sitioWS.insertar(sitio);
		
		} catch(RemoteException e1)
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No es posible Salvar el sitio."));
		}
		
	}
	
}
