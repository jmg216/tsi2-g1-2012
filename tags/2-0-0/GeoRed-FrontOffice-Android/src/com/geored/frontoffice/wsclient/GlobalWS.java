package com.geored.frontoffice.wsclient;

import java.util.List;

import com.geored.dto.TematicaDTO;
import com.geored.frontoffice.utiles.UtilesAndorid;

public class GlobalWS 
{
	public List<TematicaDTO> obtenerListadoTematicas()
	{
		return (List<TematicaDTO>) WSProxyClient.call(UtilesAndorid.URL_WS_GLOBAL, "obtenerListadoTematicas", null, List.class);
	}
}
