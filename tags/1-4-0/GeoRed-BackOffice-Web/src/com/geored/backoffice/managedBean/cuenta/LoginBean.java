package com.geored.backoffice.managedBean.cuenta;

import java.io.Serializable;
import java.rmi.RemoteException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.xml.rpc.ServiceException;

import com.geored.backoffice.managedBean.BaseBean;
import com.geored.backoffice.utiles.UtilesSeguridadWeb;
import com.geored.negocio.AdminServiceImpl;
import com.geored.negocio.AdminServiceImplServiceLocator;
import com.geored.negocio.AdministradorDTO;

@ManagedBean(name="loginBean")
@RequestScoped
public class LoginBean extends BaseBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1070740152270054906L;
	
	private static final String SUCCESS = "success";
	
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
			addBeanError(MSJ_ERROR_COMUNICACION_WS);
		}
		catch (ServiceException e)
		{
			addBeanError(MSJ_ERROR_COMUNICACION_WS);
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