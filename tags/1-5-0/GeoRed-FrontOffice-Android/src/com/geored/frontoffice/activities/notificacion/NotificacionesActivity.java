package com.geored.frontoffice.activities.notificacion;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class NotificacionesActivity extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	TextView textview = new TextView(this);
    	textview.setText("Esta es la pestaña Notificaciones");
    	setContentView(textview);        
    }
}
