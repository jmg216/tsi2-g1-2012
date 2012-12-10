package com.geored.frontoffice.activities.contacto;

import java.util.Date;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;

import com.geored.dto.AmistadDTO;
import com.geored.dto.MensajeAmistadDTO;
import com.geored.frontoffice.activities.R;
import com.geored.frontoffice.utiles.AlertaDialogManager;
import com.geored.frontoffice.utiles.UtilesSeguridadAndroid;
import com.geored.frontoffice.wsclient.FactoryWS;
import com.geored.frontoffice.wsclient.UsuarioWS;

public class ContactoChatActivity extends Activity
{
	private EditText messageText;
	private EditText messageHistoryText;
	private Long idContacto;
	private UsuarioWS usuarioWS = FactoryWS.getInstancia().getUsuarioWS();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chat);
		
		messageHistoryText = (EditText) findViewById(R.id.messageHistory);
		
		messageText = (EditText) findViewById(R.id.message);
		messageText.requestFocus();	
		
		Bundle extras = this.getIntent().getExtras();		
		idContacto = extras.getLong("idContactoToChat");
		String nombreContacto = extras.getString("nombreContactoToChat");
		String msg = extras.getString("msjChat");
		
		if (msg != null) 
		{
			this.appendToMessageHistory(nombreContacto , msg);
			((NotificationManager)getSystemService(NOTIFICATION_SERVICE)).cancel((nombreContacto + msg).hashCode());
		}		
		
	}
	
	public void enviarMensaje(View view)
	{
		CharSequence mensaje = messageText.getText();;

		final Context context = this.getApplicationContext();
		
		Bundle extras = this.getIntent().getExtras();
		
		if (mensaje.length() > 0) 
		{
			final MensajeAmistadDTO mensajeAmistadDTO = new MensajeAmistadDTO();
			mensajeAmistadDTO.setIdRemitente(UtilesSeguridadAndroid.getUsuarioAutenticado(getApplicationContext()).getId());
			mensajeAmistadDTO.setNombreRemitente(UtilesSeguridadAndroid.getUsuarioAutenticado(getApplicationContext()).getNombre());
			mensajeAmistadDTO.setMensaje(mensaje.toString());
			
			Long idAmistad = extras.getLong("idAmistad");				
			mensajeAmistadDTO.setIdAmistad(idAmistad);
			
			mensajeAmistadDTO.setFechaCreacion(new Date());
			
			appendToMessageHistory(mensajeAmistadDTO.getNombreRemitente(), mensaje.toString());
						
			messageText.setText("");
			
			usuarioWS.enviarMensajeChat(mensajeAmistadDTO);				
			
//			new Thread()
//			{					
//				public void run() 
//				{
//					usuarioWS.enviarMensajeChat(mensajeAmistadDTO);
//				}						
//			}.start();			
		}		
	}
	
	/**
	 * Muestra el mensaje y nombre del usuario en la ventana principal del chat.
	 * */
	private void appendToMessageHistory(String nombreUsuario, String mensaje) 
	{
		if (nombreUsuario != null && mensaje != null) 
		{
			messageHistoryText.append(nombreUsuario + ":\n");								
			messageHistoryText.append(mensaje + "\n");	
		}
	}
}