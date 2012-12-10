package com.geored.frontoffice.wsclient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.geored.dto.AdministradorDTO;
import com.geored.frontoffice.utiles.UtilesAndroid;

public class AdminWS
{
	public Long insertar(AdministradorDTO administradorDTO)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("administradorDTO", administradorDTO);
		
		return (Long) WSProxyClient.call(UtilesAndroid.URL_WS_ADMIN, "insertar", params, Long.class, null);
	}
	
	public void actualizar(AdministradorDTO administradorDTO)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("administradorDTO", administradorDTO);
		
    	WSProxyClient.call(UtilesAndroid.URL_WS_ADMIN, "actualizar", params, null, null);		
	}
	
	public void eliminar(Long idAdministrador)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idAdministrador", idAdministrador);
		
    	WSProxyClient.call(UtilesAndroid.URL_WS_ADMIN, "eliminar", params, null, null);			
	}
	
	public AdministradorDTO obtener(Long idAdministrador)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idAdministrador", idAdministrador);
		
		return (AdministradorDTO) WSProxyClient.call(UtilesAndroid.URL_WS_ADMIN, "obtener", params, AdministradorDTO.class, null);
	}
	
	public List<AdministradorDTO> obtenerListado()
	{
		return (List<AdministradorDTO>) WSProxyClient.call(UtilesAndroid.URL_WS_ADMIN, "obtenerListado", null, List.class, AdministradorDTO.class);
	}
}