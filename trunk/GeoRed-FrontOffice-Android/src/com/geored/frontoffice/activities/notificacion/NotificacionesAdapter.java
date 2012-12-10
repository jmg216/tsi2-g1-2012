package com.geored.frontoffice.activities.notificacion;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.geored.dto.NotificacionDTO;
import com.geored.frontoffice.activities.R;

public class NotificacionesAdapter extends ArrayAdapter<NotificacionDTO>
{
	private List<NotificacionDTO> listaNotificacionesDTO;
	
	public NotificacionesAdapter(Context context, int textViewResourceId, List<NotificacionDTO> objects)
	{
		super(context, textViewResourceId, objects);
		
		this.listaNotificacionesDTO = objects;
	}

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
	
}