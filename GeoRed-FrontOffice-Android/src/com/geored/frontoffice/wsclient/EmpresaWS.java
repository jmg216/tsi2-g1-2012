package com.geored.frontoffice.wsclient;

import java.util.List;

import org.ksoap2.serialization.SoapObject;

import com.geored.frontoffice.dto.EmpresaADTO;

public class EmpresaWS
{		
	public Long insertar(EmpresaADTO empresaADTO)
	{
		String wsdlMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
    	SoapObject response = WSProxyClient.call(wsdlMethodName, empresaADTO);
    	
		return Long.valueOf(response.toString());
	}
	
	public void actualizar(EmpresaADTO empresaADTO)
	{
		String wsdlMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
    	WSProxyClient.call(wsdlMethodName, empresaADTO);		
	}
	
	public void eliminar(Long idEmpresa)
	{
		String wsdlMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
    	WSProxyClient.call(wsdlMethodName, idEmpresa);		
	}
	
	public EmpresaADTO obtener(Long idEmpresa)
	{
		return null;
	}
	
	public List<EmpresaADTO> obtenerListado()
	{
		return null;
	}
}
