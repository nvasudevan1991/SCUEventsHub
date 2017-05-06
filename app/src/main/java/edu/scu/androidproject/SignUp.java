package edu.scu.androidproject;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {
   // DbHelper helper =new DbHelper(this);
  //  @Override

    /*protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        //register1(onCreate(savedInstanceState));
    }*/
    public void register2(View v)
    {
        if(v.getId() == R.id.register2)
        {
            setContentView(R.layout.activity_sign_in);
        }
    }
}