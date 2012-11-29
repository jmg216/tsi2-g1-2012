package com.geored.frontoffice.wsclient;

import java.util.Map;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import com.google.gson.Gson;

/**
 * Clase que contiene metodos y constantes para el transporte de los datos por los Web Services.
 * */

public class WSProxyClient
{
	public static final String NAMESPACE = "http://negocio.geored.com/";
	public static final String SOAP_ACTION = "";	
	
	public static Object call(String url, String methodName, Object... params)
	{
		return null;
	}
	
	/**
     * Metodo que invoca los WebServices del Backend
     * */
    public static Object call(String urlWS, String methodName, Map<String, Object> params, Class<?> returnType)
    {
    	// RequestObject
    	SoapObject requestObject = new SoapObject(NAMESPACE, "androidInvocation");
    	
    	// Sobre
    	SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet = false;
        envelope.setOutputSoapObject(requestObject);
    	
    	// Creo el JSON de los params, si params == null envio ""        
    	Gson gson = new Gson();    
    	
    	String methodParams = "";    	
    	if(params != null)
    	{
    		methodParams = gson.toJson(params);
    	}
    	
    	// Properties del requestObject
    	PropertyInfo methodParamsProperty = new PropertyInfo();
    	methodParamsProperty.setName("methodParams");
    	methodParamsProperty.setValue(methodParams);
    	methodParamsProperty.setType(PropertyInfo.STRING_CLASS);
        requestObject.addProperty(methodParamsProperty);
        
        PropertyInfo methodNameProperty = new PropertyInfo();
    	methodNameProperty.setName("methodName");
    	methodNameProperty.setValue(methodName);
    	methodNameProperty.setType(PropertyInfo.STRING_CLASS);
        requestObject.addProperty(methodNameProperty);	 
    	
    	// Ejecuto la llamada
    	try
        {
    		HttpTransportSE androidHttpTransport = new HttpTransportSE(urlWS);
    		androidHttpTransport.debug = true;
    		androidHttpTransport.call(SOAP_ACTION, envelope);
    		
    		Object response = envelope.getResponse();    	
    		
    		if(response != null && response instanceof SoapPrimitive)
    		{
    			SoapPrimitive soapPrimitiveObject = (SoapPrimitive) response;
    			
    			if(returnType != null)
        		{    			
            		return gson.fromJson(soapPrimitiveObject.toString(), returnType);    		
        		}
    		}    		    		
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
    	
         return null;
    }
}
