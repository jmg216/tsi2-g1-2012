package com.geored.frontoffice.activities;

import java.io.IOException;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import com.geored.frontoffice.R;
import com.geored.frontoffice.dto.UsuarioDTO;
import com.geored.frontoffice.utiles.MetodosWS;
import com.geored.frontoffice.utiles.UtilesWS;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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
    	
    	SoapObject request = UtilesWS.getSoapObject(MetodosWS.INSERTAR);
    	
    	PropertyInfo usuarioInfo = new PropertyInfo();
    	usuarioInfo.setName("arg0");
    	usuarioInfo.setValue(usu);
    	usuarioInfo.setType(usu.getClass());     	
    	request.addProperty(usuarioInfo);
    	
    	SoapSerializationEnvelope envelope = UtilesWS.getEnvelope(request);
    	
    	envelope.addMapping(UtilesWS.NAMESPACE, MetodosWS.USUARIO_DTO , new UsuarioDTO().getClass());    	
    	SoapObject response = UtilesWS.makeCall(envelope, MetodosWS.INSERTAR);
		String res = response.toString();
			
		if(res != null)
		{
		    	Intent menuActivity = new Intent (this, MenuActivity.class);
		    	startActivity(menuActivity);
		}

    	
    }
}
