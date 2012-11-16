package com.geored.frontoffice.wsclient;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

import com.geored.frontoffice.dto.SitioADTO;
import com.geored.frontoffice.utiles.UtilesAndorid;

public class SitioWS 
{

	public Long insertar(SitioADTO sitioADTO)
	{
		String wsdlMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
		SoapPrimitive response = (SoapPrimitive) WSProxyClient.call(UtilesAndorid.URL_WS_SITIO, wsdlMethodName, sitioADTO);
    	
		return Long.valueOf(response.toString());
	}
	
	public void actualizar(SitioADTO sitioADTO)
	{
		String wsdlMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
    	WSProxyClient.call(UtilesAndorid.URL_WS_SITIO, wsdlMethodName, sitioADTO);		
	}
	
	public void eliminar(Long idSitio)
	{
		String wsdlMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
    	WSProxyClient.call(UtilesAndorid.URL_WS_SITIO, wsdlMethodName, idSitio);			
	}
	
	public SitioADTO obtener(Long idSitio)
	{
		String wsdlMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
		SoapObject response = (SoapObject) WSProxyClient.call(UtilesAndorid.URL_WS_SITIO, wsdlMethodName, idSitio);
		
		SitioADTO sitioADTO = new SitioADTO();
		
		sitioADTO.parseSitioADTO(response);
		
		return sitioADTO;
	}
	
	public List<SitioADTO> obtenerListado()
	{
		String wsdlMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
		Vector  response = (Vector) WSProxyClient.call(UtilesAndorid.URL_WS_SITIO, wsdlMethodName);
				
		SitioADTO[] sitiosADTO = new SitioADTO[response.size()];
		
		for (int i = 0; i < sitiosADTO.length; i++) 
		{
			SoapObject info = (SoapObject) response.get(i);
			
			SitioADTO sitio = new SitioADTO();
			
			sitio.parseSitioADTO(info);
			
            sitiosADTO[i] = sitio;			
		}
		
		List<SitioADTO> listaSitios = Arrays.asList(sitiosADTO);
		
		return listaSitios;
	}
}
