package com.geored.frontoffice.activities.contacto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.geored.dto.AmistadDTO;
import com.geored.dto.NotificacionDTO;
import com.geored.dto.TipoNotificacionDTO;
import com.geored.dto.UsuarioDTO;
import com.geored.frontoffice.activities.R;
import com.geored.frontoffice.utiles.BitMapImageConverter;
import com.geored.frontoffice.utiles.UtilesSeguridadAndroid;
import com.geored.frontoffice.wsclient.FactoryWS;
import com.geored.frontoffice.wsclient.GlobalWS;
import com.geored.frontoffice.wsclient.UsuarioWS;
import com.geored.utiles.ConstantesGenerales.TiposNotificacion;

public class ContactoDetalleActivity extends Activity
{	
	private UsuarioWS usuarioWS = FactoryWS.getInstancia().getUsuarioWS();
	
	private GlobalWS globalWS = FactoryWS.getInstancia().getGlobalWS();
	
	private UsuarioDTO usuarioDTO;
	
	private AmistadDTO amistadDTO;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_perfil_contacto);
		
		Bundle extras = getIntent().getExtras();
		Long idContacto = extras.getLong("idContactoSeleccionado");
		
		usuarioDTO = usuarioWS.obtener(idContacto);
		
    	TextView tt = (TextView) this.findViewById(R.id.nombre_perfil_contacto);
        TextView bt = (TextView) this.findViewById(R.id.email_perfil_contacto);
        TextView ta = (TextView) this.findViewById(R.id.amistad); 
        ImageView it = (ImageView) this.findViewById(R.id.foto_perfil_contacto);
        ImageButton ia = (ImageButton) this.findViewById(R.id.addRemoveAdmistad);
        
        tt.setText(usuarioDTO.getNombre());
        bt.setText(usuarioDTO.getEmail()); 
        
        //Sino tiene imagen de perfil le agrego una por defecto.
        if (!usuarioDTO.getUrlImagen().contains("http"))
        {
        	it.setImageResource(R.drawable.contact);
        }
        else
        {
        	it.setImageBitmap(BitMapImageConverter.getImageBitmap(usuarioDTO.getUrlImagen()));	
        }
        
        amistadDTO = usuarioWS.obtenerAmistadPorUsuarios(UtilesSeguridadAndroid.getUsuarioAutenticado(getApplicationContext()).getId(), usuarioDTO.getId());
        //Se carga la imagen y el texto para eliminar o agregar la nueva amistad.
        if (amistadDTO != null)
        {
        	ta.setText(getResources().getString(R.string.eliminarContacto));
        	ia.setImageResource(R.drawable.minus_icon);
        }
        else
        {
        	ta.setText(getResources().getString(R.string.agregarContacto));
        	ia.setImageResource(R.drawable.plus_icon);
        }        
    }
    
    public void ejecutarAccionAmistad(View v)
    {
    	if (amistadDTO != null)
    	{
    		//Eliminar Amistad
    		usuarioWS.eliminarAmistad(amistadDTO.getId());
    	}
    	else
    	{
    		//Enviar notificacion de amistad
    		TipoNotificacionDTO tipoNotificacion = globalWS.obtenerTipoNotificacionPorId(TiposNotificacion.ID_SOLICITUD);
    		
    		NotificacionDTO notificacion = new NotificacionDTO();
    		
    		notificacion.setIdTipoNotificacion(tipoNotificacion.getId());
    		notificacion.setNombreTipoNotificacion(tipoNotificacion.getNombre());
    		notificacion.setIdUsuarioDestino(usuarioDTO.getId());
    		notificacion.setDescripcion("Notificacion Solicitud amistad.s");
    		//notificacion.set)(UtilesSeguridadAndroid.getUsuarioAutenticado(getApplicationContext()).getId());
    		
    		usuarioWS.enviarNotificacion(notificacion);
    		
    	}
    }
    
    public void abrirChat (View v)
    {
	    	Intent i = new Intent(this, ContactoChatActivity.class);
	    	
			
		    i.putExtra("idContactoToChat", usuarioDTO.getId());	    
		    i.putExtra("nombreContactoToChat", usuarioDTO.getNombre());
		    i.putExtra("idAmistad", amistadDTO.getId());
		    // Creo la vista usando LocalActivityManager del SitioGroupActivity
		    View view = ContactoGroupActivity.group.getLocalActivityManager()
				        .startActivity("contacto_chat", i
				        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
				        .getDecorView();
	
		    // Remplazo la vista por la actual a cargar
		    ContactoGroupActivity.group.replaceView(view);
    	}
}
