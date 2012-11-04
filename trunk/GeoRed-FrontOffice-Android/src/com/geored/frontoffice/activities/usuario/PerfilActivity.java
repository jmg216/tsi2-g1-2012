package com.geored.frontoffice.activities.usuario;

import com.geored.frontoffice.activities.R;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PerfilActivity extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.activity_perfil);
    	
    	SharedPreferences prefs = getSharedPreferences("UserPreference",Context.MODE_PRIVATE);
    	String nombre = prefs.getString("nombreUser", "");
    	String email = prefs.getString("emailUser", "");
        
    	TextView tt = (TextView) this.findViewById(R.id.nombre_perfil);
        TextView bt = (TextView) this.findViewById(R.id.email_perfil);

        tt.setText(nombre);
        bt.setText(email);
//    	TextView textview = new TextView(this);
//    	textview.setText("Esta es la pestaña Perfil");
        
    	//setContentView(R.layout.activity_perfil);        
    }
}
