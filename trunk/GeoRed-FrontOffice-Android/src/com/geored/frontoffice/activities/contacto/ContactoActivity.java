package com.geored.frontoffice.activities.contacto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.geored.frontoffice.activities.R;
import com.geored.frontoffice.dto.UsuarioADTO;
import com.geored.frontoffice.wsclient.FactoryWS;
import com.geored.frontoffice.wsclient.UsuarioWS;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class ContactoActivity extends ListActivity {
	
	private UsuarioWS usuarioWS = FactoryWS.getInstancia().getUsuarioWS();
	
    private ProgressDialog m_ProgressDialog = null; 
    private List<UsuarioADTO> usuarios = null;
    private List<UsuarioADTO> usuarios_aux = null;
    private ContactoAdapter c_adapter;
    private Runnable viewUsuarios;
    private EditText edit_search_text;
    private Context context;
	
    @Override
	  public void onCreate(Bundle savedInstanceState) 
	{
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.general_list);
	    
	    Resources res = getResources();
        
	    usuarios = new ArrayList<UsuarioADTO>();
        
	    c_adapter = new ContactoAdapter(this, R.layout.row_contact_list, usuarios);
        
	    setListAdapter(c_adapter);
        
	    edit_search_text = (EditText) findViewById(R.id.buscador_texto);
	    
	    context = this;
        
        edit_search_text.addTextChangedListener(new TextWatcher() {
			
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				
				int largo_texto = edit_search_text.getText().length();
				
				usuarios_aux = new ArrayList<UsuarioADTO>();
				
				Iterator it =  usuarios.iterator();
				
				while (it.hasNext())
				{
					UsuarioADTO usu = (UsuarioADTO) it.next();
					
					if (largo_texto <= usu.getNombre().length())
					{
						if (edit_search_text.getText().toString().equalsIgnoreCase((String) usu.getNombre().subSequence(0, largo_texto)))
						{
							usuarios_aux.add(usu);
						}
					}
				}
				
				c_adapter = new ContactoAdapter(context, R.layout.row_contact_list, usuarios_aux);
				setListAdapter(c_adapter);
				
			}
			
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {}			
			public void afterTextChanged(Editable s) {}
			
        });  
        
	    usuarios = usuarioWS.obtenerListado();
	
	    if(usuarios != null && usuarios.size() > 0)
		{
	    	c_adapter.notifyDataSetChanged();
		                
		    for(int i = 0; i < usuarios.size(); i++)
		    {
		        	c_adapter.add(usuarios.get(i));
		    }
		}
	    c_adapter.notifyDataSetChanged();
	    
	    Button mail = (Button) findViewById(R.id.invitarAmigo);
	    mail.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
				String[] recipients = new String[]{"Colocar mail de Amigo"};
				emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, recipients);
				emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "GeoRedUy");
				emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Hey te invito a utilizar GeoRedUy. Enlace de la Aplicacion: https://play.google.com/store/apps/details?id=com.geored");
				emailIntent.setType("message/rfc822");
				startActivity(Intent.createChooser(emailIntent, "GeoRedUy"));
			}
		});                    
    
	 }
	    
    @Override
	protected void onListItemClick(ListView l, View v, int position, long id)
    {
    	super.onListItemClick(l, v, position, id);
	    	
	    Intent i = new Intent(this, ContactoDetalleActivity.class);
	        
	    UsuarioADTO contactoSeleccionado = (UsuarioADTO) getListAdapter().getItem(position);
	        
	    i.putExtra("nombreContacto", contactoSeleccionado.getNombre());  
	        
	    // Creo la vista usando LocalActivityManager del SitioGroupActivity
	    View view = ContactoGroupActivity.group.getLocalActivityManager()
			        .startActivity("detalle_contacto", i
			        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
			        .getDecorView();

	    // Remplazo la vista por la actual a cargar
	    ContactoGroupActivity.group.replaceView(view);  

	}	    
}
