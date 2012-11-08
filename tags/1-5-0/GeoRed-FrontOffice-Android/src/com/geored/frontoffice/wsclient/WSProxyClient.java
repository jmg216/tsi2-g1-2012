package com.geored.frontoffice.wsclient;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

/**
 * Clase que contiene metodos y constantes para el transporte de los datos por los Web Services.
 * */

public class WSProxyClient
{
	public static final String NAMESPACE = "http://negocio.geored.com/";
//	public static final String URL = "http://10.0.2.2:8080/GeoRed-Business-EJB/UsuarioServiceImpl?wsdl";
	public static final String SOAP_ACTION = "";	
	
	/**
     * Metodo que hace el transporte de los datos por los webservices retornando la respuesta del servidor.
     * */
    public static Object call(String url, String methodName, Object... params)
    {
    	// Objeto a ser transportado con el contenedor
    	SoapObject soapObject = new SoapObject(NAMESPACE, methodName);
    	
    	// Sobre del soapObject, indica como mapear el DTO local con el del WebService
    	SoapSerializationEnvelope envelope = getEnvelope(soapObject);
    	
    	// Seteo los parametros del soapObject y los mapeos del envelope
    	int argIndex = 0;
    	for(Object param : params)
    	{
    		Class paramClass = param.getClass();    
    		
    		if(isDTOClass(paramClass))
    		{
    			paramClass = paramClass.getSuperclass();
    		}
    		
    		// Nombre del objeto en el wsdl
        	String wsdlObjectName = paramClass.getSimpleName().substring(0, 1).toLowerCase() + 
        							paramClass.getSimpleName().substring(1);
        	
        	// Creo el contenedor del DTO
        	PropertyInfo usuarioInfo = new PropertyInfo();
        	usuarioInfo.setName("arg" + argIndex++);
        	usuarioInfo.setValue(param);
        	usuarioInfo.setType(paramClass);
        	
        	soapObject.addProperty(usuarioInfo);
        	
        	if(isDTOClass(paramClass))
        	{
        		envelope.addMapping(NAMESPACE, wsdlObjectName, paramClass);
        	}
    	}
    	
    	// Ejecuto la llamada
    	try
        {
    		HttpTransportSE androidHttpTransport = new HttpTransportSE(url);
    		androidHttpTransport.call(SOAP_ACTION, envelope);
    		
    		return envelope.getResponse();
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
         return null;
    }
	
	/**
	 * Retorna el sobre que transportara el objeto SoapObject por los webservices.
	 * */
    private static SoapSerializationEnvelope getEnvelope(SoapObject Soap)
    {
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet = false;
        envelope.setOutputSoapObject(Soap);
        return envelope;
    }
    
    /**
     * Indica si la clazz recibida como parametro es un DTO o no
     * 
     * @param clazz
     * @return
     */
    private static boolean isDTOClass(Class clazz)
    {
    	return clazz.getName().contains("DTO");
    }
}
