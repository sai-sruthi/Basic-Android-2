package com.example.helloworld2;

import java.io.File;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MediaPlayerActivity extends Activity {
	Button start,stop,pause;
	MediaPlayer mp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_media_player);
		 mp=new MediaPlayer();
		start=(Button)findViewById(R.id.btnmpplay);
		stop=(Button)findViewById(R.id.btnmpstop);
		pause=(Button)findViewById(R.id.btnmppause);
		
		try{
			
			mp.setDataSource(Environment.getExternalStorageDirectory()+File.separator+"horizon.mp3");
			Toast.makeText(getApplicationContext(), Environment.getExternalStorageDirectory().getAbsolutePath(), Toast.LENGTH_LONG).show();
			mp.prepare();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		start.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			mp.start();
			Toast.makeText(getApplicationContext(), Environment.getExternalStorageDirectory().getPath(), Toast.LENGTH_LONG).show();
			Toast.makeText(getApplicationContext(), "Media Player Started", Toast.LENGTH_LONG).show();
			}
		});
		pause.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			mp.pause();	
			Toast.makeText(getApplicationContext(), "Media Player Paused", Toast.LENGTH_LONG).show();
			}
		});
		stop.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			mp.stop();	
			Toast.makeText(getApplicationContext(), "Media Player Stopped", Toast.LENGTH_LONG).show();
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.media_player, menu);
		return true;
	}

}
