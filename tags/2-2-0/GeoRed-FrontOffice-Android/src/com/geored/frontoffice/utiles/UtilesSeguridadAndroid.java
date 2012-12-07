package com.geored.frontoffice.utiles;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.geored.dto.UsuarioDTO;

public class UtilesSeguridadAndroid{
	
	private static final String KEY_USER_PREFERENCE = "UserPreference";
	public static final String API_KEY = "AIzaSyA-sjjWHPR2JIHEipdGAFKH8rLcK25Od1A";
	public static final String ID_SENDER_GCM = "121239138891";
	
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
    	
    	UsuarioDTO usuarioADTO = new UsuarioDTO();
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
}
