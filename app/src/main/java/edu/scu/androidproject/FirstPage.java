package edu.scu.androidproject;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.icu.util.Calendar;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

public class FirstPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        Button register1 = (Button) findViewById(R.id.register);
        Button signIn1=(Button) findViewById(R.id.signin);
                register1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.i("Intent Starting ", " for Registration");
                        Intent i = new Intent(getApplicationContext(), SignUp.class);

                        startActivity(i);

                    }

                });
        signIn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Intent Starting ", "for SignIn");
                Intent i =new Intent(getApplicationContext(),SignIn.class);
                startActivity(i);
            }
        });
    }
       /* public void register(View v) {
        if (v.getId() == R.id.register) {
            Log.i("Intent Started", "");
            Button registerButton1 = (Button) findViewById(R.id.register);
            registerButton1.setOnClickListener(new View.OnClickListener() {

                // SignUp s
                @Override
                public void onClick(View v) {


                    //SignUp signUp=new SignUp();
                    // signUp.register3();

                    // SignUp signUp=new SignUp();
                    //signUp.register3();
                    // setContentView(R.layout.activity_sign_in);
                }
            });

        }
        }*/
    public void signin(View v) {
        if (v.getId() == R.id.signin) {

            setContentView(R.layout.activity_sign_in);

        } else {
            System.exit(0);
        }


    }

    /*public void register(View v) {




            setContentView(R.layout.activity_sign_up);
        }
    */

    public void reset(View v) {
        if (v.getId() == R.id.resetbutton) {
            System.exit(0);

        }
    }



    }



