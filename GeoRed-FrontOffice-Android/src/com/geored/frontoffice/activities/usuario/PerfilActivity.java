package com.geored.frontoffice.activities.usuario;

import com.geored.frontoffice.activities.R;
import com.geored.frontoffice.dto.UsuarioADTO;
import com.geored.frontoffice.utiles.UtilesSeguridadAndroid;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PerfilActivity extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.activity_perfil);
    	
		UsuarioADTO usuarioADTO = UtilesSeguridadAndroid.getUsuarioAutenticado(getApplicationContext());
        
    	TextView tt = (TextView) this.findViewById(R.id.nombre_perfil);
        TextView bt = (TextView) this.findViewById(R.id.email_perfil);

        tt.setText(usuarioADTO.getNombre());
        bt.setText(usuarioADTO.getEmail());      
    }
}
