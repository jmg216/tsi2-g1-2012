package com.geored.frontoffice.wsclient;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import org.ksoap2.serialization.SoapObject;

import com.geored.frontoffice.dto.TematicaADTO;
import com.geored.frontoffice.utiles.UtilesAndorid;

public class GlobalWS {

	public List<TematicaADTO> obtenerListadoTematicas()
	{
		String wsdlMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
		Vector  response = (Vector) WSProxyClient.call(UtilesAndorid.URL_WS_GLOBAL, wsdlMethodName);

		TematicaADTO[] tematicaADTO = new TematicaADTO[response.size()];

		for (int i = 0; i < tematicaADTO.length; i++) 
		{	
			SoapObject info = (SoapObject) response.get(i);
			
			TematicaADTO tematica = new TematicaADTO();

			tematica.parseTematicaADTO(info);
        	
            tematicaADTO[i] = tematica;			
		}
		
		List<TematicaADTO> listaTematica = Arrays.asList(tematicaADTO);
		
		return listaTematica;		
	}	
}
