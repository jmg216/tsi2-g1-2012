package com.geored.frontoffice.activities;

import java.util.ArrayList;
import java.util.List;

import com.geored.frontoffice.R;
import com.geored.frontoffice.dto.UsuarioADTO;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.app.Activity;

public class ContactosAdapter extends ArrayAdapter<UsuarioADTO> {
	
    private List<UsuarioADTO> items;
    //private static LayoutInflater inflater = null;

    public ContactosAdapter(Context context, int textViewResourceId, List<UsuarioADTO> items) {
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
                    tt.setText(usuario.getNombre());                            
                    bt.setText(usuario.getEmail());
            }
            
            return v;
    }
}
