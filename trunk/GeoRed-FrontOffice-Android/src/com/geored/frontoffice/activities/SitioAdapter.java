package com.geored.frontoffice.activities;

import java.util.List;

import com.geored.frontoffice.dto.SitioADTO;

import android.content.Context;
import android.widget.ArrayAdapter;


public class SitioAdapter  extends ArrayAdapter<SitioADTO>  {

	public SitioAdapter(Context context, int textViewResourceId, List<SitioADTO> objects) {
		super(context, textViewResourceId, objects);
		// TODO Auto-generated constructor stub
	}

}
