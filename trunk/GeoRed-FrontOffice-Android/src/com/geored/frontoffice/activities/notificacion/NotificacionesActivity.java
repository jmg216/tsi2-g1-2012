package com.geored.frontoffice.activities.notificacion;

import com.geored.frontoffice.activities.GCMIntentService;
import com.geored.frontoffice.activities.R;
import com.geored.frontoffice.utiles.AlertaDialogManager;
import com.google.android.gcm.GCMRegistrar;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class NotificacionesActivity extends Activity
{
	private static final String TAG = "RegistroActivity";
	
	//private Resources res = getResources();
	
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
    	if (GCMRegistrar.isRegistered(this))
    	{
    		AlertaDialogManager.showAlertDialog(this, getResources().getString(R.string.notificaciones), getResources().getString(R.string.notificacionesYaActivadas), true);
    	}
    	else
    	{
        	//Registro la aplicacion en GCM
        	GCMIntentService.registerGCMService(this);   
        	AlertaDialogManager.showAlertDialog(this, getResources().getString(R.string.notificaciones), getResources().getString(R.string.notificacionesActivadas), true);
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
    		AlertaDialogManager.showAlertDialog(this, getResources().getString(R.string.notificaciones), getResources().getString(R.string.notificacionesDesactivadas), true);
    	}
    	else
    	{
    		AlertaDialogManager.showAlertDialog(this, getResources().getString(R.string.notificaciones), getResources().getString(R.string.notificacionesNoActivas), false);
    	}
    	
    }
}
