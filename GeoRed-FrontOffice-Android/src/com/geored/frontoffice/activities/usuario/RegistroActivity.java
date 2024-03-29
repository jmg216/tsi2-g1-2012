package com.geored.frontoffice.activities.usuario;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.xmlpull.v1.XmlPullParserException;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.geored.dto.UsuarioDTO;
import com.geored.frontoffice.activities.R;
import com.geored.frontoffice.utiles.AlertaDialogManager;
import com.geored.frontoffice.utiles.UtilesSeguridadAndroid;
import com.geored.frontoffice.wsclient.FactoryWS;
import com.geored.frontoffice.wsclient.UsuarioWS;
import com.google.gson.Gson;

public class RegistroActivity extends Activity
{
	private UsuarioWS usuarioWS = FactoryWS.getInstancia().getUsuarioWS();
	private ImageView imageView;
	private Bitmap loadedImage;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registro);

		imageView = (ImageView) findViewById(R.id.image_view);
		TextView btnCargaFoto = (TextView) this.findViewById(R.id.txtCarga);
		final EditText urlImagen = (EditText) this.findViewById(R.id.txtUrlImagen);

		btnCargaFoto.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				cargarImagen(urlImagen.getText().toString());
				// Pueden probar hardcodeando una url como esta de aca abajo y
				// comentan la llamada de arriba, igual lo probe y anda de flama
				// cargarImagen("http://t2.gstatic.com/images?q=tbn:ANd9GcTos1E4Rss6VKIBKCFJCJKVSXy-d1Q8PiXC9Fraz-tTi1PeW8lzdA");
			}
		});
	}

	public void registroUsuario(View v) throws IOException, XmlPullParserException
	{
		EditText usuario = (EditText) this.findViewById(R.id.txtNombreUsuario);
		EditText email = (EditText) this.findViewById(R.id.txtEmail);
		EditText pass = (EditText) this.findViewById(R.id.txtPassword);
		EditText urlImagen = (EditText) this.findViewById(R.id.txtUrlImagen);

		UsuarioDTO usuarioDTO = new UsuarioDTO();

		usuarioDTO.setNombre(usuario.getText().toString());
		usuarioDTO.setEmail(email.getText().toString());
		usuarioDTO.setPass(UtilesSeguridadAndroid.encriptarMD5(pass.getText().toString()));

		if (urlImagen.getText() != null)
		{
			usuarioDTO.setUrlImagen(urlImagen.getText().toString());
		}
		
		Intent i = new Intent(this, TematicaActivityReg.class);
		i.putExtra("gsonUsuarioDTO", new Gson().toJson(usuarioDTO));
		startActivity(i);
	}

	private void cargarImagen(String imageHttpAddress)
	{
		URL imageUrl = null;
		try
		{
			imageUrl = new URL(imageHttpAddress);
			HttpURLConnection conn = (HttpURLConnection) imageUrl.openConnection();
			conn.connect();
			loadedImage = BitmapFactory.decodeStream(conn.getInputStream());
			imageView.setImageBitmap(loadedImage);
		} catch (IOException e)
		{
			Toast.makeText(getApplicationContext(), "Error cargando la imagen seleccione una url de imagen v�lida ", Toast.LENGTH_LONG).show();
			AlertaDialogManager.showAlertDialog(this, getResources().getString(R.string.registro), getResources().getString(R.string.errorCargandoImagen), false);
			e.printStackTrace();
		}
	};
}
