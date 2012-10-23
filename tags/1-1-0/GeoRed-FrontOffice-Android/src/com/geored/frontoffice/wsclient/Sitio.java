package com.geored.frontoffice.wsclient;

import java.util.List;

import org.ksoap2.serialization.SoapObject;

import com.geored.frontoffice.dto.SitioADTO;

public class Sitio 
{

	public Long insertar(SitioADTO sitioADTO)
	{
		String wsdlMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
    	SoapObject response = WSProxyClient.call(wsdlMethodName, sitioADTO);
    	
		return Long.valueOf(response.toString());
	}
	
	public void actualizar(SitioADTO sitioADTO)
	{
		String wsdlMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
    	WSProxyClient.call(wsdlMethodName, sitioADTO);		
	}
	
	public void eliminar(Long idSitio)
	{
		String wsdlMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
    	WSProxyClient.call(wsdlMethodName, idSitio);			
	}
	
	public SitioADTO obtener(Long idSitio)
	{
		return null;
	}
	
	public List<SitioADTO> obtenerListado()
	{
		return null;
	}
}
