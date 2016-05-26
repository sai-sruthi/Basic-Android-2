package com.example.helloworld2;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.view.Menu;
import android.widget.TextView;

public class DisplayContactsActivity extends Activity {
	TextView show;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_contacts);
		show=(TextView)findViewById(R.id.txtcontacts);
		readContacts();
	}
	public void readContacts(){
		StringBuffer s=new StringBuffer();
		
		ContentResolver cr=getContentResolver();
		Cursor cursor=cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null,null);
		String name,phone,email;
		if(cursor.getCount()>0){
			while(cursor.moveToNext()){
				
				String id=cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
				name=cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
				if(Integer.parseInt(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)))>0){
					s.append("\nContact Name:"+name);
					Cursor curs=cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,ContactsContract.CommonDataKinds.Phone.CONTACT_ID+"=?", new String[]{id},null);
					while(curs.moveToNext()){
						phone=curs.getString(curs.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
						s.append("\n Phone Number:"+phone);
					}
					curs.close();
					/*For Email
					 * 
					 */
					Cursor mailcur=cr.query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, null,ContactsContract.CommonDataKinds.Email.CONTACT_ID+"=?", new String[]{id},null);
					while(mailcur.moveToNext()){
						email=mailcur.getString(mailcur.getColumnIndex(ContactsContract.CommonDataKinds.Email.DATA));
						s.append("\n Email: "+email);
					}
					mailcur.close();
				}
				s.append("\n..............................");
			}
			show.setText(s);
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_contacts, menu);
		return true;
	}

}
