package edu.scu.androidproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;


public class SignUp extends Activity {
    EditText firstName, lastName, userName, emailAddress, password, confirmPassword;
    Context context = this;
    DatabaseHelper databaseHelper;
    SQLiteDatabase sqLiteDatabase;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Log.i("Intent Reached", "The sing up");
        setContentView(R.layout.activity_sign_up);
        Button reset=(Button)findViewById(R.id.resetbutton);
        Button register2Button = (Button) findViewById(R.id.registerbutton2);
        Log.i("Launched Signup","");
        Log.i("Button can be pressed","");
        register2Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.i("Button pressed","");
                firstName = (EditText) findViewById(R.id.fName);
                lastName = (EditText) findViewById(R.id.lName);
                userName = (EditText) findViewById(R.id.userName);
                emailAddress = (EditText) findViewById(R.id.email);
                password = (EditText) findViewById(R.id.pass);
                confirmPassword = (EditText) findViewById(R.id.cPass);
                register2(v);

                //Log.i("Going to call Db", "");
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Reset Button Press","");
                System.exit(0);
            }
        });


        /*register2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                                Log.i("Calling Db", "");
                dataBase();
            }
        });*/


    }

    //public void dataBase() {
      //  setContentView(R.layout.activity_sign_in);

        //Log.i("This is register3", "I came");

    //}

    public void register2(View view) {
        String fname1 = firstName.getText().toString();
        String lname1 = lastName.getText().toString();
        String username1 = userName.getText().toString();
        String emailaddress = emailAddress.getText().toString();
        String passw = password.getText().toString();
        String cpassw = confirmPassword.getText().toString();
        Log.v("FirstName","fname1"+fname1);
        databaseHelper = new DatabaseHelper(context);
        sqLiteDatabase = databaseHelper.getWritableDatabase();
        databaseHelper.insertInformation(fname1, lname1, username1, emailaddress, passw, cpassw, sqLiteDatabase);
        Toast.makeText(getBaseContext(), "Data Saved", Toast.LENGTH_LONG).show();
        databaseHelper.close();






        //setContentView(R.layout.activity_sign_in);
    }
}