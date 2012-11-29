package com.geored.frontoffice.wsclient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.geored.dto.AdministradorDTO;
import com.geored.frontoffice.utiles.UtilesAndorid;

public class AdminWS
{
	public Long insertar(AdministradorDTO administradorDTO)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("administradorDTO", administradorDTO);
		
		return (Long) WSProxyClient.call(UtilesAndorid.URL_WS_ADMIN, "insertar", params, Long.class);
	}
	
	public void actualizar(AdministradorDTO administradorDTO)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("administradorDTO", administradorDTO);
		
    	WSProxyClient.call(UtilesAndorid.URL_WS_ADMIN, "actualizar", params, null);		
	}
	
	public void eliminar(Long idAdministrador)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idAdministrador", idAdministrador);
		
    	WSProxyClient.call(UtilesAndorid.URL_WS_ADMIN, "eliminar", params, null);			
	}
	
	public AdministradorDTO obtener(Long idAdministrador)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idAdministrador", idAdministrador);
		
		return (AdministradorDTO) WSProxyClient.call(UtilesAndorid.URL_WS_ADMIN, "obtener", params, AdministradorDTO.class);
	}
	
	public List<AdministradorDTO> obtenerListado()
	{
		return (List<AdministradorDTO>) WSProxyClient.call(UtilesAndorid.URL_WS_ADMIN, "obtenerListado", null, List.class);
	}
}