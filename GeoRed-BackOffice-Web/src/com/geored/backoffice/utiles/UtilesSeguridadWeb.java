package com.geored.backoffice.utiles;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
		return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(KEY_ADMIN_AUTENTICADO) != null;
	}
	
	public static AdministradorDTO obtenerUsuarioAutenticado()
	{
		return (AdministradorDTO) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(KEY_ADMIN_AUTENTICADO);
	}
	
	// Utilidades para encriptar password
  	public static String encriptarMD5(String cadena)
	{
  		final char[] CONSTS_HEX = { '0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f' };
  		
		try
		{
			MessageDigest msgd = MessageDigest.getInstance("MD5");
			
			byte[] bytes = msgd.digest(cadena.getBytes());
			
			StringBuilder strCadenaMD5 = new StringBuilder(2 * bytes.length);
			
			for (int i = 0; i < bytes.length; i++)
			{
				int bajo = (int)(bytes[i] & 0x0f);
				int alto = (int)((bytes[i] & 0xf0) >> 4);
				strCadenaMD5.append(CONSTS_HEX[alto]);
				strCadenaMD5.append(CONSTS_HEX[bajo]);
			}
			
			return strCadenaMD5.toString();
		} 
		catch (NoSuchAlgorithmException e) 
		{
		   return null;
		}
	}
}