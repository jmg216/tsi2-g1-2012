package com.geored.frontoffice.wsclient;

import java.util.List;

import org.ksoap2.serialization.SoapObject;

import com.geored.frontoffice.dto.OfertaADTO;

public class OfertaWS 
{

	public Long insertar(OfertaADTO ofertaADTO)
	{
		String wsdlMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
    	SoapObject response = WSProxyClient.call(wsdlMethodName, ofertaADTO);
    	
		return Long.valueOf(response.toString());
	}
	
	public void actualizar(OfertaADTO ofertaADTO)
	{
		String wsdlMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
    	WSProxyClient.call(wsdlMethodName, ofertaADTO);
	}
	
	public void eliminar(Long idOferta)
	{
		String wsdlMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
    	WSProxyClient.call(wsdlMethodName, idOferta);		
	}
	
	public OfertaADTO obtener(Long idOferta)
	{
		return null;
	}
	
	public List<OfertaADTO> obtenerListado()
	{
		return null;
	}
}
