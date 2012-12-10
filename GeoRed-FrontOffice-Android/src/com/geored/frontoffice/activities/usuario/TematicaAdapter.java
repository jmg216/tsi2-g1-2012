package com.geored.frontoffice.activities.usuario;

import java.util.List;

import com.geored.dto.SitioDTO;
import com.geored.dto.TematicaDTO;
import com.geored.frontoffice.activities.R;
import com.geored.frontoffice.utiles.BitMapImageConverter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class TematicaAdapter extends ArrayAdapter<TematicaDTO>{
	
	private List<TematicaDTO> items;
	
	
	public TematicaAdapter(Context context, int textViewResourceId, List<TematicaDTO> items) {
		super(context, textViewResourceId, items);
		this.items = items;
		
	}
	
	@Override
    public View getView(int position, View convertView, ViewGroup parent) 
    {
            View v = convertView;
            if (convertView == null) 
            {
            	LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = inflater.inflate(R.layout.row_tematica_check_list, null);
            }
            
            TematicaDTO tematica = items.get(position);
            if (tematica != null) 
            {
                    TextView tt = (TextView) v.findViewById(R.id.code);
                                                          
                    tt.setText(tematica.getNombre());                  
                    
                    
            }
            
            return v;	
    }
	
}
