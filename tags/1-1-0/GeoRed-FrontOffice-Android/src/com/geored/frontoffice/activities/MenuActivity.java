package com.geored.frontoffice.activities;

import com.geored.frontoffice.R;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

public class MenuActivity  extends TabActivity{
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
       // TabHost tabHost=(TabHost)findViewById(R.id.tabhost);
       // tabHost.setup();
        
        Resources res = getResources();
        TabHost tabHost = getTabHost(); //Guarda la collection de tabs
        TabHost.TabSpec spec; //Cada tab
        Intent intent;		//Intent reusable para instanciar cada uno de los tabs

        
        
        //TAB CONTACTOS **********************************************
        
        // Creo la vista customizada. 
        View tabView = createTabView(this,res.getString(R.string.contactos));
        
        intent = new Intent().setClass(this, ContactosActivity.class);
        
        //Inicializo el TabSpec por cada tab y lo agrego al tabHost
        spec = tabHost.newTabSpec(res.getString(R.string.contactos))
        				.setIndicator(tabView)
        				.setContent(intent);
        
        tabHost.addTab(spec);
        
        //TAB SITIOS **************************************************
        
        tabView = createTabView(this, res.getString(R.string.sitios));
        
        intent = new Intent().setClass(this, SitioActivity.class);
        
        spec = tabHost.newTabSpec(res.getString(R.string.sitios))
        				.setIndicator(tabView)
        				.setContent(intent);
        tabHost.addTab(spec);
        
        //TAB NOTIFICACIONES ********************************************
        
        tabView = createTabView(this, res.getString(R.string.notificaciones));
        
        intent = new Intent().setClass(this, NotificacionesActivity.class);
        
        spec = tabHost.newTabSpec(res.getString(R.string.notificaciones))
        				.setIndicator(tabView)
        				.setContent(intent);
        
        tabHost.addTab(spec);
        
        //TAB PERFIL *******************************************************
        
        tabView = createTabView(this, res.getString(R.string.perfil));
        
        intent = new Intent().setClass(this, PerfilActivity.class);
        
        spec = tabHost.newTabSpec(res.getString(R.string.perfil))
        				.setIndicator(tabView)
        				.setContent(intent);
        
        tabHost.addTab(spec);        
        
        //TAB CHAT *********************************************************
        
        tabView = createTabView(this, res.getString(R.string.chat));
        
        intent = new Intent().setClass(this, ChatActivity.class);
        
        spec = tabHost.newTabSpec(res.getString(R.string.chat))
        				.setIndicator(tabView)
        				.setContent(intent);
        
        tabHost.addTab(spec);        
    }
    
    /**
     * Crea la vista customizada para cada uno de los tab. 
     * */
    private static View createTabView(Context context, String tabText) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_tab, null, false);
        TextView tv = (TextView) view.findViewById(R.id.tabTitle);
        tv.setText(tabText);
        return view;
    }    
}
