package com.geored.frontoffice.activities;

import java.io.IOException;
import java.util.List;

import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.xmlpull.v1.XmlPullParserException;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.geored.frontoffice.R;
import com.geored.frontoffice.dto.UsuarioADTO;
import com.geored.frontoffice.wsclient.UIProcessFactory;
import com.geored.frontoffice.wsclient.UsuarioWS;

public class LoginActivity extends Activity implements OnClickListener  {

	
	private UsuarioWS usuarioWS = UIProcessFactory.getInstancia().getUsuarioWS();
	
	private static final int TIEMPO_MENSAJE = 300000;
	
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
    	
//    	email = "jmg216@hotmail.com";
//    	pass = "juanma";
    	
    	UsuarioADTO usuarioADTO = usuarioWS.obtenerPorEmailYPass(email, pass);
    	
    	if (usuarioADTO != null)
    	{
	    	Intent menuActivity = new Intent (this, MenuActivity.class);
	    	startActivity(menuActivity);
    	}
    	else
    	{
    		messageToast(R.layout.custom_toast_message, TIEMPO_MENSAJE);
    		
        	Intent registroActivity = new Intent (this, RegistroActivity.class);
        	startActivity(registroActivity);
    	}
    	
    }    
    
	public void onClick(View v) 
	{		
    	Intent registroActivity = new Intent (this, RegistroActivity.class);
    	startActivity(registroActivity);			
	}
	
    private void messageToast(int layout, int duration) 
    {
    	Resources res = getResources();
		LayoutInflater inflater = getLayoutInflater();		 
		View layoutView = inflater.inflate(layout, null);
		// set a message
		TextView text = (TextView) layoutView.findViewById(R.id.text);
		text.setText(res.getString(R.string.error_login));    	
    	//Toast
    	Toast toast = new Toast(getApplicationContext()); 
    	toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
    	toast.setDuration(duration);
    	toast.setView(layoutView);
    	toast.show();
    }	

}
