package com.example.helloworld2;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class PhoneCallActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_phone_call);
		
		Button call=(Button)findViewById(R.id.btnphonecall);
		call.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				EditText number=(EditText)findViewById(R.id.edtphonecall);
				String no=number.getText().toString();
				Intent callIntent=new Intent(Intent.ACTION_CALL);
				callIntent.setData(Uri.parse("tel:"+no));
				startActivity(callIntent);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.phone_call, menu);
		return true;
	}

}
