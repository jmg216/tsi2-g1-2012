package com.geored.frontoffice.activities.usuario;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.geored.dto.UsuarioDTO;
import com.geored.frontoffice.activities.R;
import com.geored.frontoffice.utiles.UtilesSeguridadAndroid;

public class PerfilActivity extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.activity_perfil);
    	
		UsuarioDTO usuarioDTO = UtilesSeguridadAndroid.getUsuarioAutenticado(getApplicationContext());
        
    	TextView tt = (TextView) this.findViewById(R.id.nombre_perfil);
        TextView bt = (TextView) this.findViewById(R.id.email_perfil);

        tt.setText(usuarioDTO.getNombre());
        bt.setText(usuarioDTO.getEmail());      
    }
}
