package com.geored.frontoffice.activities.notificacion;

import com.geored.frontoffice.activities.GCMIntentService;
import com.geored.frontoffice.activities.R;
import com.google.android.gcm.GCMRegistrar;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class NotificacionesActivity extends Activity
{
	private static final String TAG = "RegistroActivity";
	
	
	@Override
    public void onCreate(Bundle savedInstanceState) 
    {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.activity_notificaciones);        
    }
    
    /**
     * Invocado al momento de activar notificaciones en el tab Notificaciones.
     * */
    public void activarNotificaciones (View v)
    {
    	
    	//Registro la aplicacion en GCM
    	GCMIntentService.registerGCMService(this);
    	
    	if (GCMRegistrar.isRegistered(this))
    	{
    		//mandar toast mensaje de ya registro
    	} 	  	    	
    }
    
    /**
     * Invocado al momento desactivar las notificaciones en el tab Notificaciones.
     * */
    public void desactivarNotificaciones(View v)
    {
    	if (GCMRegistrar.isRegistered(this))
    	{
    		GCMIntentService.desregistrarGCMService(this);
    		//mostrar alert usuario resregistrado.
    	}
    	else
    	{
    		//mandar mensaje usuario no registrado.
    	}
    	
    }
}
