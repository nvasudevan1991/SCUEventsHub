package edu.scu.androidproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLClientInfoException;

/**
 * Created by nithi on 5/5/2017.
 */

public class DbHelper extends SQLiteOpenHelper {
    private static final int Database_version =1;
    private static final String Database_Name = "EventApp.db";
    private static final String Table_Name = "EventApp1";
    private static final String Column_Fname ="fName";
    private static final String Column_Lname = "lName";
    private static final String Column_Email="email";
    private static final String Column_Password= "pass";
    private static final String Column_UserName="userName";
    SQLiteDatabase db;
    private static final String Table_Create = "CREATE TABLE EventApp1 (userName VARCHAR(200) PRIMARY KEY NOT NULL,pass VARCHAR(200) NOT NULL,email VARCHAR(200) NOT NULL,lName VARCHAR(200) NOT NULL,fName VARCHAR(200) NOT NULL)";

    public  DbHelper(Context context)
    {
        super(context,Database_Name,null,Database_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Table_Create);
        this.db=db;

    }
    public void insertContact(DbContact c)

    {
        String query1="select * from EventApp1 ";
        Cursor cursor=db.rawQuery(query1,null);
        db = this.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put(Column_Fname,c.getfName());
        values.put(Column_Lname,c.getlName());
        values.put(Column_Email,c.getEmail());
        values.put(Column_Password,c.getPass());
        values.put(Column_UserName,c.getUserName());
        db.insert(Table_Name,null,values);
        db.close();
    }

    public String searchPass(String Uname)
    {
        db=this.getReadableDatabase();
        String query ="Select Uname,pass from "+Table_Name;
        Cursor cursor = db.rawQuery(query,null);
        String a,b;
        b="Not Found";
        if(cursor.moveToFirst()) {
            do {
                a = cursor.getString(0);

                if (a.equals(Uname)) {
                    b = cursor.getString(1);
                    break;
                }
            } while (cursor.moveToNext());


        }
        return b;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query= "Drop Table if Exists "+ Table_Name;
        db.execSQL(query);
        this.onCreate(db);

    }
}
