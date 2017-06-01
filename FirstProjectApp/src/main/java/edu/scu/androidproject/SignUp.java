package edu.scu.androidproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SignUp extends AppCompatActivity {
    EditText firstName, lastName, userName, emailAddress, password, confirmPassword;
    Context context = this;
    DbHelper databaseHelper;
    SQLiteDatabase sqLiteDatabase;
    User user;
    private final AppCompatActivity activity = SignUp.this;

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
                firstName.setText(null);
                lastName.setText(null);
                userName.setText(null);
                emailAddress.setText(null);
                password.setText(null);
                confirmPassword.setText(null);
            }
        });}




    public void register2(View view) {
        String fname1 = firstName.getText().toString();
        String lname1 = lastName.getText().toString();
        String username1 = userName.getText().toString();
        String emailaddress = emailAddress.getText().toString();
        String passw = password.getText().toString();
        String cpassw = confirmPassword.getText().toString();
        Log.v("FirstName","fname1"+fname1);
        databaseHelper = new DbHelper(activity);
        user = new User();
        //  databaseHelper = new DatabaseHelper(context);
        //  sqLiteDatabase = databaseHelper.getWritableDatabase();
        //  DbHelper.insertInformation(fname1, lname1, username1, emailaddress, passw, cpassw, sqLiteDatabase);
        //  Toast.makeText(getBaseContext(), "Data Saved", Toast.LENGTH_LONG).show();
        //  databaseHelper.close();
        if (!databaseHelper.checkUser(emailAddress.getText().toString().trim())){


            user.setName(userName.getText().toString().trim());
            user.setFirstName(firstName.getText().toString().trim());
            user.setLastName(lastName.getText().toString().trim());
            user.setEmail(emailAddress.getText().toString().trim());
            user.setPassword(password.getText().toString().trim());
            user.setConfirmPassword(confirmPassword.getText().toString().trim());

            databaseHelper.addUser(user);
            Toast.makeText(getBaseContext(), "Data Saved", Toast.LENGTH_LONG).show();
            firstName.setText(null);
            lastName.setText(null);
            userName.setText(null);
            emailAddress.setText(null);
            password.setText(null);
            confirmPassword.setText(null);
            // Snack Bar to show success message that record saved successfully
            //     Snackbar.make(nestedScrollView, getString(R.string.success_message), Snackbar.LENGTH_LONG).show();
            //     emptyInputEditText();


        } else {
            // Snack Bar to show error message that record already exists
            // Snackbar.make(nestedScrollView, getString(R.string.error_email_exists), Snackbar.LENGTH_LONG).show();
            Toast.makeText(getBaseContext(), "Error", Toast.LENGTH_LONG).show();
        }


    }
}