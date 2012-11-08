package com.geored.frontoffice.activities.contacto;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ContactoDetalleActivity extends Activity
{	
    @Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView textview = new TextView(this);
		Bundle extras = getIntent().getExtras();
		String nombreContacto = extras.getString("nombreContacto");
		textview.setText(nombreContacto);
		setContentView(textview);  
    }
}
