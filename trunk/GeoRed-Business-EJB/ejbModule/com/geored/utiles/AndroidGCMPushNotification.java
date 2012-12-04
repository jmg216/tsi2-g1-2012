package com.geored.utiles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.geored.dto.MensajeAmistadDTO;
import com.geored.exceptions.NegocioException;
import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;
import com.google.gson.Gson;

public class AndroidGCMPushNotification
{
	
	/**
	 * Metodo utilizado para enviar las notificaciones al cliente. 
	 * collapsKey: utilizada para acumular los mensajes en cola con igual collapseKey.
	 * por parametros.
	 * androidTargets: Lista de los ids de los dispositvos a los cuales se le van a enviar los mensajes. 
	 * @throws NegocioException 
	 * @throws IOException 
	 * */
	public static boolean enviarNotificaciones(String collapseKey, List<String> androidTargets, Long idRemitente, String message) throws NegocioException
	{			
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
	
	public static boolean enviarMensajeChatGCM (String collapseKey, String idRegGCM, MensajeAmistadDTO msjAmistadoDTO) throws NegocioException
	{			
			//Instancia de com.android.gcm.server.Sender que realiza la transmision
			//de los mensajes a Google Cloud Messaging Service.
			//Se le pasa el API KEY obtenido de code.google.com
	        Sender sender = new Sender(UtilesNegocio.API_KEY_GCM);
	        
	        String message = new Gson().toJson(msjAmistadoDTO);
	        
	        // Mensaje que contiene los datos que seran transmitidos.
	        Message message1 = new Message.Builder()

		        .collapseKey(collapseKey)
		        .timeToLive(30)
		        .delayWhileIdle(true)
		        .addData("message", message)
		        .build();
	        
	        try 
	        {
	            //Envia el mensaje al usuario identificado con idRegGCM.
	        	Result result = sender.send(message1, idRegGCM, 1);
	             

	        	String canonicalRegId = result.getCanonicalRegistrationId();
	            if (!canonicalRegId.isEmpty())
	            {
	                     
	            }	        
	            else 
	            {
	                String error = result.getErrorCodeName();
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
