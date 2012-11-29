package com.geored.frontoffice.wsclient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.geored.dto.SitioDTO;
import com.geored.frontoffice.utiles.UtilesAndorid;

public class SitioWS 
{
	public Long insertar(SitioDTO sitioDTO)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sitioDTO", sitioDTO);
		
		return (Long) WSProxyClient.call(UtilesAndorid.URL_WS_SITIO, "insertar", params, Long.class);
	}
	
	public void actualizar(SitioDTO sitioDTO)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sitioDTO", sitioDTO);
		
    	WSProxyClient.call(UtilesAndorid.URL_WS_SITIO, "actualizar", params, null);		
	}
	
	public void eliminar(Long idSitio)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idSitio", idSitio);
		
    	WSProxyClient.call(UtilesAndorid.URL_WS_SITIO, "eliminar", params, null);			
	}
	
	public SitioDTO obtener(Long idSitio)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idSitio", idSitio);
		
		return (SitioDTO) WSProxyClient.call(UtilesAndorid.URL_WS_SITIO, "obtener", params, SitioDTO.class);
	}
	
	public List<SitioDTO> obtenerListado()
	{
		return (List<SitioDTO>) WSProxyClient.call(UtilesAndorid.URL_WS_SITIO, "obtenerListado", null, List.class);
	}
}
