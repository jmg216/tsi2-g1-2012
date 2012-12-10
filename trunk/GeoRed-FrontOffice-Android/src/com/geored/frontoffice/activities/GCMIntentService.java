package com.geored.frontoffice.activities;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.geored.dto.MensajeAmistadDTO;
import com.geored.dto.NotificacionDTO;
import com.geored.dto.UsuarioDTO;
import com.geored.frontoffice.activities.contacto.ContactoChatActivity;
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
	 * Se llamar� cada vez que se reciba un nuevo mensaje desde el servidor de GCM.
	 * El contenido del mensaje se recibe en forma de intent 
	 */
	@Override
	protected void onMessage(Context context, Intent intent) 
	{
		 String msg = intent.getExtras().getString("message");
		 
		 String gsonMessage = msg.substring(1);
		 String codigoTipo = msg.substring(0, 1);
		 
		 Gson gson = new Gson();  
		 
		 //TODO Resolver como diferenciar si el mensaje en de chat o de una notificacion.
		 if (codigoTipo.equals(ConstantesGenerales.TiposCodigoMensaje.CHAT))
		 {
			 MensajeAmistadDTO mensajeAmistadDTO= gson.fromJson(gsonMessage, MensajeAmistadDTO.class);
			 
			 sendGCMIntentMensajeAmistad(context, mensajeAmistadDTO);
		 }
		 
		 if (codigoTipo.equals(ConstantesGenerales.TiposCodigoMensaje.NOTIFICACION))
		 {
			 NotificacionDTO notificacionDTO = gson.fromJson(gsonMessage, NotificacionDTO.class);
			 sendGCMIntentNotificacion(context, notificacionDTO);
		 }		 		
	}
	
    private void sendGCMIntentNotificacion(Context ctx, NotificacionDTO notificacion) 
    {
        
        Intent broadcastIntent = new Intent();
        broadcastIntent.setAction("GCM_RECEIVED_ACTION");         
        broadcastIntent.putExtra("msjNotificacion", notificacion.getDescripcion());       
        ctx.sendBroadcast(broadcastIntent);
        mostrarNotificacion(ctx, notificacion.getDescripcion());         
    }		
	
    private void sendGCMIntentMensajeAmistad(Context ctx, MensajeAmistadDTO mensajeAmistad) 
    {
        
        Intent broadcastIntent = new Intent();
        broadcastIntent.setAction("GCM_RECEIVED_ACTION");         
        broadcastIntent.putExtra("msjChat", mensajeAmistad.getMensaje());       
        ctx.sendBroadcast(broadcastIntent);
        getApplicationContext();
        mostrarNotificacion(ctx, mensajeAmistad.getMensaje());         
    }	

	/**
	 * Se llamar� al recibirse una respuesta correcta a la petici�n de registro e 
	 * incluye como par�metro el Registration ID asignado a nuestro cliente.
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
     * Metodo para mostrar notificaciones. Modificarlo.
     * */
	private static void mostrarNotificacion(Context context, String msg)
	{
		
	    //Obtenemos una referencia al servicio de notificaciones
	    String ns = Context.NOTIFICATION_SERVICE;
	    NotificationManager notManager = (NotificationManager) context.getSystemService(ns);
	 
	    //Configuramos la notificaci�n
	    int icono = android.R.drawable.stat_sys_warning;
	    CharSequence textoEstado = "Alerta!";
	    long hora = System.currentTimeMillis();
	 
	    Notification notif = new Notification(icono, textoEstado, hora);
	 
	    //Configuramos el Intent
	    Context contexto = context.getApplicationContext();
	    CharSequence titulo = "Nuevo Mensaje";
	    CharSequence descripcion = msg;
	 
	    Intent notIntent = new Intent(contexto, GCMIntentService.class);
	 
	    PendingIntent contIntent = PendingIntent.getActivity(contexto, 0, notIntent, 0);
	 
	    notif.setLatestEventInfo(contexto, titulo, descripcion, contIntent);
	 
	    //AutoCancel: cuando se pulsa la notificai�n �sta desaparece
	    notif.flags |= Notification.FLAG_AUTO_CANCEL;
	 
	    //Enviar notificaci�n
	    notManager.notify(1, notif);
	}
}