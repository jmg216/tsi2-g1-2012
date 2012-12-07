package com.geored.frontoffice.activities.sitio;

import java.util.ArrayList;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SitioGroupActivity extends ActivityGroup {
	
	
	public static SitioGroupActivity group;
	
	private ArrayList<View> history;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      this.history = new ArrayList<View>();
	      group = this;
	
	      // Activity Raiz
	      View view = getLocalActivityManager().startActivity("SitioActivity", new Intent(this,SitioActivity.class)
	    	      							.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
	    	                                .getDecorView();
	      
	      //Remplazo la vista de este ActivityGroup
	      replaceView(view);
	
	}
	
	public void replaceView(View v) 
	{
	    // Agrego la vista anterior
		history.add(v);
	    // seteo la nueva vista
		setContentView(v);
	}
	
	public void back() 
	{
		if(history.size() > 0) {
			history.remove(history.size()-1);
			setContentView(history.get(history.size()-1));
		}
		else 
		{
			finish();
		}
	}
	
	//CallBack para volver al paso anterior
	public void onBackPressed() {
		SitioGroupActivity.group.back();
	    return;
	}
}
