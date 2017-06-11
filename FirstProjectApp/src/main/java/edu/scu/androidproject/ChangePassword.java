package edu.scu.androidproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by nithi on 6/10/2017.
 */

public class ChangePassword extends AppCompatActivity {


     Button reset =(Button)findViewById(R.id.changereset);
     Button confirm =(Button)findViewById(R.id.changeconfirm);
     EditText currentPassword =(EditText)findViewById(R.id.currentpassword);
     EditText newPassword =(EditText)findViewById(R.id.newpassword);
     EditText confirmPassword=(EditText)findViewById(R.id.confirmpassword);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Change Password","Reached");
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPassword.setText(null);
                newPassword.setText(null);
                confirmPassword.setText(null);
            }
        });
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // DbHelper dbHelper =new DbHelper(this);
                Toast.makeText(getApplicationContext(),"Confirm",Toast.LENGTH_LONG).show();
            }
        });
    }
}