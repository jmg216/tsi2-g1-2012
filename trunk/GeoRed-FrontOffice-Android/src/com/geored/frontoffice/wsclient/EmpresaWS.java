package com.geored.frontoffice.wsclient;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

import com.geored.frontoffice.dto.EmpresaADTO;

public class EmpresaWS
{		
	public Long insertar(EmpresaADTO empresaADTO)
	{
		String wsdlMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
		SoapPrimitive response = (SoapPrimitive) WSProxyClient.call(wsdlMethodName, empresaADTO);
    	
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
		String wsdlMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
		SoapObject response = (SoapObject) WSProxyClient.call(wsdlMethodName, idEmpresa);
		
		EmpresaADTO empresaADTO = new EmpresaADTO();
		
		if (response == null)
		{
			return null;
		}
		else
		{
			//TODO ver orden de las properies
			
        	empresaADTO.setDescripcion(response.getProperty(0).toString());
        	empresaADTO.setId(Long.parseLong(response.getProperty(1).toString()));
        	empresaADTO.setIdAministrador(Long.parseLong(response.getProperty(2).toString()));
        	empresaADTO.setLogoUrl(response.getProperty(3).toString());
        	empresaADTO.setNombre(response.getProperty(4).toString());
        	empresaADTO.setNombreAdministrador(response.getProperty(5).toString());
        	
        	//TODO  empresaADTO.setFechaCreacion(fechaCreacion) ver como carajo parsear la fecha
		}
		
		return empresaADTO;
	}
	
	public List<EmpresaADTO> obtenerListado()
	{
		String wsdlMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
		Vector  response = (Vector) WSProxyClient.call(wsdlMethodName);
				
		EmpresaADTO[] empresasADTO = new EmpresaADTO[response.size()];
		
		for (int i = 0; i < empresasADTO.length; i++) 
		{
			SoapObject info = (SoapObject) response.get(i);
			
			EmpresaADTO empresa = new EmpresaADTO();
			
			//TODO ver orden de las properies
			
        	empresa.setDescripcion(info.getProperty(0).toString());
        	empresa.setId(Long.parseLong(info.getProperty(1).toString()));
        	empresa.setIdAministrador(Long.parseLong(info.getProperty(2).toString()));
        	empresa.setLogoUrl(info.getProperty(3).toString());
        	empresa.setNombre(info.getProperty(4).toString());
        	
        	//TODO  empresaADTO.setFechaCreacion(fechaCreacion) ver como carajo parsear la fecha
        	
        	empresasADTO[i] = empresa;			
		}
		
		List<EmpresaADTO> listaEmpresas = Arrays.asList(empresasADTO);
		
		return listaEmpresas;
	}
}
