package com.geored.frontoffice.activities.sitio;

import java.util.List;

import com.geored.frontoffice.activities.R;
import com.geored.frontoffice.dto.SitioADTO;
import com.geored.frontoffice.utiles.BitMapImageConverter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SitioAdapter extends ArrayAdapter<SitioADTO>  {

	private List<SitioADTO> items;
	
	public SitioAdapter(Context context, int textViewResourceId, List<SitioADTO> items) {
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
                v = inflater.inflate(R.layout.row_contact_list, null);
            }
            
            SitioADTO sitio = items.get(position);
            if (sitio != null) 
            {
                    TextView tt = (TextView) v.findViewById(R.id.toptext);
                    TextView bt = (TextView) v.findViewById(R.id.bottomtext);
                    ImageView iv = (ImageView) v.findViewById(R.id.icon);
                    
                    tt.setText(sitio.getNombre());                            
                    bt.setText(sitio.getDescripcion());
                    //iv.setImageResource(R.drawable.marker3);
                    Bitmap bm = BitMapImageConverter.getImageBitmap(sitio.getImagen());                    
                    iv.setImageBitmap(bm);
            }
            
            return v;	
    }
    
 
}
