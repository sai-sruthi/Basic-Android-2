package com.example.helloworld2;

import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DBActivity extends Activity {
	EditText id,name,number;
	Button save,delete,update,search;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_db);
		id=(EditText)findViewById(R.id.edtdbid);
		name=(EditText)findViewById(R.id.edtdbname);
		number=(EditText)findViewById(R.id.edtdbphno);
		save=(Button)findViewById(R.id.btndbsave);
		delete=(Button)findViewById(R.id.btndbdelete);
		update=(Button)findViewById(R.id.btndbupdate);
		search=(Button)findViewById(R.id.btndbsearch);
		final DataBaseHandler db=new DataBaseHandler(this);
				
		
		save.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				int _id=Integer.parseInt(id.getText().toString());
				String _name=name.getText().toString();
				String _phno=number.getText().toString();
				db.addContact(new Contact(_id,_name,_phno));
				Toast.makeText(getApplicationContext(), "Data Saved",Toast.LENGTH_LONG).show();
				
				//contact=db.getContact(_id);
				//String detail=contact.getName()+"\n"+contact.getPhoneNumber();
				//Toast.makeText(getApplicationContext(),detail , Toast.LENGTH_LONG).show();

				Log.d("Reading: ","Reading all contacts..");
				List<Contact> contacts;
				contacts=db.getAllContacts();

				for(Contact cn :contacts){
				String log ="Id: "+cn.getID()+" ,Name: "+cn.getName()+" ,Phone: "+cn.getPhoneNumber();
				Log.d("Name: ",log);
				}

				
			}});
		search.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				int _id=Integer.parseInt(id.getText().toString());
				Contact c=db.getContact(_id);
				id.setText(c.getID() + "");
				name.setText(c.getName());
				number.setText(c.getPhoneNumber());
			}
		});
		
		update.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				int _id=Integer.parseInt(id.getText().toString());
				String _name=name.getText().toString();
				String _phno=number.getText().toString();
				db.updateContact(new Contact(_id,_name,_phno));
				Toast.makeText(getApplicationContext(), "Contact Updated", Toast.LENGTH_LONG).show();
			}
		});
		delete.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				int _id=Integer.parseInt(id.getText().toString());
				db.deleteContact(_id);
				Toast.makeText(getApplicationContext(), "Contact Deleted", Toast.LENGTH_LONG).show();
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.db, menu);
		return true;
	}

}
