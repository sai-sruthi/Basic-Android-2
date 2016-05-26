package com.example.helloworld2;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class ImageActivity extends Activity {
	Button b;
	ImageView iv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image);
		b=(Button)findViewById(R.id.btnimage);
		iv=(ImageView)findViewById(R.id.imageView1);
		b.setOnClickListener(new OnClickListener() {
			
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				iv.setImageResource(R.drawable.i);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.image, menu);
		return true;
	}

}
