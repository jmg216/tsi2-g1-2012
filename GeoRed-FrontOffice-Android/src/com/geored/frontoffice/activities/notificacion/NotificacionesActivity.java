package com.geored.frontoffice.activities.notificacion;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.geored.dto.NotificacionDTO;
import com.geored.frontoffice.activities.R;
import com.geored.frontoffice.utiles.AlertaDialogManager;
import com.geored.frontoffice.utiles.UtilesAndroid;
import com.geored.frontoffice.wsclient.FactoryWS;
import com.geored.frontoffice.wsclient.UsuarioWS;
import com.geored.utiles.ConstantesGenerales;

public class NotificacionesActivity extends Activity
{
	private static final String TAG = "NotificacionesActivity";
	
	private UsuarioWS usuarioWS = FactoryWS.getInstancia().getUsuarioWS();
	
	@Override
    public void onCreate(Bundle savedInstanceState) 
    {
    	super.onCreate(savedInstanceState);
    	 
    	setContentView(R.layout.activity_notificaciones);
    	
    	final List<NotificacionDTO> listaNotificacionesDTO = new ArrayList<NotificacionDTO>(UtilesAndroid.listaNotificaciones);
    	
    	// Si no hay notificaciones muestro un label
    	if(!listaNotificacionesDTO.isEmpty())
    	{    	
    		ListView listaNotificacionesView = (ListView) this.findViewById(R.id.listaNotificaciones);
        	
        	listaNotificacionesView.setAdapter(new ArrayAdapter<NotificacionDTO>(this, R.layout.row_notificacion_list, listaNotificacionesDTO)
        	{        	
        		@Override
        		public View getView(int position, View convertView, ViewGroup parent)
        		{
        			View v = convertView;
        			
        			if (convertView == null)
        			{
        				LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        				v = inflater.inflate(R.layout.row_notificacion_list, null);
        			}

        			final NotificacionDTO notificacionDTO = listaNotificacionesDTO.get(position);

        			if (notificacionDTO != null)
        			{
        				TextView rowDetalleNotificacion = (TextView) v.findViewById(R.id.rowDetalleNotificacion);
        				
        				rowDetalleNotificacion.setText(notificacionDTO.getDescripcion());
        				
        				Button buttonAceptar = (Button) v.findViewById(R.id.btnAceptarAmistad);
        				
    					buttonAceptar.setOnClickListener(new View.OnClickListener()
						{								
							public void onClick(View v)
							{
								usuarioWS.aceptarNotificacion(notificacionDTO.getId());
							}
						});
        			}

        			return v;
        		}
        	});
    	}
    }
}
