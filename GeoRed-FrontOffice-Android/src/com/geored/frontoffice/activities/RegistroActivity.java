package com.geored.frontoffice.activities;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParserException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.geored.frontoffice.R;
import com.geored.frontoffice.dto.UsuarioADTO;
import com.geored.frontoffice.wsclient.UsuarioWS;

public class RegistroActivity extends Activity {
	
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
    	
    	UsuarioADTO usuarioADTO = new UsuarioADTO();
    	
    	usuarioADTO.setNombre(usuario.getText().toString());
    	usuarioADTO.setEmail(email.getText().toString());
    	usuarioADTO.setPass(pass.getText().toString());
    	
    	usuarioADTO.setNombre("Carlos");
    	usuarioADTO.setEmail("carlos@hotmail.com");
    	usuarioADTO.setPass("carlosPass");
    	
    	Long idUsuario = new UsuarioWS().insertar(usuarioADTO);
			
    	//Si se registra correctamente lo redirecciona al menu, sino
    	//envia mensaje de error.
		if(idUsuario != null)
		{
	    	Intent menuActivity = new Intent (this, MenuActivity.class);
	    	startActivity(menuActivity);
		}	
		else
		{
			messageToast(R.layout.custom_toast_message, Toast.LENGTH_SHORT);
		}
    }
    
    private void messageToast(int layout, int duration) {

    	
		LayoutInflater inflater = getLayoutInflater();		 
		View layoutView = inflater.inflate(layout, null);
		// set a message
		TextView text = (TextView) layoutView.findViewById(R.id.text);
		text.setText("Button is clicked!");    	
    	//Toast
    	Toast toast = new Toast(getApplicationContext()); 
    	toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
    	toast.setDuration(duration);
    	toast.setView(layoutView);
    	toast.show();

    }
}
