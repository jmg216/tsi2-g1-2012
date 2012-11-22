package com.geored.frontoffice.activities.contacto;

import java.util.ArrayList;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ContactoGroupActivity extends ActivityGroup {
		
	public static ContactoGroupActivity group;
	
	private ArrayList<View> history;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      this.history = new ArrayList<View>();
	      group = this;
	
	      // Activity Raiz
	      View view = getLocalActivityManager().startActivity("ContactoActivity", new Intent(this, ContactoActivity.class)
	    	      							.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
	    	                                .getDecorView();
	      
	      //Remplazo la vista de este ActivityGroup
	      replaceView(view);
	
	}
	
	public void replaceView(View v) 
	{
	    // Agrego la vista al history
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
		ContactoGroupActivity.group.back();
	    return;
	}
}
