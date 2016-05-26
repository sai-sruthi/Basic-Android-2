package com.example.helloworld2;

import java.util.ArrayList;
import java.util.List;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHandler extends SQLiteOpenHelper{
	private static final String DATABASE_NAME= "contactsManager";
	private static final int DATABASE_VERSION=1;
	private static final String TABLE_CONTACTS="contacts";
	private static final String KEY_ID="ID";
	private static final String KEY_NAME="name";
	private static final String KEY_PH_NO="phone_no";
	
	
	public DataBaseHandler(Context context) {
		// TODO Auto-generated constructor stub
		super(context,DATABASE_NAME,null,DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
	//	String CREATE_CONTACTS_TABLE ="CREATE TABLE "+TABLE_CONTACTS+"("+KEY_ID+" INTEGER PRIMARY KEY,"+KEY_NAME+" TEXT,"+KEY_PH_NO+  " TEXT" + ")";
	String CREATE_CONTACTS_TABLE="create table contacts(ID integer primary key,name text,phone_no text)";
		db.execSQL(CREATE_CONTACTS_TABLE);
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
		// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
			onCreate(db);
			}
	public void addContact(Contact contact){
	
		SQLiteDatabase db=this.getWritableDatabase();
		ContentValues values =new ContentValues();
		values.put(KEY_NAME,contact.getName());// Contact Name  
	    values.put(KEY_PH_NO,contact.getPhoneNumber());// Contact Phone  
		// Inserting Row  
	    db.insert(TABLE_CONTACTS,null,values);
	    //2nd argument is String containing nullColumnHack  
	   db.close();
	    // Closing database connection  
}
		// code to get the single contact  
       public Contact getContact(int id){
			SQLiteDatabase db=this.getReadableDatabase();
			Cursor cursor=db.query("contacts",new String[]{"ID","name","phone_no"}, "id=?", new String[]{String.valueOf(id)},null, null,null,null);
			if(cursor !=null){
	        cursor.moveToFirst();
	        Contact contact = new Contact(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2));
			return contact;}
	        else{
	        Contact contact	=new Contact(0,"Does not exist","");
	        return contact;}
			      }
       
       
       public List<Contact> getAllContacts(){
    	   List<Contact> contactList= new ArrayList<Contact>();
    	   String selectQuery="SELECT * FROM "+TABLE_CONTACTS;
    	   SQLiteDatabase db=this.getWritableDatabase();
    	   Cursor cursor=db.rawQuery(selectQuery, null);
    	   if(cursor.moveToFirst()){
    		   do{
    			   Contact contact = new Contact(0, null, null);
    			   contact.setID(Integer.parseInt(cursor.getString(0)));
    			   contact.setName(cursor.getString(1));
    			   contact.setPhoneNumber(cursor.getString(2));
    			   contactList.add(contact);
    		   }while(cursor.moveToNext());
    		  }
    	   return contactList;
       }
       
      public int updateContact(Contact contact){
    	  SQLiteDatabase db=this.getWritableDatabase();
    	  ContentValues values=new ContentValues();
    	  values.put(KEY_ID, contact.getID());
    	  values.put(KEY_NAME, contact.getName());
    	  values.put(KEY_PH_NO, contact.getPhoneNumber());
    	  return db.update("contacts", values, "ID=?", new String[]{String.valueOf(contact.getID())});
    	  }
      public void deleteContact(int id){
    	  SQLiteDatabase db =this.getWritableDatabase();
    	  db.delete("contacts", "ID=?", new String[]{String.valueOf(id)});
    	  db.close();
      }
      public int getContactsCount(){
    	  String countQuery="SELECT * FROM"+TABLE_CONTACTS;
    	  SQLiteDatabase db=this.getReadableDatabase();
    	  Cursor cursor =db.rawQuery(countQuery, null);
    	  cursor.close();
    	   return cursor.getCount();
      }
       
	
       

}
