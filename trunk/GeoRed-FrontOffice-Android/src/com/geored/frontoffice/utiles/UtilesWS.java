package com.geored.frontoffice.utiles;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;


/**
 * Clase que contiene metodos y constantes para el transporte de los datos por los Web Services.
 * */

public class UtilesWS {

	public static final String NAMESPACE = "http://negocio.geored.com/";
	public static final String URL="http://10.0.2.2:8080/GeoRed-Business-EJB/UsuarioServiceImpl?wsdl";
	public static final String SOAP_ACTION ="";	
	
	/**
	 * Retorna el objeto a ser transportado.
	 * */
	public static SoapObject getSoapObject(String MethodName)
    {
        return new SoapObject(NAMESPACE, MethodName);
    }
	
	
	/**
	 * Retorna el sobre que transportara el objeto SoapObject por los webservices.
	 * */
    public static SoapSerializationEnvelope getEnvelope(SoapObject Soap)
    {
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet = false;
        envelope.setOutputSoapObject(Soap);
        return envelope;
    }
    
    
    /**
     * Metodo que hace el transporte de los datos por los webservices retornando la respuesta del servidor.
     * */
    public static SoapObject makeCall(SoapSerializationEnvelope envelope, String METHOD_NAME)
    {
    	HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
         try
            {
                androidHttpTransport.call(SOAP_ACTION, envelope);
                SoapObject response = (SoapObject) envelope.getResponse();
                return response;
            }
         catch(Exception e)
         {
             e.printStackTrace();
             
         }
         return null;
    }
}
