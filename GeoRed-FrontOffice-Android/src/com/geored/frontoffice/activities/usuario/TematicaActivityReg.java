package com.geored.frontoffice.activities.usuario;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;

import com.geored.dto.TematicaDTO;
import com.geored.dto.UsuarioDTO;
import com.geored.frontoffice.activities.R;
import com.geored.frontoffice.activities.menu.MenuActivity;
import com.geored.frontoffice.utiles.UtilesSeguridadAndroid;
import com.geored.frontoffice.wsclient.FactoryWS;
import com.geored.frontoffice.wsclient.GlobalWS;
import com.geored.frontoffice.wsclient.UsuarioWS;
import com.geored.frontoffice.activities.menu.MenuActivity;

public class TematicaActivityReg extends ListActivity{
	private GlobalWS tematica = FactoryWS.getInstancia().getGlobalWS();
	private UsuarioWS usuarioWS = FactoryWS.getInstancia().getUsuarioWS();	
	
	private List<TematicaDTO> tematicas = null;
	private TematicaAdapter t_adapter;
	
	@Override
	  public void onCreate(Bundle savedInstanceState) 
	{
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.particular_tematica_list);
	   // CheckBox checkbox = (CheckBox) findViewById(R.id.checkBox1);
	    Button registrar = (Button) findViewById(R.id.registro);
	    registrar.setOnClickListener(new OnClickListener() 
	    {
			public void onClick(View v) 
			{
				Bundle bundle=getIntent().getExtras();
		        Long idUsuario = bundle.getLong("idUsuario");
				
				
				if(idUsuario != null)
				{
					actividadMenu(idUsuario);
				}
			}
		});
	    
	    tematicas = new ArrayList<TematicaDTO>();
	    t_adapter = new TematicaAdapter(this, R.layout.row_tematica_check_list, tematicas);
	    setListAdapter(t_adapter);
	    tematicas = tematica.obtenerListadoTematicas();	
	    if(tematicas != null && tematicas.size() > 0)
		{
	    	t_adapter.notifyDataSetChanged();
		                
		    for(int i = 0; i < tematicas.size(); i++)
		    {
		        	t_adapter.add(tematicas.get(i));		        	
		    }
		}
	    t_adapter.notifyDataSetChanged();
	    
	    for(int i=0 ; i<tematicas.size() ; i++){
    		if (t_adapter.getItem(i) != null){
    			
    		}
    	}
	    
	 }
	
	private void actividadMenu(Long idUsuario){
		UsuarioDTO usuarioDTO = null;
		usuarioDTO = usuarioWS.obtener(idUsuario);
		UtilesSeguridadAndroid.setUsuarioAutenticado(getApplicationContext(), usuarioDTO);	
		Intent menuActivity = new Intent (this, MenuActivity.class);
    	startActivity(menuActivity);
	}
}
