package com.example.helloworld2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ExternalActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_external);
		 Button save=(Button)findViewById(R.id.btnsaveextern);
	     Button read=(Button)findViewById(R.id.btnreadextern);
	     save.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					 EditText edtfilename=(EditText)findViewById(R.id.edtfnameextern);
				     EditText edtdata=(EditText)findViewById(R.id.edtdataextern);
					String name= edtfilename.getText().toString();
					String data=edtdata.getText().toString();
					
					try{
						File myFile =new File(Environment.getExternalStorageDirectory()+File.separator+name);
						myFile.createNewFile();
						FileOutputStream fo=new FileOutputStream(myFile);
						fo=openFileOutput(name, Context.MODE_PRIVATE);
						fo.write(data.getBytes());
						fo.close();
						Toast.makeText(getApplicationContext(),name+"saved",Toast.LENGTH_LONG).show();
					}
					catch(FileNotFoundException e)
					{e.printStackTrace();}
					catch(IOException e){
						e.printStackTrace();
					}
				}
			});
	        read.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					EditText edtfilename=(EditText)findViewById(R.id.edtfilename);
					//EditText edtdata=(EditText)findViewById(R.id.edtdataextern);
					String name= edtfilename.getText().toString();
					StringBuffer sb=new StringBuffer();
					String aDataRow="";
					String aBuffer="";
					
					try{
						File myFile=new File("/sdcard/"+name);
						FileInputStream fIn =new FileInputStream(myFile);
						BufferedReader br=new BufferedReader(new InputStreamReader(fIn));
						
						while((aDataRow =br.readLine())!=null)
						{
							aBuffer+=aDataRow+"\n";
							}
						br.close();
			

						
					}
					catch(IOException e){
						e.printStackTrace();
					}
					Toast.makeText(getApplicationContext(),sb.toString(),Toast.LENGTH_LONG).show();
					
				}
			});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.external, menu);
		return true;
	}

}
