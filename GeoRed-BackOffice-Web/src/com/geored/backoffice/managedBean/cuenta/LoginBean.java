package com.geored.backoffice.managedBean.cuenta;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.geored.backoffice.managedBean.BaseBean;
import com.geored.backoffice.utiles.UtilesSeguridadWeb;
import com.geored.negocio.AdminServiceImpl;
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
	
	private String email = "admin@geored.com";
	private String pass = "admin";

	public String iniciarSesion()
	{
		try
		{
			AdminServiceImpl admiWs = getAdminPort();
			
			AdministradorDTO administradorDTO = admiWs.obtenerAdminPorEmailYPass(getEmail(), UtilesSeguridadWeb.encriptarMD5(getPass()));
		
			if(administradorDTO != null)
			{
				UtilesSeguridadWeb.guardarUsuarioAutenticado(administradorDTO);
			}
		} 
		catch (Exception e)
		{
			handleWSException(e);
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