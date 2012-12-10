package com.geored.frontoffice.activities.usuario;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParserException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

import com.geored.dto.UsuarioDTO;
import com.geored.frontoffice.activities.R;
import com.geored.frontoffice.activities.menu.MenuActivity;
import com.geored.frontoffice.utiles.AlertaDialogManager;
import com.geored.frontoffice.utiles.UtilesSeguridadAndroid;
import com.geored.frontoffice.wsclient.FactoryWS;
import com.geored.frontoffice.wsclient.UsuarioWS;

public class LoginActivity extends Activity implements OnClickListener  {

	
	private UsuarioWS usuarioWS = FactoryWS.getInstancia().getUsuarioWS();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        TextView registro = (TextView) findViewById(R.id.linkRegistro);
        registro.setOnClickListener(this);
        
    }
    
    public void loginUsuario (View v) throws IOException, XmlPullParserException
    {       	
    	EditText txtEmail = (EditText) this.findViewById(R.id.txtUsuario);
    	EditText txtPass = (EditText) this.findViewById(R.id.txtPass);

    	String email = txtEmail.getText().toString();
    	String pass = txtPass.getText().toString();

    	email = "maximiliano@gmail.com";
    	pass = "usuario";
    	
    	// Encripto la pass
    	pass = UtilesSeguridadAndroid.encriptarMD5(pass);
    	
    	UsuarioDTO usuarioDTO = usuarioWS.obtenerPorEmailYPass(email, pass);
    	
    	if (usuarioDTO != null)
    	{
    		UtilesSeguridadAndroid.setUsuarioAutenticado(getApplicationContext(), usuarioDTO);	
    		
    		usuarioDTO.setConectado(true);
    		
    		usuarioWS.actualizar(usuarioDTO);
    		
	    	Intent menuActivity = new Intent (this, MenuActivity.class);
	    	startActivity(menuActivity);
    	}
    	else
    	{
    		AlertaDialogManager.showAlertDialog(this, getResources().getString(R.string.login), getResources().getString(R.string.error_login), false);
        	Intent registroActivity = new Intent (this, RegistroActivity.class);
        	startActivity(registroActivity);
    	}
    	
    }    
    
	public void onClick(View v) 
	{		
    	Intent registroActivity = new Intent (this, RegistroActivity.class);
    	startActivity(registroActivity);			
	}
}
