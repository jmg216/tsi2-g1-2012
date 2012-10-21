package com.geored.frontoffice.wsclient;

import java.util.List;

import org.ksoap2.serialization.SoapObject;

import com.geored.frontoffice.dto.EventoADTO;

public class EventoWS 
{

	public Long insertar(EventoADTO eventoADTO)
	{
		String wsdlMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
    	SoapObject response = WSProxyClient.call(wsdlMethodName, eventoADTO);
    	
		return Long.valueOf(response.toString());
	}
	
	public void actualizar(EventoADTO eventoADTO)
	{
		String wsdlMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
    	WSProxyClient.call(wsdlMethodName, eventoADTO);		
	}
	
	public void eliminar(Long idEvento)
	{
		String wsdlMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
    	WSProxyClient.call(wsdlMethodName, idEvento);			
	}
	
	public EventoADTO obtener(Long idEvento)
	{
		return null;
	}
	
	public List<EventoADTO> obtenerListado()
	{
		return null;
	}	
}
