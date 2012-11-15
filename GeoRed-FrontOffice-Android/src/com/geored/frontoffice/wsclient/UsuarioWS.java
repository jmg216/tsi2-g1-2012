package com.geored.frontoffice.wsclient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

import com.geored.frontoffice.dto.TematicaADTO;
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
			usuarioADTO.parseUsuarioADTO(response);
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

			usuario.parseUsuarioADTO(info);
        	
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
    	
    	usuarioADTO.parseUsuarioADTO(response);
    			
		return usuarioADTO;
	}
}