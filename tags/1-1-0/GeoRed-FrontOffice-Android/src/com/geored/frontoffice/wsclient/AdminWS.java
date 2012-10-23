package com.geored.frontoffice.wsclient;

import java.util.List;

import org.ksoap2.serialization.SoapObject;

import com.geored.frontoffice.dto.AdministradorADTO;

public class AdminWS
{
	public Long insertar(AdministradorADTO administradorADTO)
	{
		String wsdlMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
    	SoapObject response = WSProxyClient.call(wsdlMethodName, administradorADTO);
    	
		return Long.valueOf(response.toString());
	}
	
	public void actualizar(AdministradorADTO administradorADTO)
	{
		String wsdlMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
    	WSProxyClient.call(wsdlMethodName, administradorADTO);		
	}
	
	public void eliminar(Long idAdministrador)
	{
		String wsdlMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
    	WSProxyClient.call(wsdlMethodName, idAdministrador);		
	}
	
	public AdministradorADTO obtener(Long idAdministrador)
	{
		return null;
	}
	
	public List<AdministradorADTO> obtenerListado()
	{
		return null;
	}	
}