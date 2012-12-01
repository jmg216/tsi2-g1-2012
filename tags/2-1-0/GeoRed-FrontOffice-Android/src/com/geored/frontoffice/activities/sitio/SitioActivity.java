package com.geored.frontoffice.activities.sitio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.geored.dto.SitioDTO;
import com.geored.frontoffice.activities.R;
import com.geored.frontoffice.wsclient.FactoryWS;
import com.geored.frontoffice.wsclient.SitioWS;

public class SitioActivity extends ListActivity {
	
	private SitioWS sitioWS = FactoryWS.getInstancia().getSitioWS();
	
    private List<SitioDTO> sitios = null;
    private List<SitioDTO> sitios_aux = null;
    private SitioAdapter s_adapter;
    private EditText edit_search_text;
    private Context context;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.general_list);
    	
    	Resources res = getResources();
    	
    	sitios = new ArrayList<SitioDTO>();
    	
	    s_adapter = new SitioAdapter(this, R.layout.row_contact_list, sitios);
        
	    setListAdapter(s_adapter);
        
	    edit_search_text = (EditText) findViewById(R.id.buscador_texto);
	    
	    context = this; 
	    
        edit_search_text.addTextChangedListener(new TextWatcher() {
			
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				
				int largo_texto = edit_search_text.getText().length();
				
				sitios_aux = new ArrayList<SitioDTO>();
				
				Iterator it =  sitios.iterator();
				
				while (it.hasNext())
				{
					SitioDTO sitio = (SitioDTO) it.next();
					
					if (largo_texto <= sitio.getNombre().length())
					{
						if (edit_search_text.getText().toString().equalsIgnoreCase((String) sitio.getNombre().subSequence(0, largo_texto)))
						{
							sitios_aux.add(sitio);
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
    
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) 
    {
        super.onListItemClick(l, v, position, id);
        
        Intent i = new Intent(this, SitioDetalleActivity.class);
        
        SitioDTO sitioSeleccionado = (SitioDTO) getListAdapter().getItem(position);
        
        i.putExtra("nombreSitio", sitioSeleccionado.getNombre());  
        i.putExtra("imagenSitio", sitioSeleccionado.getUrlImagen());
        i.putExtra("descSitio", sitioSeleccionado.getDescripcion());
        
        // Creo la vista usando LocalActivityManager del SitioGroupActivity
        View view = SitioGroupActivity.group.getLocalActivityManager()
		        .startActivity("detalle_sitio", i
		        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
		        .getDecorView();

        // Remplazo la vista por la actual a cargar
        SitioGroupActivity.group.replaceView(view);       

    }	    
}
