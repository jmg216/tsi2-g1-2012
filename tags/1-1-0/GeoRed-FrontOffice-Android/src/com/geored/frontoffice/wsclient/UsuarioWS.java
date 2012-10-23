package com.geored.frontoffice.wsclient;

import java.util.List;

import org.ksoap2.serialization.SoapObject;

import com.geored.frontoffice.dto.UsuarioADTO;

public class UsuarioWS
{
	public Long insertar(UsuarioADTO usuarioADTO)
	{
		String wsdlMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
    	SoapObject response = WSProxyClient.call(wsdlMethodName, usuarioADTO);
    	
		return Long.valueOf(response.toString());
	}
	
	public void actualizar(UsuarioADTO usuarioADTO)
	{
		String wsdlMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
    	WSProxyClient.call(wsdlMethodName, usuarioADTO);		
	}
	
	public void eliminar(Long idUsuario)
	{
		
	}
	
	public UsuarioADTO obtener(Long idUsuario)
	{
		return null;
	}
	
	public List<UsuarioADTO> obtenerListado()
	{
		return null;
	}
	
	public UsuarioADTO obtenerPorEmailYPass(String email, String pass)
	{
		String wsdlMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
    	SoapObject response = WSProxyClient.call(wsdlMethodName, email, pass);
    	
    	UsuarioADTO usuarioADTO = new UsuarioADTO();
    	
    	if (response == null)
    	{
    		return null;
    	}
    	else
    	{        	
        	usuarioADTO.setEmail((response.getProperty(0).toString()));
        	usuarioADTO.setId(Long.parseLong(response.getProperty(1).toString()));
        	usuarioADTO.setNombre(response.getProperty(2).toString());
        	usuarioADTO.setPass(response.getProperty(3).toString());   	
    	}	
    			
		return usuarioADTO;
	}
}