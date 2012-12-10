package com.geored.frontoffice.wsclient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.geored.dto.CompraDTO;
import com.geored.frontoffice.utiles.UtilesAndroid;

public class CompraWS
{
	public Long insertar(CompraDTO compraDTO)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("compraDTO", compraDTO);
		
		return (Long) WSProxyClient.call(UtilesAndroid.URL_WS_COMPRA, "insertar", params, Long.class, null);
	}
	
	public void actualizar(CompraDTO compraDTO)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("compraDTO", compraDTO);
		
    	WSProxyClient.call(UtilesAndroid.URL_WS_COMPRA, "actualizar", params, null, null);		
	}
	
	public void eliminar(Long idCompra)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idCompra", idCompra);
		
    	WSProxyClient.call(UtilesAndroid.URL_WS_COMPRA, "eliminar", params, null, null);			
	}
	
	public CompraDTO obtener(Long idCompra)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idCompra", idCompra);
		
		return (CompraDTO) WSProxyClient.call(UtilesAndroid.URL_WS_COMPRA, "obtener", params, CompraDTO.class, null);
	}
	
	public List<CompraDTO> obtenerListado()
	{
		return (List<CompraDTO>) WSProxyClient.call(UtilesAndroid.URL_WS_COMPRA, "obtenerListado", null, List.class, CompraDTO.class);
	}
}
