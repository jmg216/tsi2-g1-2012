package com.geored.frontoffice.activities;

import com.geored.frontoffice.R;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class MenuActivity  extends TabActivity{
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
       // TabHost tabHost=(TabHost)findViewById(R.id.tabhost);
       // tabHost.setup();
        
        Resources res = getResources();
        TabHost tabHost = getTabHost();
        TabHost.TabSpec spec; //Coleccion de tab a setear
        Intent intent;		//Intent reusable par instanciar cada uno de los tabs

        //Tab Contactos
        intent = new Intent().setClass(this, ContactosActivity.class);
        spec = tabHost.newTabSpec("Contactos")
        				.setIndicator("Contactos", res.getDrawable(R.drawable.ic_action_search))
        				.setContent(intent);
        tabHost.addTab(spec);
        
        //Tab Sitios
        intent = new Intent().setClass(this, SitioActivity.class);
        spec = tabHost.newTabSpec("Sitios")
        				.setIndicator("Sitios", res.getDrawable(R.drawable.ic_action_search))
        				.setContent(intent);
        tabHost.addTab(spec);
        
        //Tab Notificaciones
        intent = new Intent().setClass(this, NotificacionesActivity.class);
        spec = tabHost.newTabSpec("Notificaciones")
        				.setIndicator("Notificaciones", res.getDrawable(R.drawable.ic_action_search))
        				.setContent(intent);
        tabHost.addTab(spec);
        
        //Tab Perfil
        intent = new Intent().setClass(this, PerfilActivity.class);
        spec = tabHost.newTabSpec("Perfil")
        				.setIndicator("Perfil", res.getDrawable(R.drawable.ic_action_search))
        				.setContent(intent);
        tabHost.addTab(spec);        
        
        //Tab Chat
        intent = new Intent().setClass(this, ChatActivity.class);
        spec = tabHost.newTabSpec("Chat")
        				.setIndicator("Chat", res.getDrawable(R.drawable.ic_action_search))
        				.setContent(intent);
        tabHost.addTab(spec);        
    }
}
