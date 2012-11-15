package com.geored.frontoffice.activities.usuario;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParserException;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.geored.dto.TematicaDTO;
import com.geored.frontoffice.activities.R;
import com.geored.frontoffice.activities.menu.MenuActivity;
import com.geored.frontoffice.dto.TematicaADTO;
import com.geored.frontoffice.dto.UsuarioADTO;
import com.geored.frontoffice.wsclient.FactoryWS;
import com.geored.frontoffice.wsclient.UsuarioWS;

public class RegistroActivity extends Activity {
	
	private UsuarioWS usuarioWS = FactoryWS.getInstancia().getUsuarioWS();
	
	private ImageView imageView;
    private Bitmap loadedImage;

	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        
        imageView = (ImageView) findViewById(R.id.image_view);
    	TextView btnCargaFoto = (TextView) this.findViewById(R.id.txtCarga);
    	final EditText urlImagen = (EditText) this.findViewById(R.id.txtUrlImagen);
    	
    	btnCargaFoto.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				cargarImagen(urlImagen.getText().toString());
				//Pueden probar hardcodeando una url como esta de aca abajo y comentan la llamada de arriba, igual lo probe y anda de flama
				//cargarImagen("http://t2.gstatic.com/images?q=tbn:ANd9GcTos1E4Rss6VKIBKCFJCJKVSXy-d1Q8PiXC9Fraz-tTi1PeW8lzdA");
			}
		});
    }
    
    public void registroUsuario (View v) throws IOException, XmlPullParserException
    {
    	EditText usuario = (EditText) this.findViewById(R.id.txtNombreUsuario);
    	EditText email = (EditText) this.findViewById(R.id.txtEmail);
    	EditText pass = (EditText) this.findViewById(R.id.txtPassword);   
    	EditText urlImagen = (EditText) this.findViewById(R.id.txtUrlImagen);//PARA PASAR LA URL
    	
    	UsuarioADTO usuarioADTO = new UsuarioADTO();
    	
    	usuarioADTO.setNombre(usuario.getText().toString());
    	usuarioADTO.setEmail(email.getText().toString());
    	usuarioADTO.setPass(pass.getText().toString());
    	if (urlImagen.getText() != null)
    	{	
    		usuarioADTO.setUrlImagen(urlImagen.getText().toString());
    	}
    	
//    	usuarioADTO.setNombre("Juan");
//    	usuarioADTO.setEmail("juan@hotmail.com");
//    	usuarioADTO.setPass("juanPass");

    	Long idUsuario = usuarioWS.insertar(usuarioADTO);
			
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
    
    private void cargarImagen(String imageHttpAddress){
    	URL imageUrl = null;
        try {
            imageUrl = new URL(imageHttpAddress);
            HttpURLConnection conn = (HttpURLConnection) imageUrl.openConnection();
            conn.connect();
            loadedImage = BitmapFactory.decodeStream(conn.getInputStream());
            imageView.setImageBitmap(loadedImage);
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "Error cargando la imagen seleccione una url de imagen válida ", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    };
    
    
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
