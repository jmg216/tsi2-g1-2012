package com.geored.frontoffice.activities.sitio;

import com.geored.frontoffice.activities.R;
import com.geored.frontoffice.utiles.BitMapImageConverter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SitioDetalleActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {    	
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.activity_sitio_detalle);
    	
    	ImageView imagen = (ImageView) findViewById(R.id.foto_sitio);
    	TextView nombreSitio = (TextView) findViewById(R.id.nombre_sitio);
    	TextView descSitio = (TextView) findViewById(R.id.descripcion_sitio);
    	//TextView info = (TextView) findViewById(R.id.i)
    	
    	Intent intent = getIntent();  	
    	    	
    	String imagen_sitio = (String) intent.getExtras().get("imagenSitio");
    	String nombre_sitio = (String) intent.getExtras().get("nombreSitio");
    	String desc_sitio = (String) intent.getExtras().get("descSitio");
    	
    	Bitmap bm = BitMapImageConverter.getImageBitmap(imagen_sitio); 
    	imagen.setImageBitmap(bm);
    	nombreSitio.setText(nombre_sitio);
    	descSitio.setText(desc_sitio);
    	
    	Gallery g = (Gallery) this.findViewById(R.id.galeria_sitio);
    	g.setAdapter(new ImageAdapter(this));
    	
    	g.setOnItemClickListener(new OnItemClickListener() 
    	{
    	       public void onItemClick(AdapterView<?> parent, View v, int position, long id) 
    	       {
    	           Toast.makeText(SitioDetalleActivity.this, "" + position,
    	               Toast.LENGTH_SHORT).show();
    	       }
    	   });    	       
    }
    
    /**
     * Metodo que maneja la funcionalidad checkin
     * */
    public void checkinSitio (View v)
    {
    	
    }
	
}
