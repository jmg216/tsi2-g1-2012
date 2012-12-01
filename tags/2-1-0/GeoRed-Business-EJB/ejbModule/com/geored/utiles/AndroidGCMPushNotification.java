package com.geored.utiles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.geored.exceptions.NegocioException;
import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Sender;

public class AndroidGCMPushNotification
{
	
	/**
	 * Metodo utilizado para enviar las notificaciones al cliente. 
	 * collapsKey: utilizada para acumular los mensajes en cola con igual collapseKey.
	 * por parametros.
	 * @throws NegocioException 
	 * @throws IOException 
	 * */
	public static boolean enviarNotificaciones(String collapseKey, String registrationId, String message) throws NegocioException
	{
			//Lista de los ids de los dispositvos a los cuales se le van a enviar los mensajes.
			List<String> androidTargets = new ArrayList<String>();
			androidTargets.add(registrationId);
			
			//Instancia de com.android.gcm.server.Sender que realiza la transmision
			//de los mensajes a Google Cloud Messaging Service.
			//Se le pasa el API KEY obtenido de code.google.com
	        Sender sender = new Sender(UtilesNegocio.API_KEY_GCM);
	        
	        // Mensaje que contiene los datos que seran transmitidos.
	        Message message1 = new Message.Builder()

		        .collapseKey(collapseKey)
		        .timeToLive(30)
		        .delayWhileIdle(true)
		        .addData("message", message)
		        .build();
	        
	        try 
	        {
	            //Envia los mensajes a todos los dispositivos identificados por su id
	        	//generados al momento de activar las notificaciones.
	        	MulticastResult result = sender.send(message1, androidTargets, 1);
	             
	            if (result.getResults() != null) 
	            {
	                int canonicalRegId = result.getCanonicalIds();
	                if (canonicalRegId != 0) 
	                {
	                     
	                }
	            } 
	            else 
	            {
	                int error = result.getFailure();
	                System.out.println("Broadcast failure: " + error);
	            }
	             
	        } 
	        catch (Exception e) 
	        {
	            e.printStackTrace();
	        }	        
	        return true;
	}
}
