package edu.scu.androidproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class DbHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 2;

    // Database Name
    private static final String DATABASE_NAME = "UserManager";

    // User table name
    private static final String TABLE_USER = "user";

    // Events Table
    //private static final String TABLE_EVENTS= "Events";
    // User Table Columns names
    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_USER_NAME = "user_name";
    private static final String COLUMN_USER_FNAME = "user_firstname";
    private static final String COLUMN_USER_LNAME = "user_lastname";
    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_USER_PASSWORD = "user_password";
    private static final String COLUMN_USER_CONFIRM_PASSWORD = "user_confirmpassword";
    // Events Table Column name
    /*
    private static  final String COLUMN_EVENT_ID = "event_id";
    private static final String COLUMN_EVENT_TITLE = "event_title";
    private static final String COLUMN_EVENT_DESCRIPTION = "event_description";
    private static final String COLUMN_EVENT_DEPARTMENT= "event_dept";
    private static final String COLUMN_EVENT_TIME = "event_time";
    private static final String COLUMN_EVENT_VENUE ="event_venue";
    private static final String  COLUMN_EVENT_DURATION ="event_duration";
    private static final String COLUMN_EVENT_RSVP ="event_rsvp";
    private static final String COLUMN_EVENT_DATE ="event_date";
*/
    // create table sql query
    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_USER_FNAME + " TEXT," + COLUMN_USER_LNAME + " TEXT," + COLUMN_USER_EMAIL + " TEXT,"
            + COLUMN_USER_PASSWORD + " TEXT," + COLUMN_USER_CONFIRM_PASSWORD + " TEXT" + ")";
  //  private String CREATE_EVENTS_TABLE ="CREATE TABLE " + TABLE_EVENTS + "(" + COLUMN_EVENT_ID + "INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_EVENT_TITLE + "TEXT," + COLUMN_EVENT_DESCRIPTION + "TEXT," + COLUMN_EVENT_DEPARTMENT + "TEXT," + COLUMN_EVENT_DEPARTMENT + "TEXT," + COLUMN_EVENT_TIME + "TIME," + COLUMN_EVENT_VENUE + "TEXT," + COLUMN_EVENT_DURATION + "INTEGER,"
    //        + COLUMN_EVENT_DATE + "TEXT," + COLUMN_EVENT_RSVP + "TEXT" + ")";
     // drop table sql query
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;

    //private String DROP_EVENTS_TABLE = "DROP TABLE IF EXISTS " + TABLE_EVENTS;

    /**
     * Constructor
     *
     * @param context
     */
    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
      //  db.execSQL(CREATE_EVENTS_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drop User Table if exist
        db.execSQL(DROP_USER_TABLE);
        //db.execSQL(DROP_EVENTS_TABLE);

        // Create tables again
        onCreate(db);

    }

    /**
     * This method is to create user record
     *
     * @param user
     */

    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_FNAME, user.getFirstName());
        values.put(COLUMN_USER_LNAME, user.getLastName());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());
        values.put(COLUMN_USER_CONFIRM_PASSWORD, user.getConfirmPassword());

        // Inserting Row
        db.insert(TABLE_USER, null, values);
        db.close();

    }
    public List<String> Select(String email) {
        String itemId = null;
        String itemId1 = null;
        String itemId2 = null;
        String itemId3 = null;
        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_NAME,
                COLUMN_USER_FNAME,
                COLUMN_USER_LNAME,
                COLUMN_USER_EMAIL

        };
        SQLiteDatabase db = this.getReadableDatabase();

        // selection criteria
        String selection = COLUMN_USER_EMAIL + " = ?";

        // selection argument
        String[] selectionArgs = {email};

        // query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com';
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        List<String> itemIds = new ArrayList<>();
        while(cursor.moveToNext()) {
            itemId = cursor.getString(
                    cursor.getColumnIndexOrThrow(COLUMN_USER_NAME));
            itemId1 = cursor.getString(
                    cursor.getColumnIndexOrThrow(COLUMN_USER_FNAME));
            itemId2 = cursor.getString(
                    cursor.getColumnIndexOrThrow(COLUMN_USER_LNAME));
            itemId3 = cursor.getString(
                    cursor.getColumnIndexOrThrow(COLUMN_USER_EMAIL));
            Log.i("hello",itemId);
            itemIds.add(itemId);
            itemIds.add(itemId1);
            itemIds.add(itemId2);
            itemIds.add(itemId3);
        }
        cursor.close();
        db.close();

        /* int cursorCount = cursor.getCount();
        Log.i("length",String.valueOf(cursorCount));
      //  cursor.getColumnIndex("ContactNumber")
        String str1 = cursor.getString(cursor.getColumnIndex("ContactNumber"));
        Log.i("hello",str1);
        cursor.close();
        db.close();
*/
//        if (cursorCount > 0) {
//            return true;
//        }

        return itemIds;
    }



    /**
     * This method is to fetch all user and return the list of user records
     *
     * @return list
     */
    public List<User> getAllUser() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID,
                COLUMN_USER_NAME,
                COLUMN_USER_FNAME,
                COLUMN_USER_LNAME,
                COLUMN_USER_EMAIL,
                COLUMN_USER_PASSWORD,
                COLUMN_USER_CONFIRM_PASSWORD
        };
        // sorting orders
        String sortOrder =
                COLUMN_USER_NAME + " ASC";
        List<User> userList = new ArrayList<User>();

        SQLiteDatabase db = this.getReadableDatabase();

        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_USER_ID))));
                user.setName(cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME)));
                user.setFirstName(cursor.getString(cursor.getColumnIndex(COLUMN_USER_FNAME)));
                user.setLastName(cursor.getString(cursor.getColumnIndex(COLUMN_USER_LNAME)));
                user.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_USER_EMAIL)));
                user.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD)));
                user.setConfirmPassword(cursor.getString(cursor.getColumnIndex(COLUMN_USER_CONFIRM_PASSWORD)));
                // Adding user record to list
                userList.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return userList;
    }

    /*public void Select(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor ch = db.rawQuery("SELECT * FROM user WHERE COLUMN_USER_EMAIL = ?", new String[] {email});
        if(ch.moveToFirst()){
            do{
                //assing values
                String column1 = ch.getString(0);
                String column2 = ch.getString(1);
                String column3 = ch.getString(2);
                //Do something Here with values
                Log.i(column1,column2);

            }while(ch.moveToNext());
        }
        ch.close();
        db.close();
    }
*/
    public List<String> Select(String email) {
        String itemId = null;
        String itemId1 = null;
        String itemId2 = null;
        String itemId3 = null;
        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_NAME,
                COLUMN_USER_FNAME,
                COLUMN_USER_LNAME,
                COLUMN_USER_EMAIL

        };
        SQLiteDatabase db = this.getReadableDatabase();

        // selection criteria
        String selection = COLUMN_USER_EMAIL + " = ?";

        // selection argument
        String[] selectionArgs = {email};

        // query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com';
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        List<String> itemIds = new ArrayList<>();
        while(cursor.moveToNext()) {
             itemId = cursor.getString(
                    cursor.getColumnIndexOrThrow(COLUMN_USER_NAME));
            itemId1 = cursor.getString(
                    cursor.getColumnIndexOrThrow(COLUMN_USER_FNAME));
            itemId2 = cursor.getString(
                    cursor.getColumnIndexOrThrow(COLUMN_USER_LNAME));
            itemId3 = cursor.getString(
                    cursor.getColumnIndexOrThrow(COLUMN_USER_EMAIL));
            Log.i("hello",itemId);
            itemIds.add(itemId);
            itemIds.add(itemId1);
            itemIds.add(itemId2);
            itemIds.add(itemId3);
        }
        cursor.close();
        db.close();

        /* int cursorCount = cursor.getCount();
        Log.i("length",String.valueOf(cursorCount));
      //  cursor.getColumnIndex("ContactNumber")
        String str1 = cursor.getString(cursor.getColumnIndex("ContactNumber"));
        Log.i("hello",str1);
        cursor.close();
        db.close();
*/
//        if (cursorCount > 0) {
//            return true;
//        }

        return itemIds;
    }

    /**
     * This method to update user record
     *
     * @param user
   /*
 /*   public void updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_FNAME, user.getFirstName());
        values.put(COLUMN_USER_LNAME, user.getLastName());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());
        values.put(COLUMN_USER_CONFIRM_PASSWORD, user.getConfirmPassword());

        // updating row
        db.update(TABLE_USER, values, COLUMN_USER_ID + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();
    } */

    /**
     * This method is to delete user record
     *
     * @param user
     */
   /* public void deleteUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        // delete user record by id
        db.delete(TABLE_USER, COLUMN_USER_ID + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();
    }*/

    /**
     * This method to check user exist or not
     *
     * @param email
     * @return true/false
     */
    public boolean checkUser(String email) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();

        // selection criteria
        String selection = COLUMN_USER_EMAIL + " = ?";

        // selection argument
        String[] selectionArgs = {email};

        // query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com';
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        }

        return false;
    }

    /**
     * This method to check user exist or not
     *
     * @param email
     * @param password
     * @return true/false
     */
    public boolean checkUser(String email, String password) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = COLUMN_USER_EMAIL + " = ?" + " AND " + COLUMN_USER_PASSWORD + " = ?";

        // selection arguments
        String[] selectionArgs = {email, password};

        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;
    }
}