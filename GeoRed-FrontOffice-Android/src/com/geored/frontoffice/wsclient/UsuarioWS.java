package com.geored.frontoffice.wsclient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.geored.dto.MensajeAmistadDTO;
import com.geored.dto.UsuarioDTO;
import com.geored.frontoffice.utiles.UtilesAndorid;

public class UsuarioWS
{
	public Long insertar(UsuarioDTO usuarioDTO)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("usuarioDTO", usuarioDTO);
		
		return (Long) WSProxyClient.call(UtilesAndorid.URL_WS_USUARIO, "insertar", params, Long.class, null);
	}
	
	public void actualizar(UsuarioDTO usuarioDTO)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("usuarioDTO", usuarioDTO);
		
    	WSProxyClient.call(UtilesAndorid.URL_WS_USUARIO, "actualizar", params, null, null);		
	}
	
	public void eliminar(Long idUsuario)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idUsuario", idUsuario);
			
		WSProxyClient.call(UtilesAndorid.URL_WS_USUARIO, "eliminar", params, null, null);
	}
	
	public UsuarioDTO obtener(Long idUsuario)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idUsuario", idUsuario);
		
		return (UsuarioDTO) WSProxyClient.call(UtilesAndorid.URL_WS_USUARIO, "obtener", params, UsuarioDTO.class, null);
	}
	
	public List<UsuarioDTO> obtenerListado()
	{		
		return (List<UsuarioDTO>) WSProxyClient.call(UtilesAndorid.URL_WS_USUARIO, "obtenerListado", null, List.class, UsuarioDTO.class);
	}
	
	public UsuarioDTO obtenerPorEmailYPass(String email, String pass)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("email", email);
		params.put("pass", pass);
		
		return (UsuarioDTO) WSProxyClient.call(UtilesAndorid.URL_WS_USUARIO, "obtenerPorEmailYPass", params, UsuarioDTO.class, null);

	}
	
	public Long enviarMensajeChat(MensajeAmistadDTO mensajeAmistadDTO)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("mensajeAmistadDTO", mensajeAmistadDTO);
		
    	return (Long) WSProxyClient.call(UtilesAndorid.URL_WS_USUARIO, "enviarMensajeChat", params, null, null);			
	}
	
	public List<UsuarioDTO> obtenerListadoAmigos(Long idUsuario, boolean soloConectados) 
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idUsuario", idUsuario);
		params.put("soloConectados", soloConectados);
		
		return (List<UsuarioDTO>) WSProxyClient.call(UtilesAndorid.URL_WS_USUARIO, "obtenerListadoAmigos", params, List.class, UsuarioDTO.class);
	}
}