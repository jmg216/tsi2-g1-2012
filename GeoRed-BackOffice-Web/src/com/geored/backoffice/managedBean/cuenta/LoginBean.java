package com.geored.backoffice.managedBean.cuenta;

import java.io.Serializable;
import java.rmi.RemoteException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.xml.rpc.ServiceException;

import com.geored.backoffice.managedBean.BaseBean;
import com.geored.negocio.AdminServiceImpl;
import com.geored.negocio.AdminServiceImplServiceLocator;
import com.geored.negocio.AdministradorDTO;
import com.geored.utiles.UtilesSeguridadWeb;

@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginBean extends BaseBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String email;
	private String pass;

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
			addMessage(MSJ_ERROR_COMUNICACION_WS);
		}
		catch (ServiceException e)
		{
			addMessage(MSJ_ERROR_COMUNICACION_WS);
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