package com.geored.frontoffice.activities.contacto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.geored.dto.UsuarioDTO;
import com.geored.frontoffice.activities.R;
import com.geored.frontoffice.utiles.BitMapImageConverter;
import com.geored.frontoffice.wsclient.FactoryWS;
import com.geored.frontoffice.wsclient.UsuarioWS;

public class ContactoDetalleActivity extends Activity
{	
	private UsuarioWS usuarioWS = FactoryWS.getInstancia().getUsuarioWS();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_perfil_contacto);
		
		Bundle extras = getIntent().getExtras();
		Long idContacto = extras.getLong("idContactoSeleccionado");
		
		UsuarioDTO usuarioDTO = usuarioWS.obtener(idContacto);
		
    	TextView tt = (TextView) this.findViewById(R.id.nombre_perfil_contacto);
        TextView bt = (TextView) this.findViewById(R.id.email_perfil_contacto);
        ImageView it = (ImageView) this.findViewById(R.id.foto_perfil_contacto);
        
        tt.setText(usuarioDTO.getNombre());
        bt.setText(usuarioDTO.getEmail()); 
        if (!usuarioDTO.getUrlImagen().contains("http"))
        {
        	it.setImageResource(R.drawable.contact);
        }
        else
        {
        	it.setImageBitmap(BitMapImageConverter.getImageBitmap(usuarioDTO.getUrlImagen()));	
        }        
    }
    
    public void abrirChat (View v)
    {
    	Intent i = new Intent(this, ContactoChatActivity.class);
    	
	    // Creo la vista usando LocalActivityManager del SitioGroupActivity
	    View view = ContactoGroupActivity.group.getLocalActivityManager()
			        .startActivity("contacto_chat", i
			        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
			        .getDecorView();

	    // Remplazo la vista por la actual a cargar
	    ContactoGroupActivity.group.replaceView(view);
    }
}
