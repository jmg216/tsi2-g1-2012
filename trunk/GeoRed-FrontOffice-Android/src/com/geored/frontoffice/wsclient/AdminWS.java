package com.geored.frontoffice.wsclient;

import java.util.List;

import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

import com.geored.frontoffice.dto.AdministradorADTO;
import com.geored.frontoffice.utiles.UtilesAndorid;

public class AdminWS
{
	public Long insertar(AdministradorADTO administradorADTO)
	{
		String wsdlMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
		SoapPrimitive response = (SoapPrimitive) WSProxyClient.call(UtilesAndorid.URL_WS_ADMIN, wsdlMethodName, administradorADTO);
    	
		return Long.valueOf(response.toString());
	}
	
	public void actualizar(AdministradorADTO administradorADTO)
	{
		String wsdlMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
    	WSProxyClient.call(UtilesAndorid.URL_WS_ADMIN, wsdlMethodName, administradorADTO);		
	}
	
	public void eliminar(Long idAdministrador)
	{
		String wsdlMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
    	WSProxyClient.call(UtilesAndorid.URL_WS_ADMIN, wsdlMethodName, idAdministrador);		
	}
	
	public AdministradorADTO obtener(Long idAdministrador)
	{
		String wsdlMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
		SoapObject response = (SoapObject) WSProxyClient.call(UtilesAndorid.URL_WS_ADMIN, wsdlMethodName, idAdministrador);
		
		AdministradorADTO administradorADTO = new AdministradorADTO();
		
		if (response == null)
		{
			return null;
		}
		else
		{
        	administradorADTO.setEmail((response.getProperty(0).toString()));
        	administradorADTO.setId(Long.parseLong(response.getProperty(1).toString()));
        	administradorADTO.setNombre(response.getProperty(2).toString());
        	administradorADTO.setPass(response.getProperty(3).toString());   
		}
		
		return administradorADTO;
	}
	
	public List<AdministradorADTO> obtenerListado()
	{
		return null;
	}	
}