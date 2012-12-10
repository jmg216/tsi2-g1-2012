package com.geored.frontoffice.wsclient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.geored.dto.SitioDTO;
import com.geored.frontoffice.utiles.UtilesAndroid;

public class SitioWS 
{
	public Long insertar(SitioDTO sitioDTO)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sitioDTO", sitioDTO);
		
		return (Long) WSProxyClient.call(UtilesAndroid.URL_WS_SITIO, "insertar", params, Long.class, null);
	}
	
	public void actualizar(SitioDTO sitioDTO)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sitioDTO", sitioDTO);
		
    	WSProxyClient.call(UtilesAndroid.URL_WS_SITIO, "actualizar", params, null, null);		
	}
	
	public void eliminar(Long idSitio)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idSitio", idSitio);
		
    	WSProxyClient.call(UtilesAndroid.URL_WS_SITIO, "eliminar", params, null, null);			
	}
	
	public SitioDTO obtener(Long idSitio)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idSitio", idSitio);
		
		return (SitioDTO) WSProxyClient.call(UtilesAndroid.URL_WS_SITIO, "obtener", params, SitioDTO.class, null);
	}
	
	public List<SitioDTO> obtenerListado()
	{
		return (List<SitioDTO>) WSProxyClient.call(UtilesAndroid.URL_WS_SITIO, "obtenerListado", null, List.class, SitioDTO.class);
	}
}
