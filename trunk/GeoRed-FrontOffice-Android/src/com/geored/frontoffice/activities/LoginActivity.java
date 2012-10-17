package com.geored.frontoffice.activities;

import java.io.IOException;

import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.xmlpull.v1.XmlPullParserException;
import com.geored.frontoffice.R;
import com.geored.frontoffice.utiles.MetodosWS;
import com.geored.frontoffice.utiles.UtilesWS;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends Activity implements OnClickListener  {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        TextView registro = (TextView) findViewById(R.id.linkRegistro);
        registro.setOnClickListener(this);
        
    }
    
    public void loginUsuario (View v) throws IOException, XmlPullParserException
    {    	
    	EditText txtUsu = (EditText) this.findViewById(R.id.txtUsuario);
    	EditText txtPass = (EditText) this.findViewById(R.id.txtPass);

    	String usuario = txtUsu.getText().toString();
    	String pass = txtPass.getText().toString();
    	
    	SoapObject request = UtilesWS.getSoapObject(MetodosWS.EXISTE_USUARIO);
    	
    	PropertyInfo usuInfo = new PropertyInfo();
    	usuInfo.setName("arg0");
    	usuInfo.setValue(usuario);
    	usuInfo.setType(String.class);
        request.addProperty(usuInfo);
        
        PropertyInfo passInfo = new PropertyInfo();
        passInfo.setName("arg1");
        passInfo.setValue(pass);
        passInfo.setType(String.class);
        request.addProperty(passInfo);
        
        SoapSerializationEnvelope envelope = UtilesWS.getEnvelope(request);
        SoapObject response = UtilesWS.makeCall(envelope, MetodosWS.EXISTE_USUARIO);
        
        boolean existe = response.toString().equals("true");        
    	
    	if (existe)
    	{
	    	Intent menuActivity = new Intent (this, MenuActivity.class);
	    	startActivity(menuActivity);
    	}
    	else
    	{
        	Intent registroActivity = new Intent (this, RegistroActivity.class);
        	startActivity(registroActivity);
    	}
    	
    }    
    
	public void onClick(View v) {
		
    	Intent registroActivity = new Intent (this, RegistroActivity.class);
    	startActivity(registroActivity);	
		
	}

}
