package com.geored.backoffice.managedBean.cuenta;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.geored.backoffice.managedBean.BaseBean;
import com.geored.backoffice.utiles.UtilesSeguridadWeb;
import com.geored.backoffice.utiles.UtilesWeb;
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
	
	private String email = "admin@geored.com";
	private String pass;

	public String iniciarSesion()
	{
		try
		{
			if(!validaInicioSesion())
			{	
				return ERROR;
			}
			
			AdminServiceImpl admiWs = getAdminPort();
			
			AdministradorDTO administradorDTO = admiWs.obtenerAdminPorEmailYPass(getEmail(), UtilesSeguridadWeb.encriptarMD5(getPass()));
		
			if(administradorDTO == null)
			{
				addBeanError("Administrador no encontrado");
				
				return ERROR;
			}
			
			UtilesSeguridadWeb.guardarUsuarioAutenticado(administradorDTO);
		} 
		catch (Exception e)
		{
			handleWSException(e);
			
			return ERROR;
		} 
		
		return SUCCESS;
	}

	private boolean validaInicioSesion()
	{
		boolean isValid = true;
		
		if(UtilesWeb.isNullOrEmpty(getEmail()))
		{
			addBeanError("El campo 'E-mail' es obligatorio");
			isValid = false;
		}
		
		if(UtilesWeb.isNullOrEmpty(getPass()))
		{
			addBeanError("El campo 'Password' es obligatorio");
			isValid = false;
		}
		
		return isValid;
	}
	
	public String cerrarSesion()
	{
		UtilesSeguridadWeb.borrarUsuarioAutenticado();
		
		return SUCCESS;
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