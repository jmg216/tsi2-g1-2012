package com.geored.frontoffice.activities;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.util.Log;

import com.geored.frontoffice.utiles.UtilesSeguridadAndroid;
import com.google.android.gcm.GCMBaseIntentService;
import com.google.android.gcm.GCMRegistrar;

public class GCMIntentService extends GCMBaseIntentService
{
	private static final String TAG = "GCMIntentService";
    private static final Object LOCK = GCMIntentService.class;	
	private static PowerManager.WakeLock sWakeLock;
	
	public GCMIntentService() 
	{		
		super(UtilesSeguridadAndroid.ID_SENDER_GCM);
		Log.d("GCM_Red", UtilesSeguridadAndroid.ID_SENDER_GCM);
	}

	/**
	 * Metodo para registrar la aplicacion en GCM.
	 * */
    public static void registerInGCMService(Context context) 
    {
        if (!checkIsGCMServiceAvailable(context)) 
        {
            return;
        }
        final String regId = GCMRegistrar.getRegistrationId(context);
        if (regId.equals("")) 
        {
            try 
            {
                GCMRegistrar.register(context, UtilesSeguridadAndroid.ID_SENDER_GCM);
                Log.v("GCMTest", "Registrando...");
            }
            catch (Exception ex) 
            {
            }
        } 
        else 
        {
        	Log.v("GCMTest", "Ya registrado");
        }
    }

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
	
	//Respuesta de error a una peticion de registro.
	@Override
	protected void onError(Context context, String errorId) 
	{
		Log.d(TAG, "REGISTRATION: Error -> " + errorId);
	}

	//Se llamará cada vez que se reciba un nuevo mensaje desde el servidor de GCM. 
	//El contenido del mensaje se recibe en forma de intent
	@Override
	protected void onMessage(Context context, Intent intent) 
	{
		String msg = intent.getExtras().getString("msg");
		Log.d(TAG, "Mensaje: " + msg);
		mostrarNotificacion(context, msg);
	}

	//Se llamará al recibirse una respuesta correcta a la petición de registro e 
	//incluye como parámetro el Registration ID asignado a nuestro cliente.
	@Override
	protected void onRegistered(Context context, String regId) 
	{
    	Log.d(TAG, "REGISTRATION: Registrado OK.");
    	String reg = regId;
    	//registrar en el servidor
    	//registroServidor(usuario, regId);
	}	
	
	@Override
	protected void onUnregistered(Context arg0, String arg1) 
	{
		Log.d(TAG, "REGISTRATION: Unregistered.");
		//desregistrar en el servidor
	}		
	
	
    /*Handling Intents sent by GCM*/
    static void runIntentInService(Context context, Intent intent) {
        synchronized (LOCK) {
            if (sWakeLock == null) {
                PowerManager pm = (PowerManager) context
                        .getSystemService(Context.POWER_SERVICE);
                sWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,
                        "my_wakelock");
            }
        }
        sWakeLock.acquire();
        intent.setClassName(context, GCMIntentService.class.getName());
        context.startService(intent);
    }	

	private static void mostrarNotificacion(Context context, String msg)
	{
	    //Obtenemos una referencia al servicio de notificaciones
	    String ns = Context.NOTIFICATION_SERVICE;
	    NotificationManager notManager = (NotificationManager) context.getSystemService(ns);
	 
	    //Configuramos la notificación
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
	 
	    //AutoCancel: cuando se pulsa la notificaión ésta desaparece
	    notif.flags |= Notification.FLAG_AUTO_CANCEL;
	 
	    //Enviar notificación
	    notManager.notify(1, notif);
	}
}
