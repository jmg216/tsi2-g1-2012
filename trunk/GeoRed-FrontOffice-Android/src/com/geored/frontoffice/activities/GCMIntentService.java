package com.geored.frontoffice.activities;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

import com.geored.dto.MensajeAmistadDTO;
import com.geored.dto.NotificacionDTO;
import com.geored.dto.UsuarioDTO;
import com.geored.frontoffice.utiles.UtilesAndroid;
import com.geored.frontoffice.utiles.UtilesSeguridadAndroid;
import com.geored.frontoffice.wsclient.FactoryWS;
import com.geored.frontoffice.wsclient.UsuarioWS;
import com.geored.utiles.ConstantesGenerales;
import com.google.android.gcm.GCMBaseIntentService;
import com.google.android.gcm.GCMRegistrar;
import com.google.gson.Gson;

public class GCMIntentService extends GCMBaseIntentService
{
	private UsuarioWS usuarioWS = FactoryWS.getInstancia().getUsuarioWS();	
	
	private static final String TAG = "GCMIntentServiceGeored";
	
	public GCMIntentService() 
	{		
		super(UtilesSeguridadAndroid.ID_SENDER_GCM);
		Log.d("GCM_Red", UtilesSeguridadAndroid.ID_SENDER_GCM);
	}

	public static String obtenerGCMRegID(Context context)
	{
		if (checkIsGCMServiceAvailable(context)) 
        {                    
	        return GCMRegistrar.getRegistrationId(context);
        }
		
		return "";
	}
	
	/**
	 * Metodo para registrar la aplicacion en GCM.
	 * */
    public static void registerGCMService(Context context) 
    {
        if (checkIsGCMServiceAvailable(context)) 
        {                    
	        final String regId = GCMRegistrar.getRegistrationId(context);
	        
	        //Si el usuario no esta registrado
	        if (regId.equals("")) 
	        {
	            try 
	            {
	                GCMRegistrar.register(context, UtilesSeguridadAndroid.ID_SENDER_GCM);
	                Log.v(TAG, "Registrando...");
	            }
	            catch (Exception ex) 
	            {
	            	Log.v(TAG, "Error al registrar.");
	            }
	        }
	        else 
	        {
	        	Log.v(TAG, "Usuario ya registrado.");
	        }	        
        }
        else
        {
        	Log.v(TAG, "Error al verificar dispositivo y aplicacion");
        }

    }
    
    /**
     * Metodo invacado al momento de desregistrar un usuario del servicio GCM de notificaciones.
     * */
    public static void desregistrarGCMService(Context context)
    {
    	if (checkIsGCMServiceAvailable(context))
    	{
    		try 
    		{
    			GCMRegistrar.unregister(context);
    			Log.v(TAG, "Desregistrando...");
			} 
    		catch (Exception e) 
    		{
    			Log.v(TAG, "Error al desregistrar");
			}
    			
    	}
    	else
    	{
    		Log.v(TAG, "Error al verificar dispositivo y aplicacion");
    	}
    	
    }    

    /**
     * Verifica que los el dispositivo y la aplicacion esten preparadas para el utilizar
     * los servicios de GCM
     * */
    public static boolean checkIsGCMServiceAvailable(Context context)
    {
        try 
        {
            GCMRegistrar.checkDevice(context);
            GCMRegistrar.checkManifest(context);
            return true;
        } 
        catch (Throwable th) 
        {
            return false;
        }
    }
    
	
	/**
	 * Respuesta de error a una peticion de registro.
	 */
	@Override
	protected void onError(Context context, String errorId) 
	{
		Log.d(TAG, "REGISTRATION: Error -> " + errorId);
	}

	/**
	 * Se llamará cada vez que se reciba un nuevo mensaje desde el servidor de GCM.
	 * El contenido del mensaje se recibe en forma de intent 
	 */
	@Override
	protected void onMessage(Context context, Intent intent) 
	{
		 String msg = intent.getExtras().getString("message");
		 
		 String gsonMessage = msg.substring(1);
		 String codigoTipo = msg.substring(0, 1);
		 
		 Gson gson = new Gson();  
		 
		 if (codigoTipo.equals(ConstantesGenerales.TiposCodigoMensaje.CHAT))
		 {
			 MensajeAmistadDTO mensajeAmistadDTO = gson.fromJson(gsonMessage, MensajeAmistadDTO.class);
			 
			 handleGCMIntentMensajeAmistad(context, mensajeAmistadDTO);
		 }		 
		 else if (codigoTipo.equals(ConstantesGenerales.TiposCodigoMensaje.NOTIFICACION))
		 {
			 NotificacionDTO notificacionDTO = gson.fromJson(gsonMessage, NotificacionDTO.class);
			 
			 handleGCMIntentNotificacion(context, notificacionDTO);
		 }		 		
	}
	
