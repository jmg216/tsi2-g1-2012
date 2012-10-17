package com.geored.frontoffice.activities;

import java.util.ArrayList;

import com.geored.frontoffice.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ContactosActivity extends Activity{
	
	ListView lv;
	TextView seleccionado;
	String[] subMenuContactos = {"Mis Contactos", "Invitar nuevo Usuario"};
	
	 @Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_contactos);
	         
	   // ListView lv = (ListView)findViewById(R.id.listView);
	         
	    //ArrayList<Contacto> contactos = obtenerItems();
	    //String[] contactos = {"Mis Contactos", "Invitar nuevo Usuario"};
	         
	    //ContactosAdapter adapter = new ContactosAdapter(this, contactos);
	         
	    //lv.setAdapter(new ArrayAdapter<String>(this, R.layout.activity_contactos, subMenuContactos));    
	  }
	     
//	  private ArrayList<Contacto> obtenerItems() {
//	    ArrayList<Contacto> contactos = new ArrayList<Contacto>();    
//	    
//	    contactos.add(new Contacto(1, "Patatas", "Tuberculo", "drawable/next", "otro"));
//	    contactos.add(new Contacto(2, "Naranja", "Fruta", "drawable/next", "otro"));
//	    contactos.add(new Contacto(3, "Lechuga", "Verdura", "drawable/next", "otro"));
//	         
//	    return contactos;
//	  }
	  
	}
