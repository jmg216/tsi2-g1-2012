package com.geored.frontoffice.wsclient;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

import com.geored.frontoffice.dto.OfertaADTO;
import com.geored.frontoffice.utiles.UtilesAndorid;

public class OfertaWS 
{

	public Long insertar(OfertaADTO ofertaADTO)
	{
		String wsdlMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
		SoapPrimitive response = (SoapPrimitive) WSProxyClient.call(UtilesAndorid.URL_WS_OFERTA, wsdlMethodName, ofertaADTO);
    	
		return Long.valueOf(response.toString());
	}
	
	public void actualizar(OfertaADTO ofertaADTO)
	{
		String wsdlMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
    	WSProxyClient.call(UtilesAndorid.URL_WS_OFERTA, wsdlMethodName, ofertaADTO);
	}
	
	public void eliminar(Long idOferta)
	{
		String wsdlMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
    	WSProxyClient.call(UtilesAndorid.URL_WS_OFERTA, wsdlMethodName, idOferta);		
	}
	
	public OfertaADTO obtener(Long idOferta)
	{
		String wsdlMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
		SoapObject response = (SoapObject) WSProxyClient.call(UtilesAndorid.URL_WS_OFERTA, wsdlMethodName, idOferta);
		
		OfertaADTO ofertaADTO = new OfertaADTO();
		
		if (response == null)
		{
			return null;
		}
		else
		{
			//TODO ver orden de las properies
			
        	ofertaADTO.setDescripcion(response.getProperty(0).toString());
        	ofertaADTO.setId(Long.parseLong(response.getProperty(1).toString()));
        	ofertaADTO.setIdLocal(Long.parseLong(response.getProperty(2).toString()));
        	ofertaADTO.setNombre(response.getProperty(3).toString());
        	ofertaADTO.setNombreLocal(response.getProperty(4).toString());
        	ofertaADTO.setLogoUrl(response.getProperty(5).toString());
        	
        	// TODO ofertaADTO.setCosto(Double)
        	// TODO ofertaADTO.setFechaFin(fechaFin)
        	// TODO ofertaADTO.setFechaInicio(fechaInicio)
        	// TODO ver como carajo parsear la fecha y costo double
		}
		
		return ofertaADTO;
	}
	
	public List<OfertaADTO> obtenerListado()
	{
		String wsdlMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
		Vector  response = (Vector) WSProxyClient.call(UtilesAndorid.URL_WS_OFERTA, wsdlMethodName);
				
		OfertaADTO[] ofertasADTO = new OfertaADTO[response.size()];
		
		for (int i = 0; i < ofertasADTO.length; i++) 
		{
			SoapObject info = (SoapObject) response.get(i);
			
			OfertaADTO oferta = new OfertaADTO();
			
			//TODO ver orden de las properies
			
        	oferta.setDescripcion(info.getProperty(0).toString());
        	oferta.setId(Long.parseLong(info.getProperty(1).toString()));
        	oferta.setIdLocal(Long.parseLong(info.getProperty(2).toString()));
        	oferta.setNombre(info.getProperty(3).toString());
        	oferta.setNombreLocal(info.getProperty(4).toString());
        	oferta.setLogoUrl(info.getProperty(5).toString());
        	
        	// TODO ofertaADTO.setCosto(Double)
        	// TODO ofertaADTO.setFechaFin(fechaFin)
        	// TODO ofertaADTO.setFechaInicio(fechaInicio)
        	// TODO ver como carajo parsear la fecha y costo double
        	
            ofertasADTO[i] = oferta;			
		}
		
		List<OfertaADTO> listaOfertas = Arrays.asList(ofertasADTO);
		
		return listaOfertas;
	}
}
