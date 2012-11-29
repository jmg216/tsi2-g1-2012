package com.geored.frontoffice.activities.sitio;

import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.geored.dto.SitioDTO;
import com.geored.frontoffice.activities.R;
import com.geored.frontoffice.utiles.BitMapImageConverter;

public class SitioAdapter extends ArrayAdapter<SitioDTO>  {

	private List<SitioDTO> items;
	
	public SitioAdapter(Context context, int textViewResourceId, List<SitioDTO> items) {
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
            
            SitioDTO sitio = items.get(position);
            if (sitio != null) 
            {
                    TextView tt = (TextView) v.findViewById(R.id.toptext);
                    TextView bt = (TextView) v.findViewById(R.id.bottomtext);
                    ImageView iv = (ImageView) v.findViewById(R.id.icon);
                    
                    tt.setText(sitio.getNombre());                            
                    bt.setText(sitio.getDescripcion());
                    //iv.setImageResource(R.drawable.marker3);
                    Bitmap bm = BitMapImageConverter.getImageBitmap(sitio.getUrlImagen());                    
                    iv.setImageBitmap(bm);
            }
            
            return v;	
    }
    
 
}
