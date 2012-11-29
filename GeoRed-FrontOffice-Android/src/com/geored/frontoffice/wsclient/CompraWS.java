package com.geored.frontoffice.wsclient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.geored.dto.CompraDTO;
import com.geored.frontoffice.utiles.UtilesAndorid;

public class CompraWS
{
	public Long insertar(CompraDTO compraDTO)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("compraDTO", compraDTO);
		
		return (Long) WSProxyClient.call(UtilesAndorid.URL_WS_COMPRA, "insertar", params, Long.class);
	}
	
	public void actualizar(CompraDTO compraDTO)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("compraDTO", compraDTO);
		
    	WSProxyClient.call(UtilesAndorid.URL_WS_COMPRA, "actualizar", params, null);		
	}
	
	public void eliminar(Long idCompra)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idCompra", idCompra);
		
    	WSProxyClient.call(UtilesAndorid.URL_WS_COMPRA, "eliminar", params, null);			
	}
	
	public CompraDTO obtener(Long idCompra)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idCompra", idCompra);
		
		return (CompraDTO) WSProxyClient.call(UtilesAndorid.URL_WS_COMPRA, "obtener", params, CompraDTO.class);
	}
	
	public List<CompraDTO> obtenerListado()
	{
		return (List<CompraDTO>) WSProxyClient.call(UtilesAndorid.URL_WS_COMPRA, "obtenerListado", null, List.class);
	}
}
