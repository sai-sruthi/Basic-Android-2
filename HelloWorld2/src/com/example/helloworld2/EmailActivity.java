package com.example.helloworld2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class EmailActivity extends Activity {
	EditText to,subject,message;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_email);
		to=(EditText)findViewById(R.id.edtmailto);
		subject=(EditText)findViewById(R.id.edtmailsub);
		message=(EditText)findViewById(R.id.edtmailmsg);
		Button send=(Button)findViewById(R.id.btnmail);
		send.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String to_=to.getText().toString();
				String sub=subject.getText().toString();
				String msg=message.getText().toString();
				
				Intent email=new Intent(Intent.ACTION_SEND);
				email.putExtra(Intent.EXTRA_EMAIL, new String[]{to_});
				email.putExtra(Intent.EXTRA_SUBJECT, sub);
				email.putExtra(Intent.EXTRA_TEXT, msg);
				
				email.setType("message/rfc822");
				
				startActivity(Intent.createChooser(email, "Choose an Email client:"));
				
				
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.email, menu);
		return true;
	}

}
