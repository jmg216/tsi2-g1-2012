package com.geored.frontoffice.activities.contacto;

import java.util.List;

import com.geored.frontoffice.activities.R;
import com.geored.frontoffice.dto.UsuarioADTO;
import com.geored.frontoffice.utiles.BitMapImageConverter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactoAdapter extends ArrayAdapter<UsuarioADTO> {
	
    private List<UsuarioADTO> items;

    public ContactoAdapter(Context context, int textViewResourceId, List<UsuarioADTO> items) {
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
            
            UsuarioADTO usuario = items.get(position);
            
            if (usuario != null) 
            {
                    TextView tt = (TextView) v.findViewById(R.id.toptext);
                    TextView bt = (TextView) v.findViewById(R.id.bottomtext);
                    ImageView iv = (ImageView) v.findViewById(R.id.icon);
                    
                    tt.setText(usuario.getNombre());                            
                    bt.setText(usuario.getEmail());

                    //Si el usuario no tiene imagen para su perfil se le asigna una por defecto.
                    //Las imagenes tiene que ser URLs
                    if (!usuario.getUrlImagen().contains("http"))
                    {
                    	iv.setImageResource(R.drawable.contact);
                    }
                    else
                    {
                    	Bitmap bm = BitMapImageConverter.getImageBitmap(usuario.getUrlImagen());	
                    	iv.setImageBitmap(bm);
                    }                                        
            }
            
            return v;
    }      
}
