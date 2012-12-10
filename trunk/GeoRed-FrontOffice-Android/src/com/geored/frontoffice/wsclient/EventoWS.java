package com.geored.frontoffice.wsclient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.geored.dto.EventoDTO;
import com.geored.frontoffice.utiles.UtilesAndroid;

public class EventoWS 
{
	public Long insertar(EventoDTO eventoDTO)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("eventoDTO", eventoDTO);
		
		return (Long) WSProxyClient.call(UtilesAndroid.URL_WS_EVENTO, "insertar", params, Long.class, null);
	}
	
	public void actualizar(EventoDTO eventoDTO)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("eventoDTO", eventoDTO);
		
    	WSProxyClient.call(UtilesAndroid.URL_WS_EVENTO, "actualizar", params, null, null);		
	}
	
	public void eliminar(Long idEvento)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idEvento", idEvento);
		
    	WSProxyClient.call(UtilesAndroid.URL_WS_EVENTO, "eliminar", params, null, null);			
	}
	
	public EventoDTO obtener(Long idEvento)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idEvento", idEvento);
		
		return (EventoDTO) WSProxyClient.call(UtilesAndroid.URL_WS_EVENTO, "obtener", params, EventoDTO.class, null);
	}
	
	public List<EventoDTO> obtenerListado()
	{
		return (List<EventoDTO>) WSProxyClient.call(UtilesAndroid.URL_WS_EVENTO, "obtenerListado", null, List.class, EventoDTO.class);
	}
}
