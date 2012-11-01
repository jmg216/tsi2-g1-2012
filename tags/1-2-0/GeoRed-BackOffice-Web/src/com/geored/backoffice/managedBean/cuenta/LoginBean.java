package com.geored.backoffice.managedBean.cuenta;

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
import com.geored.utiles.UtilesSeguridadWeb;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String SUCCESS = "success";
	
	private String email;
	
	private String pass;

	@PostConstruct
	public void init()
	{
	}

	public String iniciarSesion()
	{
		try
		{
			AdminServiceImpl admiWs = new AdminServiceImplServiceLocator().getAdminServiceImplPort();
			
			AdministradorDTO administradorDTO = admiWs.obtenerAdminPorEmailYPass(getEmail(), getPass());
			
			if(administradorDTO != null)
			{
				UtilesSeguridadWeb.guardarUsuarioAutenticado(administradorDTO);
			}
		} 
		catch (RemoteException e1)
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error logueando usuario"));
		}
		catch (ServiceException e)
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error logueando usuario"));
		} 
		
		return SUCCESS;
	}

	public String cerrarSesion()
	{
		UtilesSeguridadWeb.borrarUsuarioAutenticado();
		
		return SUCCESS;
	}
	
	public boolean hayUsuarioAutenticado()
	{
		return UtilesSeguridadWeb.hayUsuarioAutenticado();
	}
	
	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPass()
	{
		return pass;
	}

	public void setPass(String pass)
	{
		this.pass = pass;
	}
}