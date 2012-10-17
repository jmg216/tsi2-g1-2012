package com.geored.frontoffice.wsclient;

import java.util.List;

import org.ksoap2.serialization.SoapObject;
import com.geored.frontoffice.dto.UsuarioDTO;

public class UsuarioWS
{
	public Long insertar(UsuarioDTO usuarioDTO)
	{
		String wsdlMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		
    	SoapObject response = WSProxyClient.call(wsdlMethodName, usuarioDTO);
    	
		return Long.valueOf(response.toString());
	}
	
	public void actualizar(UsuarioDTO usuarioDTO)
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