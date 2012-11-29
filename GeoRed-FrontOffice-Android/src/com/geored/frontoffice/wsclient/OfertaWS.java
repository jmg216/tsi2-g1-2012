package com.geored.frontoffice.wsclient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.geored.dto.OfertaDTO;
import com.geored.frontoffice.utiles.UtilesAndorid;

public class OfertaWS 
{
	public Long insertar(OfertaDTO ofertaDTO)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ofertaDTO", ofertaDTO);
		
		return (Long) WSProxyClient.call(UtilesAndorid.URL_WS_OFERTA, "insertar", params, Long.class);
	}
	
	public void actualizar(OfertaDTO ofertaDTO)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ofertaDTO", ofertaDTO);
		
    	WSProxyClient.call(UtilesAndorid.URL_WS_OFERTA, "actualizar", params, null);		
	}
	
	public void eliminar(Long idOferta)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idOferta", idOferta);
		
    	WSProxyClient.call(UtilesAndorid.URL_WS_OFERTA, "eliminar", params, null);			
	}
	
	public OfertaDTO obtener(Long idOferta)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idOferta", idOferta);
		
		return (OfertaDTO) WSProxyClient.call(UtilesAndorid.URL_WS_OFERTA, "obtener", params, OfertaDTO.class);
	}
	
	public List<OfertaDTO> obtenerListado()
	{
		return (List<OfertaDTO>) WSProxyClient.call(UtilesAndorid.URL_WS_OFERTA, "obtenerListado", null, List.class);
	}
}
