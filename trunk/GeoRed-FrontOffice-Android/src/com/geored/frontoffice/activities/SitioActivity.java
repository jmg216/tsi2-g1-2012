package com.geored.frontoffice.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SitioActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	TextView textview = new TextView(this);
    	textview.setText("Esta es la pestaña Sitios");
    	setContentView(textview);        
    }
}
