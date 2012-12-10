package com.geored.frontoffice.wsclient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.geored.dto.OfertaDTO;
import com.geored.frontoffice.utiles.UtilesAndroid;

public class OfertaWS 
{
	public Long insertar(OfertaDTO ofertaDTO)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ofertaDTO", ofertaDTO);
		
		return (Long) WSProxyClient.call(UtilesAndroid.URL_WS_OFERTA, "insertar", params, Long.class, null);
	}
	
	public void actualizar(OfertaDTO ofertaDTO)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ofertaDTO", ofertaDTO);
		
    	WSProxyClient.call(UtilesAndroid.URL_WS_OFERTA, "actualizar", params, null, null);		
	}
	
	public void eliminar(Long idOferta)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idOferta", idOferta);
		
    	WSProxyClient.call(UtilesAndroid.URL_WS_OFERTA, "eliminar", params, null, null);			
	}
	
	public OfertaDTO obtener(Long idOferta)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idOferta", idOferta);
		
		return (OfertaDTO) WSProxyClient.call(UtilesAndroid.URL_WS_OFERTA, "obtener", params, OfertaDTO.class, null);
	}
	
	public List<OfertaDTO> obtenerListado()
	{
		return (List<OfertaDTO>) WSProxyClient.call(UtilesAndroid.URL_WS_OFERTA, "obtenerListado", null, List.class, OfertaDTO.class);
	}
}
