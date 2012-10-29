package com.geored.frontoffice.activities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.geored.frontoffice.R;
import com.geored.frontoffice.dto.UsuarioADTO;
import com.geored.frontoffice.wsclient.UsuarioWS;

import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class ContactosActivity extends ListActivity {
	
    private ProgressDialog m_ProgressDialog = null; 
    private List<UsuarioADTO> usuarios = null;
    private List<UsuarioADTO> usuarios_aux = null;
    private ContactosAdapter c_adapter;
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
        
	    c_adapter = new ContactosAdapter(this, R.layout.row_contact_list, usuarios);
        
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
				
				c_adapter = new ContactosAdapter(context, R.layout.row_contact_list, usuarios_aux);
				setListAdapter(c_adapter);
				
			}
			
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			public void afterTextChanged(Editable s) {
				
				
			}
		});
        
        viewUsuarios = new Runnable()
        {
            public void run() 
            {
            	usuarios = new UsuarioWS().obtenerListado();
                runOnUiThread(returnRes);
            }	        
	  };
	  
      Thread thread =  new Thread(null, viewUsuarios, "MagentoBackground");
      thread.start();
      m_ProgressDialog = ProgressDialog.show(ContactosActivity.this,    
            res.getString(R.string.cargando), res.getString(R.string.obteniendo_datos), true);	  
	}
	 
	 private Runnable returnRes = new Runnable() 
	 {
	        public void run() 
	        {
	            if(usuarios != null && usuarios.size() > 0)
	            {
	                c_adapter.notifyDataSetChanged();
	                
	                for(int i = 0; i < usuarios.size(); i++)
	                {
	                	c_adapter.add(usuarios.get(i));
	                }
	            }
	            m_ProgressDialog.dismiss();
	            c_adapter.notifyDataSetChanged();
	        }
	    };	 
}
