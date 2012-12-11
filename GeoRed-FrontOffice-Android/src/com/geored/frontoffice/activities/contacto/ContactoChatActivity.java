package com.geored.frontoffice.activities.contacto;

import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.geored.dto.MensajeAmistadDTO;
import com.geored.frontoffice.activities.R;
import com.geored.frontoffice.utiles.UtilesAndroid;
import com.geored.frontoffice.utiles.UtilesSeguridadAndroid;
import com.geored.frontoffice.wsclient.FactoryWS;
import com.geored.frontoffice.wsclient.UsuarioWS;

public class ContactoChatActivity extends Activity
{
	private EditText messageText;
	private EditText messageHistoryText;
	private UsuarioWS usuarioWS = FactoryWS.getInstancia().getUsuarioWS();

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chat);

		messageHistoryText = (EditText) findViewById(R.id.messageHistory);
		messageHistoryText.setOnFocusChangeListener(new View.OnFocusChangeListener()
		{			
			public void onFocusChange(View v, boolean hasFocus)
			{
				refrescarListaMensajes();
			}
		});

		messageText = (EditText) findViewById(R.id.message);
		messageText.requestFocus();

	}

	public void enviarMensaje(View view)
	{
		CharSequence mensaje = messageText.getText();

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

			UtilesAndroid.listaMensajes.add(mensajeAmistadDTO);

			messageText.setText("");
			
			refrescarListaMensajes();

			usuarioWS.enviarMensajeChat(mensajeAmistadDTO);
		}
	}

	private void refrescarListaMensajes()
	{
		StringBuilder auxMessageHistory = new StringBuilder();		
		for(MensajeAmistadDTO mensaje : UtilesAndroid.listaMensajes)
		{
			String nombreRemitente = mensaje.getIdRemitente().equals(UtilesSeguridadAndroid.getUsuarioAutenticado(this).getId()) ? "Yo" : mensaje.getNombreRemitente();			
			auxMessageHistory.append(nombreRemitente).append(": ").append(mensaje.getMensaje()).append("\n");
		}		
		messageHistoryText.setText(auxMessageHistory);
	}
}