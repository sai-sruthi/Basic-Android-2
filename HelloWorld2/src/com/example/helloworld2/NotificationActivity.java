package com.example.helloworld2;

import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class NotificationActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notification);
		Button notif=(Button)findViewById(R.id.btnnotification);
		notif.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(getApplicationContext(),NotificationRecievedActivity.class);
				PendingIntent pi=PendingIntent.getActivity(getApplicationContext(), (int)System.currentTimeMillis(), i, 0);
				
				Notification noti=new Notification.Builder(getApplicationContext())
				.setContentTitle("New Notification")
				.setContentText("new text ").setSmallIcon(R.drawable.ic_launcher)
				.setContentIntent(pi)
				//can add 3 buttons like below
				.addAction(R.drawable.ic_launcher, "Call", pi)
				.build();
				
				NotificationManager nm=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
				
				noti.flags=Notification.FLAG_AUTO_CANCEL;
				
				nm.notify(0, noti);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.notification, menu);
		return true;
	}

}
