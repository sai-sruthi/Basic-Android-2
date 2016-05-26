package com.example.helloworld2;

import java.io.File;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.view.Menu;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_video_view);
		VideoView v=(VideoView)findViewById(R.id.videoView1);
		MediaController mc=new MediaController(this);
		mc.setAnchorView(v);
		Uri uri=Uri.parse(Environment.getExternalStorageDirectory()+File.separator+"Amma.mp4");
		v.setMediaController(mc);
		v.setVideoURI(uri);
		v.requestFocus();
		v.start();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.video_view, menu);
		return true;
	}

}
