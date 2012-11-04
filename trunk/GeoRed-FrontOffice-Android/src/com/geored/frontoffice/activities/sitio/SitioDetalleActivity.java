package com.geored.frontoffice.activities.sitio;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SitioDetalleActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	TextView textview = new TextView(this);
    	textview.setText("Detalle del sitio");
    	setContentView(textview);        
    }
	
}
