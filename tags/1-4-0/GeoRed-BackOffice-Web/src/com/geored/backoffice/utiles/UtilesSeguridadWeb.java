package com.geored.backoffice.utiles;

import javax.faces.context.FacesContext;

import com.geored.negocio.AdministradorDTO;

public class UtilesSeguridadWeb
{
	// Constantes seguridad
	private static final String KEY_ADMIN_AUTENTICADO = "com.geored.utiles.UtilesSeguridad.KEY_ADMIN_AUTENTICADO";
	
	public static void guardarUsuarioAutenticado(AdministradorDTO administradorDTO)
	{
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(KEY_ADMIN_AUTENTICADO, administradorDTO);
	}
	
	public static void borrarUsuarioAutenticado()
	{
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(KEY_ADMIN_AUTENTICADO);
	}
	
	public static boolean hayUsuarioAutenticado()
	{
		// return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(KEY_ADMIN_AUTENTICADO) != null;
		return true;
	}
}