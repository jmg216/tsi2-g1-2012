package com.geored.frontoffice.activities.usuario;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.geored.dto.TematicaDTO;
import com.geored.dto.UsuarioDTO;
import com.geored.frontoffice.activities.R;
import com.geored.frontoffice.activities.menu.MenuActivity;
import com.geored.frontoffice.utiles.UtilesSeguridadAndroid;
import com.geored.frontoffice.wsclient.FactoryWS;
import com.geored.frontoffice.wsclient.GlobalWS;
import com.geored.frontoffice.wsclient.UsuarioWS;
import com.google.gson.Gson;

public class TematicaActivityReg extends ListActivity
{
	private GlobalWS globalWS = FactoryWS.getInstancia().getGlobalWS();
	private UsuarioWS usuarioWS = FactoryWS.getInstancia().getUsuarioWS();

	private UsuarioDTO usuarioDTO = null;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.particular_tematica_list);
		
		usuarioDTO = (UsuarioDTO) new Gson().fromJson(getIntent().getExtras().getString("gsonUsuarioDTO"), UsuarioDTO.class);
		usuarioDTO.setListaTematicasDTO(new ArrayList<TematicaDTO>());
		
		// CheckBox checkbox = (CheckBox) findViewById(R.id.checkBox1);
		Button registrar = (Button) findViewById(R.id.registro);
		
		registrar.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				actividadMenu();
			}
		});

		// Cargo las tematicas
		final List<TematicaDTO> tematicasDTO = globalWS.obtenerListadoTematicas();
		
		if(tematicasDTO != null)
		{
			setListAdapter(new ArrayAdapter<TematicaDTO>(this, R.layout.row_tematica_check_list, tematicasDTO)
			{
				@Override
				public View getView(int position, View convertView, ViewGroup parent)
				{
					View v = convertView;
		            if (convertView == null) 
		            {
		            	LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		                v = inflater.inflate(R.layout.row_tematica_check_list, null);
		            }
		            
		            final TematicaDTO tematica = tematicasDTO.get(position);
		            
		            if (tematica != null) 
		            {
	                    TextView tt = (TextView) v.findViewById(R.id.code);	                                                          
	                    tt.setText(tematica.getNombre());                  
	                    
	                    CheckBox checkBoxTematica = (CheckBox) v.findViewById(R.id.chkTematica);
	                    checkBoxTematica.setOnClickListener(new View.OnClickListener()
						{							
							public void onClick(View arg0)
							{							
								addTematicaUsuario(tematica.getId());
							}
						});
		            }
		            
		            return v;
				}
			});
		}
	}
	
	private void addTematicaUsuario(Long idTematica)
	{
		TematicaDTO tematicaDTO = new TematicaDTO();
		tematicaDTO.setId(idTematica);
		
		usuarioDTO.getListaTematicasDTO().add(tematicaDTO);
	}
	
	private void actividadMenu()
	{
		Long idUsuario = usuarioWS.insertar(usuarioDTO);
		
		UtilesSeguridadAndroid.setUsuarioAutenticado(getApplicationContext(), usuarioWS.obtener(idUsuario));
		
		Intent menuActivity = new Intent(this, MenuActivity.class);
		
		startActivity(menuActivity);
	}
}
