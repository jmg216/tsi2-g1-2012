package com.geored.frontoffice.wsclient;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

import com.geored.frontoffice.dto.UsuarioADTO;
import com.geored.frontoffice.utiles.UtilesAndorid;

public class UsuarioWS
{
	public Long insertar(UsuarioADTO usuarioADTO)
	{
		String wsdlMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
		SoapPrimitive response = (SoapPrimitive) WSProxyClient.call(UtilesAndorid.URL_WS_USUARIO, wsdlMethodName, usuarioADTO);
    	
		return Long.valueOf(response.toString());
	}
	
	public void actualizar(UsuarioADTO usuarioADTO)
	{
		String wsdlMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
    	WSProxyClient.call(UtilesAndorid.URL_WS_USUARIO, wsdlMethodName, usuarioADTO);		
	}
	
	public void eliminar(Long idUsuario)
	{
		String wsdlMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
		WSProxyClient.call(UtilesAndorid.URL_WS_USUARIO, wsdlMethodName, idUsuario);
	}
	
	public UsuarioADTO obtener(Long idUsuario)
	{
		String wsdlMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
		SoapObject response = (SoapObject) WSProxyClient.call(UtilesAndorid.URL_WS_USUARIO, wsdlMethodName, idUsuario);
		
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
	
	public List<UsuarioADTO> obtenerListado()
	{
		String wsdlMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
		Vector  response = (Vector) WSProxyClient.call(UtilesAndorid.URL_WS_USUARIO, wsdlMethodName);
				
		UsuarioADTO[] usuariosADTO = new UsuarioADTO[response.size()];
		
		for (int i = 0; i < usuariosADTO.length; i++) 
		{
			SoapObject info = (SoapObject) response.get(i);
			
			UsuarioADTO usuario = new UsuarioADTO();
			
        	usuario.setEmail(info.getProperty(0).toString());
        	usuario.setId(Long.parseLong(info.getProperty(1).toString()));
        	usuario.setNombre(info.getProperty(2).toString());
        	usuario.setPass(info.getProperty(3).toString()); 
        	
            usuariosADTO[i] = usuario;			
		}
		
		List<UsuarioADTO> listaUsuarios = Arrays.asList(usuariosADTO);
		
		return listaUsuarios;
		
	}
	
	public UsuarioADTO obtenerPorEmailYPass(String email, String pass)
	{
		String wsdlMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
    	SoapObject response = (SoapObject) WSProxyClient.call(UtilesAndorid.URL_WS_USUARIO, wsdlMethodName, email, pass);
    	
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