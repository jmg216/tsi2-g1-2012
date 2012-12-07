package com.geored.backoffice.managedBean.cuenta;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.geored.backoffice.managedBean.BaseBean;
import com.geored.backoffice.utiles.UtilesSeguridadWeb;
import com.geored.backoffice.utiles.UtilesWeb;
import com.geored.negocio.AdministradorDTO;

@ManagedBean(name="perfilBean")
@RequestScoped
public class PerfilBean extends BaseBean implements Serializable
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3650528505815349823L;
	
	private static final int VALIDAR_CAMBIO_CONTRASEÑA = 1;
	
	private static final int VALIDAR_GUARDAR = 2;
	
	private AdministradorDTO administradorDTO = new AdministradorDTO();
	
	private String contraseniaActual;
	
	private String nuevaContrasenia;
	
	private String confirmacionNuevaContrasenia;

	public PerfilBean()
	{
		administradorDTO = UtilesWeb.obtenerUsuarioAutenticado();
	}

	public String guardarDatos()
	{
		try
		{
			if(validar(VALIDAR_GUARDAR))
			{
				getAdminPort().actualizar(getAdministradorDTO());
				
				UtilesSeguridadWeb.guardarUsuarioAutenticado(getAdminPort().obtener(getAdministradorDTO().getId()));
				
				addBeanMessage("Administrador guardado correctamente");
			}			
		}
		catch(Exception e)
		{
			handleWSException(e);
		}
		
		return SUCCESS;
	}
	
	public String cambiarContraseña()
	{
		try
		{
			if(validar(VALIDAR_CAMBIO_CONTRASEÑA))
			{
				String encActual = UtilesSeguridadWeb.encriptarMD5(contraseniaActual);
				
				if(!getAdministradorDTO().getPass().equals(encActual))
				{
					addBeanError("La contrasenia actual ingresada es incorrecta");
					
					return SUCCESS;
				}
				else
				{
					String encNueva = UtilesSeguridadWeb.encriptarMD5(nuevaContrasenia);
					
					getAdministradorDTO().setPass(encNueva);
					
					getAdminPort().actualizar(getAdministradorDTO());
					
					UtilesSeguridadWeb.guardarUsuarioAutenticado(getAdminPort().obtener(getAdministradorDTO().getId()));
					
					addBeanMessage("Contraseña cambiada correctamente");						
				}
			}
		}
		catch(Exception e)
		{
			handleWSException(e);
		}
		
		return SUCCESS;
	}
	
	private boolean validar(int opValidar)
	{
		boolean isValid = true;
		
		if(opValidar == VALIDAR_CAMBIO_CONTRASEÑA)
		{
			if(UtilesWeb.isNullOrEmpty(contraseniaActual))
			{
				addBeanError("perfilForm:contraseniaActual", "Obligatorio");
				isValid = false;
			}	
			if(UtilesWeb.isNullOrEmpty(nuevaContrasenia))
			{
				addBeanError("perfilForm:nuevaContrasenia", "Obligatorio");
				isValid = false;
			}
			if(UtilesWeb.isNullOrEmpty(confirmacionNuevaContrasenia))
			{
				addBeanError("perfilForm:confirmacionNuevaContrasenia", "Obligatorio");
				isValid = false;
			}
			if(!UtilesWeb.isNullOrEmpty(nuevaContrasenia) && !UtilesWeb.isNullOrEmpty(confirmacionNuevaContrasenia))
			{
				if(!nuevaContrasenia.equals(confirmacionNuevaContrasenia))
				{
					addBeanError("perfilForm:confirmacionNuevaContrasenia", "No cohincide con la nueva contraseña");
					isValid = false;
				}
					
			}
			
		}
		else if(opValidar == VALIDAR_GUARDAR)
		{
			if(UtilesWeb.isNullOrEmpty(getAdministradorDTO().getEmail()))
			{
				addBeanError("perfilNombre:emailAdministrador", "Obligatorio");
				isValid = false;
			}
			if(UtilesWeb.isNullOrEmpty(getAdministradorDTO().getNombre()))
			{
				addBeanError("perfilForm:nombreAdministrador", "Obligatorio");
				isValid = false;
			}
		}
		
		return isValid;
	}
	
	public AdministradorDTO getAdministradorDTO()
	{
		return administradorDTO;
	}

	public void setAdministradorDTO(AdministradorDTO administradorDTO)
	{
		this.administradorDTO = administradorDTO;
	}

	public String getContraseniaActual()
	{
		return contraseniaActual;
	}

	public void setContraseniaActual(String contraseniaActual)
	{
		this.contraseniaActual = contraseniaActual;
	}

	public String getNuevaContrasenia()
	{
		return nuevaContrasenia;
	}

	public void setNuevaContrasenia(String nuevaContrasenia)
	{
		this.nuevaContrasenia = nuevaContrasenia;
	}

	public String getConfirmacionNuevaContrasenia()
	{
		return confirmacionNuevaContrasenia;
	}

	public void setConfirmacionNuevaContrasenia(String confirmacionNuevaContrasenia)
	{
		this.confirmacionNuevaContrasenia = confirmacionNuevaContrasenia;
	}
}