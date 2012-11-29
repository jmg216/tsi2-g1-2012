package com.geored.frontoffice.wsclient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.geored.dto.EmpresaDTO;
import com.geored.frontoffice.utiles.UtilesAndorid;

public class EmpresaWS
{		
	public Long insertar(EmpresaDTO empresaDTO)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("empresaDTO", empresaDTO);
		
		return (Long) WSProxyClient.call(UtilesAndorid.URL_WS_EMPRESA, "insertar", params, Long.class);
	}
	
	public void actualizar(EmpresaDTO empresaDTO)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("empresaDTO", empresaDTO);
		
    	WSProxyClient.call(UtilesAndorid.URL_WS_EMPRESA, "actualizar", params, null);		
	}
	
	public void eliminar(Long idEmpresa)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idEmpresa", idEmpresa);
		
    	WSProxyClient.call(UtilesAndorid.URL_WS_EMPRESA, "eliminar", params, null);			
	}
	
	public EmpresaDTO obtener(Long idEmpresa)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idEmpresa", idEmpresa);
		
		return (EmpresaDTO) WSProxyClient.call(UtilesAndorid.URL_WS_EMPRESA, "obtener", params, EmpresaDTO.class);
	}
	
	public List<EmpresaDTO> obtenerListado()
	{
		return (List<EmpresaDTO>) WSProxyClient.call(UtilesAndorid.URL_WS_EMPRESA, "obtenerListado", null, List.class);
	}
}
