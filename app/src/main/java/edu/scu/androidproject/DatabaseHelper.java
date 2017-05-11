package edu.scu.androidproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;




public class DatabaseHelper extends SQLiteOpenHelper {

   private static final String DatabaseName ="AndroidProject.db";
    private static final int DatabaseVersion =3;
    private static final String CreateQuery="CREATE TABLE "+"DatabaseName"+DatabaseContact.NewUserRegistration.TableName+"("+ DatabaseContact.NewUserRegistration.FirstName + " TEXT," + DatabaseContact.NewUserRegistration.LastName +" TEXT, " +DatabaseContact.NewUserRegistration.EmailAddress + "TEXT, "+DatabaseContact.NewUserRegistration.Password + "TEXT,"+DatabaseContact.NewUserRegistration.ConfirmPassword + "TEXT," +DatabaseContact.NewUserRegistration.UserName +" TEXT );";
  // SQLiteDatabase sqLiteDatabase=openOrCreateDatabase(DatabaseName,MODE_PRIVATE,null);

    //private SQLiteDatabase openOrCreateDatabase(String databaseName, int modePrivate, Object o) {

   // }

    public DatabaseHelper(Context context)
   {
       super(context,DatabaseName,null,DatabaseVersion);
       Log.e("DataBase Operations","Database Created");

   }
    @Override
    public void onCreate(SQLiteDatabase db) {
db.execSQL(CreateQuery);
        Log.e("Database Operation","TableCreated");
    }
public void insertInformation(String firstName,String lastName,String userName,String emailAddress,String password,String confirmPassword,SQLiteDatabase db){

    ContentValues contentValues=new ContentValues();
    contentValues.put(DatabaseContact.NewUserRegistration.FirstName,firstName);
    contentValues.put(DatabaseContact.NewUserRegistration.LastName,lastName);
    contentValues.put(DatabaseContact.NewUserRegistration.EmailAddress,emailAddress);
    contentValues.put(DatabaseContact.NewUserRegistration.Password,password);
    contentValues.put(DatabaseContact.NewUserRegistration.ConfirmPassword,confirmPassword);
    contentValues.put(DatabaseContact.NewUserRegistration.UserName,userName);
    db.insert(DatabaseContact.NewUserRegistration.TableName,null,contentValues);
    Log.e("Database Operation","One row is Inserted");
}
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //@Override

}
