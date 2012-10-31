package com.geored.frontoffice.activities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.geored.frontoffice.R;
import com.geored.frontoffice.dto.SitioADTO;
import com.geored.frontoffice.wsclient.SitioWS;
import com.geored.frontoffice.wsclient.UIProcessFactory;
import com.geored.frontoffice.wsclient.UsuarioWS;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class SitioActivity extends ListActivity {
	
	private SitioWS sitioWS = UIProcessFactory.getInstancia().getSitioWS();
	
    private List<SitioADTO> sitios = null;
    private List<SitioADTO> sitios_aux = null;
    private SitioAdapter s_adapter;
    private EditText edit_search_text;
    private Context context;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.general_list);
    	
    	Resources res = getResources();
    	
    	sitios = new ArrayList<SitioADTO>();
    	
	    s_adapter = new SitioAdapter(this, R.layout.row_contact_list, sitios);
        
	    setListAdapter(s_adapter);
        
	    edit_search_text = (EditText) findViewById(R.id.buscador_texto);
	    
	    context = this; 
	    
        edit_search_text.addTextChangedListener(new TextWatcher() {
			
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				
				int largo_texto = edit_search_text.getText().length();
				
				sitios_aux = new ArrayList<SitioADTO>();
				
				Iterator it =  sitios.iterator();
				
				while (it.hasNext())
				{
					SitioADTO usu = (SitioADTO) it.next();
					
					if (largo_texto <= usu.getNombre().length())
					{
						if (edit_search_text.getText().toString().equalsIgnoreCase((String) usu.getNombre().subSequence(0, largo_texto)))
						{
							sitios_aux.add(usu);
						}
					}
				}
				
				s_adapter = new SitioAdapter(context, R.layout.row_contact_list, sitios_aux);
				setListAdapter(s_adapter);
				
			}
			
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			public void afterTextChanged(Editable s) {
								
			}
		});	 
        
        sitios = sitioWS.obtenerListado();
        
        if(sitios != null && sitios.size() > 0)
        {
            s_adapter.notifyDataSetChanged();
            
            for(int i = 0; i < sitios.size(); i++)
            {
            	s_adapter.add(sitios.get(i));
            }
        }        
    }
}
