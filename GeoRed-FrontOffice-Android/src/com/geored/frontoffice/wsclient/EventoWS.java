package com.geored.frontoffice.wsclient;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

import com.geored.frontoffice.dto.EventoADTO;
import com.geored.frontoffice.utiles.UtilesAndorid;

public class EventoWS 
{

	public Long insertar(EventoADTO eventoADTO)
	{
		String wsdlMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
		SoapPrimitive response = (SoapPrimitive) WSProxyClient.call(UtilesAndorid.URL_WS_EVENTO, wsdlMethodName, eventoADTO);
    	
		return Long.valueOf(response.toString());
	}
	
	public void actualizar(EventoADTO eventoADTO)
	{
		String wsdlMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
    	WSProxyClient.call(UtilesAndorid.URL_WS_EVENTO, wsdlMethodName, eventoADTO);		
	}
	
	public void eliminar(Long idEvento)
	{
		String wsdlMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
    	WSProxyClient.call(UtilesAndorid.URL_WS_EVENTO, wsdlMethodName, idEvento);			
	}
	
	public EventoADTO obtener(Long idEvento)
	{
		String wsdlMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
		SoapObject response = (SoapObject) WSProxyClient.call(UtilesAndorid.URL_WS_EVENTO, wsdlMethodName, idEvento);
		
		EventoADTO eventoADTO = new EventoADTO();
		
		if (response == null)
		{
			return null;
		}
		else
		{
			//TODO ver orden de las properies
			
        	eventoADTO.setDescripcion(response.getProperty(0).toString());
        	eventoADTO.setId(Long.parseLong(response.getProperty(1).toString()));
        	eventoADTO.setUbicacionGeografica(response.getProperty(2).toString());
        	eventoADTO.setNombre(response.getProperty(3).toString());
        	
        	// TODO eventoADTO.setFechaFin(fechaFin)
        	// TODO eventoADTO.setFechaInicio(fechaInicio)
        	// TODO ver como carajo parsear la fecha
		}
		
		return eventoADTO;
	}
	
	public List<EventoADTO> obtenerListado()
	{
		String wsdlMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
		Vector  response = (Vector) WSProxyClient.call(UtilesAndorid.URL_WS_EVENTO, wsdlMethodName);
				
		EventoADTO[] eventosADTO = new EventoADTO[response.size()];
		
		for (int i = 0; i < eventosADTO.length; i++) 
		{
			SoapObject info = (SoapObject) response.get(i);
			
			EventoADTO evento = new EventoADTO();
			
			//TODO ver orden de las properies
        	evento.setDescripcion(info.getProperty(0).toString());
        	evento.setId(Long.parseLong(info.getProperty(1).toString()));
        	evento.setUbicacionGeografica(info.getProperty(2).toString());
        	evento.setNombre(info.getProperty(3).toString());
        	
        	// TODO eventoADTO.setFechaFin(fechaFin)
        	// TODO eventoADTO.setFechaInicio(fechaInicio)
        	// TODO ver como carajo parsear la fecha
        	
            eventosADTO[i] = evento;			
		}
		
		List<EventoADTO> listaEventos = Arrays.asList(eventosADTO);
		
		return listaEventos;
	}	
}
