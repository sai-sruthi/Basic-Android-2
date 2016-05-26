package com.example.helloworld2;

import android.os.Bundle;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SMSActivity extends Activity {
	EditText number,message;
	Button sms;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sms);
		number=(EditText)findViewById(R.id.edtsmsnumber);
		message=(EditText)findViewById(R.id.edtsmsmessage);
		sms=(Button)findViewById(R.id.btnsms);
		sms.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String no=number.getText().toString();
				String msg=message.getText().toString();
				Intent i =new Intent(getApplicationContext(),SMSActivity.class);
				PendingIntent pi =PendingIntent.getActivity(getApplicationContext(), 0, i, 0);
				SmsManager sms=SmsManager.getDefault();
				sms.sendTextMessage(no, null, msg, pi, null);
				Toast.makeText(getApplicationContext(), "Message Sent", Toast.LENGTH_LONG).show();
						
				}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sm, menu);
		return true;
	}

}
