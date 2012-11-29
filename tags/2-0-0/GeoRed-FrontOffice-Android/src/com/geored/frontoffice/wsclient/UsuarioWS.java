package com.geored.frontoffice.wsclient;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.ksoap2.serialization.SoapObject;

import com.geored.dto.UsuarioDTO;
import com.geored.frontoffice.utiles.UtilesAndorid;

public class UsuarioWS
{
	public Long insertar(UsuarioDTO usuarioDTO)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("usuarioDTO", usuarioDTO);
		
		return (Long) WSProxyClient.call(UtilesAndorid.URL_WS_USUARIO, "insertar", params, Long.class);
	}
	
	public void actualizar(UsuarioDTO usuarioDTO)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("usuarioDTO", usuarioDTO);
		
    	WSProxyClient.call(UtilesAndorid.URL_WS_USUARIO, "actualizar", params, null);		
	}
	
	public void eliminar(Long idUsuario)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idUsuario", idUsuario);
			
		WSProxyClient.call(UtilesAndorid.URL_WS_USUARIO, "eliminar", params, null);
	}
	
	public UsuarioDTO obtener(Long idUsuario)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idUsuario", idUsuario);
		
		return (UsuarioDTO) WSProxyClient.call(UtilesAndorid.URL_WS_USUARIO, "obtener", params, UsuarioDTO.class);
	}
	
	public List<UsuarioDTO> obtenerListado()
	{		
		return (List<UsuarioDTO>) WSProxyClient.call(UtilesAndorid.URL_WS_USUARIO, "obtenerListado", null, List.class);
	}
	
	public UsuarioDTO obtenerPorEmailYPass(String email, String pass)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("email", email);
		params.put("pass", pass);
		
		return (UsuarioDTO) WSProxyClient.call(UtilesAndorid.URL_WS_USUARIO, "obtenerPorEmailYPass", params, UsuarioDTO.class);

	}
}