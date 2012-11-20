package com.geored.frontoffice.activities.menu;

import com.geored.frontoffice.activities.R;
import com.geored.frontoffice.activities.usuario.LoginActivity;
import com.geored.frontoffice.activities.usuario.PerfilActivity;
import com.geored.frontoffice.activities.mapa.MapGeoRedActivity;
import com.geored.frontoffice.activities.sitio.SitioActivity;
import com.geored.frontoffice.activities.sitio.SitioGroupActivity;
import com.geored.frontoffice.activities.contacto.ContactoActivity;
import com.geored.frontoffice.activities.contacto.ContactoGroupActivity;
import com.geored.frontoffice.activities.notificacion.NotificacionesActivity;

import android.app.ProgressDialog;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

public class MenuActivity extends TabActivity{
	
	private Runnable viewMenu;
	private ProgressDialog m_ProgressDialog = null; 
	
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

        m_ProgressDialog = ProgressDialog.show(MenuActivity.this, res.getString(R.string.cargando), res.getString(R.string.obteniendo_datos), true);	
        
        new Thread(new Runnable(){

  		public void run() {
  			
  			  try 
  			  {
  				Thread.sleep(20000);
  			  } 
  			  catch (InterruptedException e) 
  			  {
  				  e.printStackTrace();
  			  }

  			  m_ProgressDialog.dismiss();
  		}
      	  
        }).start();    	
        
        //TAB CONTACTOS **********************************************
        
        // Creo la vista customizada. 
        View tabView = createTabView(this,res.getString(R.string.contactos));
        
        intent = new Intent().setClass(this, ContactoGroupActivity.class);
        
        //Inicializo el TabSpec por cada tab y lo agrego al tabHost
        spec = tabHost.newTabSpec(res.getString(R.string.contactos))
        				.setIndicator(tabView)
        				.setContent(intent);
        tabHost.addTab(spec);
        
        //TAB SITIOS **************************************************
        
        tabView = createTabView(this, res.getString(R.string.sitios));
        
        intent = new Intent().setClass(this, SitioGroupActivity.class);
        
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
        
        //TAB MAPA *********************************************************
        
        tabView = createTabView(this, res.getString(R.string.mapa));
        
        intent = new Intent().setClass(this, MapGeoRedActivity.class);
        
        spec = tabHost.newTabSpec(res.getString(R.string.mapa))
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
