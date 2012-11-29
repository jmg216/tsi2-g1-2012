package com.geored.frontoffice.activities.usuario;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParserException;

import android.app.Activity;
import android.app.ProgressDialog;
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

import com.geored.dto.UsuarioDTO;
import com.geored.frontoffice.activities.R;
import com.geored.frontoffice.activities.menu.MenuActivity;
import com.geored.frontoffice.utiles.UtilesSeguridadAndroid;
import com.geored.frontoffice.wsclient.FactoryWS;
import com.geored.frontoffice.wsclient.GlobalWS;
import com.geored.frontoffice.wsclient.UsuarioWS;

public class LoginActivity extends Activity implements OnClickListener  {

	
	private UsuarioWS usuarioWS = FactoryWS.getInstancia().getUsuarioWS();
	private GlobalWS globalWS = FactoryWS.getInstancia().getGlobalWS();
	
	private static final int TIEMPO_MENSAJE = 300000;
	
	private ProgressDialog m_ProgressDialog = null; 
	private Runnable viewMenu;
	
	private Resources res;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        TextView registro = (TextView) findViewById(R.id.linkRegistro);
        registro.setOnClickListener(this);
        res = getResources();
        
    }
    
    public void loginUsuario (View v) throws IOException, XmlPullParserException
    {   
    	
    	EditText txtEmail = (EditText) this.findViewById(R.id.txtUsuario);
    	EditText txtPass = (EditText) this.findViewById(R.id.txtPass);

    	String email = txtEmail.getText().toString();
    	String pass = txtPass.getText().toString();
    	
//    	email = "juan@gmail.com";
//    	pass = "juan";

    	UsuarioDTO usuarioDTO = usuarioWS.obtenerPorEmailYPass(email, pass);
    	
    	if (usuarioDTO != null)
    	{
    		UtilesSeguridadAndroid.setUsuarioAutenticado(getApplicationContext(), usuarioDTO);	
    		
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
