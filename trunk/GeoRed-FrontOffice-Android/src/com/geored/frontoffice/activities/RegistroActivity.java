package com.geored.frontoffice.activities;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParserException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.geored.frontoffice.R;
import com.geored.frontoffice.dto.UsuarioDTO;
import com.geored.frontoffice.wsclient.UsuarioWS;

public class RegistroActivity extends Activity {

	//Constantes para la invocacion del web service
	private static final String NAMESPACE = "http://negocio.geored.com/";
//	private static String URL="http://10.0.2.2:8080/GeoRed-Business-EJB/UsuarioServiceImpl?wsdl";
//	private static final String METHOD_NAME_INSERTAR = "insertar";
	private static final String SOAP_ACTION ="";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
    }
    
    public void registroUsuario (View v) throws IOException, XmlPullParserException
    {
    	EditText usuario = (EditText) this.findViewById(R.id.txtNombreUsuario);
    	EditText email = (EditText) this.findViewById(R.id.txtEmail);
    	EditText pass = (EditText) this.findViewById(R.id.txtPassword);   	
    	
    	UsuarioDTO usu = new UsuarioDTO();
    	usu.setId(0L);
    	usu.setNombre(usuario.getText().toString());
    	usu.setEmail(email.getText().toString());
    	usu.setPass(pass.getText().toString());    	
    	
    	Long idUsuario = new UsuarioWS().insertar(usu);
			
		if(idUsuario != null)
		{
	    	Intent menuActivity = new Intent (this, MenuActivity.class);
	    	startActivity(menuActivity);
		}	
    }
}
