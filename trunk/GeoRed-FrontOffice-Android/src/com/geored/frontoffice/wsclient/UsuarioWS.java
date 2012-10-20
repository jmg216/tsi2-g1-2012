package com.geored.frontoffice.wsclient;

import java.util.List;

import org.ksoap2.serialization.SoapObject;

import com.geored.dto.UsuarioDTO;
import com.geored.frontoffice.dto.UsuarioADTO;

public class UsuarioWS
{
	public Long insertar(UsuarioADTO usuarioADTO)
	{
		String wsdlMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		
    	SoapObject response = WSProxyClient.call(wsdlMethodName, usuarioADTO);
    	
		return Long.valueOf(response.toString());
	}
	
	public void actualizar(UsuarioADTO usuarioADTO)
	{
		
	}
	
	public void eliminar(Long idUsuario)
	{
		
	}
	
	public UsuarioDTO obtener(Long idUsuario)
	{
		return null;
	}
	
	public List<UsuarioDTO> obtenerListado()
	{
		return null;
	}
}