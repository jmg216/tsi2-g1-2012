package com.geored.frontoffice.activities.usuario;

import java.io.IOException;
import java.util.List;

import org.xmlpull.v1.XmlPullParserException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

import com.geored.dto.NotificacionDTO;
import com.geored.dto.UsuarioDTO;
import com.geored.frontoffice.activities.GCMIntentService;
import com.geored.frontoffice.activities.R;
import com.geored.frontoffice.activities.menu.MenuActivity;
import com.geored.frontoffice.utiles.AlertaDialogManager;
import com.geored.frontoffice.utiles.UtilesAndroid;
import com.geored.frontoffice.utiles.UtilesSeguridadAndroid;
import com.geored.frontoffice.wsclient.FactoryWS;
import com.geored.frontoffice.wsclient.UsuarioWS;
import com.google.android.gcm.GCMRegistrar;

public class LoginActivity extends Activity implements OnClickListener
{
	private UsuarioWS usuarioWS = FactoryWS.getInstancia().getUsuarioWS();

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		TextView registro = (TextView) findViewById(R.id.linkRegistro);
		registro.setOnClickListener(this);
	}

	public void loginUsuario(View v) throws IOException, XmlPullParserException
	{
		EditText txtEmail = (EditText) this.findViewById(R.id.txtUsuario);
		EditText txtPass = (EditText) this.findViewById(R.id.txtPass);

		String email = txtEmail.getText().toString();
		String pass = txtPass.getText().toString();

		email = "maxi.silveraf@gmail.com";
		pass = "usuario";

		// Encripto la pass
		pass = UtilesSeguridadAndroid.encriptarMD5(pass);
		
		txtEmail.setText(UtilesAndroid.URL_WS_USUARIO);
		
		UsuarioDTO usuarioDTO = null; 
		
		try
		{
			usuarioDTO = usuarioWS.obtenerPorEmailYPass(email, pass);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		if (usuarioDTO != null)
		{
			UtilesSeguridadAndroid.setUsuarioAutenticado(getApplicationContext(), usuarioDTO);

			usuarioDTO.setConectado(true);

			/*
			 * Activo las notificaciones
			 */
			if (GCMRegistrar.isRegistered(this))
			{
				String regId = GCMIntentService.obtenerGCMRegID(this);

				if (!regId.equals(usuarioDTO.getGcmRegId()))
				{
					usuarioDTO.setGcmRegId(regId);
				}
			} 
			else
			{
				// Registro la aplicacion en GCM
				GCMIntentService.registerGCMService(this);
				AlertaDialogManager.showAlertDialog(this, getResources().getString(R.string.notificaciones), getResources().getString(R.string.notificacionesActivadas), true);
			}

			usuarioWS.actualizar(usuarioDTO);

			// Obtengo las notificaciones del usuario
			List<NotificacionDTO> listaNotificacionesUsuario = usuarioWS.obtenerListadoNotificacionesPorTipoYUsuarioDestino(null, usuarioDTO.getId());
			for(NotificacionDTO notificacionDTO : listaNotificacionesUsuario)
			{
				UtilesAndroid.listaNotificaciones.add(notificacionDTO);
			}
			
			// Inicio la localizacion
			UtilesAndroid.iniciarLocalizacion(this);
			
			Intent menuActivity = new Intent(this, MenuActivity.class);
			startActivity(menuActivity);
		} 
		else
		{
			AlertaDialogManager.showAlertDialog(this, getResources().getString(R.string.login), getResources().getString(R.string.error_usuario_inexistente), false);
		}

	}

	public void onClick(View v)
	{
		Intent registroActivity = new Intent(this, RegistroActivity.class);
		startActivity(registroActivity);
	}
}
