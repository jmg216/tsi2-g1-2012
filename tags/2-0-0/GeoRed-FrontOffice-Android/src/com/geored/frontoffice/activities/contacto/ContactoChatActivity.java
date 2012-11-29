package com.geored.frontoffice.activities.contacto;

import android.app.Activity;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.geored.frontoffice.activities.R;

public class ContactoChatActivity extends Activity
{
	private EditText messageText;
	private EditText messageHistoryText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chat);
		
		messageHistoryText = (EditText) findViewById(R.id.messageHistory);
		
		messageText = (EditText) findViewById(R.id.message);
		messageText.requestFocus();	
		
		Bundle extras = this.getIntent().getExtras();		
		String msg = extras.getString("mensaje");
		
		if (msg != null) 
		{
		}		
		
	}
	
	public void enviarMensaje(View view)
	{
		
	}
}