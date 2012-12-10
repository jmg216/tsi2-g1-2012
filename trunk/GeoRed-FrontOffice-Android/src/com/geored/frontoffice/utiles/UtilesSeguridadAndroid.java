package com.geored.frontoffice.utiles;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.geored.dto.UsuarioDTO;

public class UtilesSeguridadAndroid{
	
	private static final String KEY_USER_PREFERENCE = "UserPreference";
	public static final String API_KEY = "AIzaSyA-sjjWHPR2JIHEipdGAFKH8rLcK25Od1A";
	public static final String ID_SENDER_GCM = "121239138891";
	
	private static UsuarioDTO usuarioDTO;
	
	public static void setUsuarioAutenticado(Context context, UsuarioDTO usuarioADTO)
	{
		
		SharedPreferences prefs = context.getSharedPreferences(KEY_USER_PREFERENCE ,Context.MODE_PRIVATE);
		Editor editor = prefs.edit();
		
		editor.putLong("id", usuarioADTO.getId());
		editor.putString("nombreUser", usuarioADTO.getNombre());
		editor.putString("emailUser", usuarioADTO.getEmail());
		editor.commit();
	}
	
	public static UsuarioDTO getUsuarioAutenticado(Context context)
	{
		SharedPreferences prefs = context.getSharedPreferences(KEY_USER_PREFERENCE ,Context.MODE_PRIVATE);
		
    	Long id = prefs.getLong("id", 0);
    	String nombre = prefs.getString("nombreUser", "");
    	String email = prefs.getString("emailUser", "");
    	
    	UsuarioDTO usuarioADTO = getUsuarioDTO();
    	usuarioADTO.setId(id);
    	usuarioADTO.setNombre(nombre);
    	usuarioADTO.setEmail(email);
    	
    	return usuarioADTO;    	
	}
	
	public static void removeUsuarioAutenticado(Context context)
	{
		SharedPreferences prefs = context.getSharedPreferences(KEY_USER_PREFERENCE ,Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = prefs.edit();
		
		editor.clear();
		editor.commit();
	}
	
	protected static UsuarioDTO getUsuarioDTO()
	{
		if (usuarioDTO == null)
		{
			usuarioDTO = new UsuarioDTO();
		}
		return usuarioDTO;
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
