package com.example.helloworld2;

import java.io.File;
import java.io.IOException;

import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class RecorderActivity extends Activity {
	MediaRecorder r;
	File audiof=null;
	static final String TAG="Media Recording";
	Button start,stop;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recorder);
		start=(Button)findViewById(R.id.btnrecstart);
		stop=(Button)findViewById(R.id.btnrecstop);

		start.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			
			start.setEnabled(false);
			stop.setEnabled(true);
			File dir=Environment.getExternalStorageDirectory();
			try {
				audiof=File.createTempFile("sound", ".3gp", dir);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			r=new MediaRecorder();
			r.setAudioSource(MediaRecorder.AudioSource.MIC);
			r.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
			r.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
			r.setOutputFile(audiof.getAbsolutePath());
			try {
				r.prepare();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			r.start();
		}
		});
	
		stop.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			start.setEnabled(true);
			stop.setEnabled(false);
			r.stop();
			r.release();
			addRecording();
			}
			
		});
		
	}	
		public void addRecording(){
			ContentValues cv=new ContentValues(4);
			long current=System.currentTimeMillis();
			cv.put(MediaStore.Audio.Media.TITLE,"audio"+audiof.getName());
			cv.put(MediaStore.Audio.Media.DATE_ADDED,(int)(current/1000) );
			cv.put(MediaStore.Audio.Media.MIME_TYPE, "audio/3gpp");
			cv.put(MediaStore.Audio.Media.DATA, audiof.getAbsolutePath());
			ContentResolver cr=getContentResolver();
			Uri base=MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
			Uri newUri=cr.insert(base, cv);
			sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,newUri));
			Toast.makeText(getApplicationContext(), "Added File"+newUri, Toast.LENGTH_LONG).show();
			
		}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.recorder, menu);
		return true;
	}

}