    private void handleGCMIntentNotificacion(Context ctx, NotificacionDTO notificacionDTO) 
    {       
    	// Verifico si estoy cerca de la notificacion
    	if(notificacionDTO.getIdTipoNotificacion().equals(ConstantesGenerales.TiposNotificacion.ID_NUEVA_OFERTA) || 
    	   notificacionDTO.getIdTipoNotificacion().equals(ConstantesGenerales.TiposNotificacion.ID_NUEVO_EVENTO) || 
    	   notificacionDTO.getIdTipoNotificacion().equals(ConstantesGenerales.TiposNotificacion.ID_NUEVO_SITIO) ||
    	   notificacionDTO.getIdTipoNotificacion().equals(ConstantesGenerales.TiposNotificacion.ID_CHECKIN_AMIGO))
    	{
    		String[] splitUbicacionNotificacion = notificacionDTO.getMetadataNotif().split(";")[1].split(",");
    		
    		Location ubicacionActual = UtilesAndroid.ubicacionActual;
    		
    		double distanciaKm = UtilesAndroid.calcularDistanciaCoordenadas(splitUbicacionNotificacion[0], splitUbicacionNotificacion[1], 
    												   					    String.valueOf(ubicacionActual.getLatitude()), String.valueOf(ubicacionActual.getLongitude()));
    		
    		if(distanciaKm <= UtilesAndroid.DISTANCIA_CERCANA_KM)
    		{
    			// Inserto la notificacion en la BD
    			usuarioWS.insertarNotificacion(notificacionDTO);
    			
    			// Almaceno la notificacion en la lista global
            	UtilesAndroid.listaNotificaciones.add(notificacionDTO);
                
            	// Muestro una notificacion en la barra del movil
                mostrarGCMMessage(ctx, "Ha recibido una notificación.", notificacionDTO.getDescripcion());
    		}
    	}   
    }		
	
    private void handleGCMIntentMensajeAmistad(Context ctx, MensajeAmistadDTO mensajeAmistadDTO) 
    { 	
    	// La agrego al listado general de mensajes
        UtilesAndroid.listaMensajes.add(mensajeAmistadDTO);
        
        // Muestro notificacion en la barra del movil
        mostrarGCMMessage(ctx, "Ha recibido un mensaje.", mensajeAmistadDTO.getMensaje());  
    }	

	/**
	 * Se llamará al recibirse una respuesta correcta a la petición de registro e 
	 * incluye como parámetro el Registration ID asignado a nuestro cliente.
	 */
	@Override
	protected void onRegistered(Context context, String regId) 
	{
    	Log.d(TAG, "REGISTRATION: Registrado OK.");
    	
    	UsuarioDTO usuarioDTO = UtilesSeguridadAndroid.getUsuarioAutenticado(this);
    	
    	usuarioDTO = usuarioWS.obtener(usuarioDTO.getId());
    	
    	usuarioDTO.setGcmRegId(regId);
    	
    	usuarioWS.actualizar(usuarioDTO);    	
	}	
	
	
	/**
	 * Se llamara al recibirse una respusta correcta a la peticion para
	 * desregistrarse del servicio GCM
	 * */
	@Override
	protected void onUnregistered(Context context, String arg1) 
	{
		Log.d(TAG, "REGISTRATION: Unregistered.");
		//desregistrar en el servidor
	}		
    
    /**
     * Metodo para mostrar las notificaciones en la barra del movil.
     * */
	private static void mostrarGCMMessage(Context context, String msgTitle, String msgContent)
	{		
	    //Configuramos el Intent
	    Context appContext = context.getApplicationContext();
	 
	    Intent notificactionIntent = new Intent(appContext, GCMIntentService.class);
	 
	    PendingIntent contextIntent = PendingIntent.getActivity(appContext, 0, notificactionIntent, 0);
	    
	    //Configuramos la notificación
	    int icono = android.R.drawable.stat_sys_warning;
	    
	    Notification notification = new Notification(icono, "GEORED", System.currentTimeMillis());
	    
	    //AutoCancel: cuando se pulsa la notificaión ésta desaparece
	    notification.flags |= Notification.FLAG_AUTO_CANCEL;
	    
	    notification.setLatestEventInfo(appContext, msgTitle, msgContent, contextIntent);
	 
	    //Enviar notificación, obtenemos una referencia al servicio de notificaciones
	    NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
	    
	    notificationManager.notify(1, notification);
	}
}
