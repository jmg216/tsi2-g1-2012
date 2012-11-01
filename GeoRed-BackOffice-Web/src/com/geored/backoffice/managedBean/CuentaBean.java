package com.geored.backoffice.managedBean;

import java.io.IOException;
import java.io.Serializable;
import java.rmi.RemoteException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.xml.rpc.ServiceException;

import com.geored.negocio.AdminServiceImpl;
import com.geored.negocio.AdminServiceImplServiceLocator;
import com.geored.negocio.AdministradorDTO;
import com.geored.utiles.UtilesSeguridad;

@ManagedBean(name = "cuentaBean")
@SessionScoped
public class CuentaBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private AdministradorDTO administradorDTO;

	@PostConstruct
	public void init()
	{
		// FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
	}

	public void autenticar() throws ServiceException
	{
		try
		{
			AdminServiceImpl admiWs = new AdminServiceImplServiceLocator().getAdminServiceImplPort();
			
			administradorDTO = admiWs.obtenerAdminPorEmailYPass(administradorDTO.getEmail(), administradorDTO.getPass());
			
			if(administradorDTO != null)
			{
				UtilesSeguridad.almacenarAdminAutenticado(administradorDTO);
				
				FacesContext.getCurrentInstance().getExternalContext().redirect("IndexAdminEmpresas.xhtml");
			}
		} 
		catch (RemoteException e1)
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error logueando usuario"));
		} 
		catch (IOException e)
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error logueando usuario"));
		}
	}

	public AdministradorDTO getAdministradorDTO()
	{
		return administradorDTO;
	}

	public void setAdministradorDTO(AdministradorDTO administradorDTO)
	{
		this.administradorDTO = administradorDTO;
	}
}