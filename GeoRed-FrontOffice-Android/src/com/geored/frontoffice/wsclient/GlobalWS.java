package com.geored.frontoffice.wsclient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.geored.dto.TematicaDTO;
import com.geored.dto.TipoNotificacionDTO;
import com.geored.dto.UsuarioDTO;
import com.geored.frontoffice.utiles.UtilesAndorid;

public class GlobalWS 
{
	public List<TematicaDTO> obtenerListadoTematicas()
	{
		return (List<TematicaDTO>) WSProxyClient.call(UtilesAndorid.URL_WS_GLOBAL, "obtenerListadoTematicas", null, List.class, TematicaDTO.class);
	}
	
	public TipoNotificacionDTO obtenerTipoNotificacionPorId(Long idTipoNotificacion)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idTipoNotificacion", idTipoNotificacion);
		
		return (TipoNotificacionDTO) WSProxyClient.call(UtilesAndorid.URL_WS_GLOBAL, "obtenerTipoNotificacionPorId", params, TipoNotificacionDTO.class, null);
	}
}
