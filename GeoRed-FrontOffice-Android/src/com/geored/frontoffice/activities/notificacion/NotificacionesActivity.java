package com.geored.frontoffice.activities.notificacion;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.geored.dto.NotificacionDTO;
import com.geored.frontoffice.activities.R;
import com.geored.frontoffice.utiles.UtilesAndroid;

public class NotificacionesActivity extends Activity
{
	private static final String TAG = "NotificacionesActivity";
	
	@Override
    public void onCreate(Bundle savedInstanceState) 
    {
    	super.onCreate(savedInstanceState);
    	 
    	setContentView(R.layout.activity_notificaciones);
    	
    	final List<NotificacionDTO> listaNotificacionesDTO = new ArrayList<NotificacionDTO>(UtilesAndroid.listaNotificaciones);
    	
    	// Si no hay notificaciones muestro un label
    	if(listaNotificacionesDTO.isEmpty())
    	{    	
    		TextView txtMensajeSinNotificaciones = new TextView(this);
    		
    		txtMensajeSinNotificaciones.setText("No hay notificaciones");
    		
    		this.addContentView(txtMensajeSinNotificaciones, null);
    	}
    	
    	// Si no muestro la lista 
    	else
    	{
    		ListView listaNotificacionesView = new ListView(this);
        	
        	listaNotificacionesView.setAdapter(new ArrayAdapter<NotificacionDTO>(this, R.layout.row_contact_list, listaNotificacionesDTO)
        	{        	
        		@Override
        		public View getView(int position, View convertView, ViewGroup parent)
        		{
        			View v = convertView;
        			
        			if (convertView == null)
        			{
        				LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        				v = inflater.inflate(R.layout.row_contact_list, null);
        			}

        			NotificacionDTO notificacionDTO = listaNotificacionesDTO.get(position);

        			if (notificacionDTO != null)
        			{
        				TextView rowDetalleNotificacion = (TextView) v.findViewById(R.id.rowDetalleNotificacion);
        				
        				rowDetalleNotificacion.setText(notificacionDTO.getDescripcion());
        			}

        			return v;
        		}
        	});
    	}
    }
}
