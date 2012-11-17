package com.geored.backoffice.utiles;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.faces.context.FacesContext;

import com.geored.negocio.AdministradorDTO;
import com.geored.negocio.EmpresaDTO;

public class UtilesSeguridadWeb
{
	// Constantes seguridad	
	public static final String DEFAULT_PASS = "admin";
	
	private static final String KEY_ADMIN_AUTENTICADO = "com.geored.utiles.UtilesSeguridad.KEY_ADMIN_AUTENTICADO";
	
	private static final String KEY_EMPRESA_ADMINISTRADA = "com.geored.utiles.UtilesSeguridad.KEY_EMPRESA_ADMINISTRADA";
	
	// Funciones con el usuario autenticado
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
	
	// Funciones para el admin de empresa, indica que empresa esta administrando
	public static void guardarEmpresaAdministrada(EmpresaDTO empresaDTO)
	{
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(KEY_EMPRESA_ADMINISTRADA, empresaDTO);
	}
	
	public static EmpresaDTO obtenerEmpresaAutenticada()
	{
		return (EmpresaDTO) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(KEY_EMPRESA_ADMINISTRADA);
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