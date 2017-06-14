package edu.scu.eventshub;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FirstPage extends AppCompatActivity {

    String APP_TAG = "SPLASH_SCREEN";
    private DbHelper dbHelperObject;
    private final AppCompatActivity activity = FirstPage.this;
    TextView tv1 = null;
    EditText tv2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);


        final TextView tv1 = (TextView)findViewById(R.id.emailaddress);
        final EditText tv2 = (EditText) findViewById(R.id.editText3);
        Button register1 = (Button) findViewById(R.id.register);
        Button signIn1=(Button) findViewById(R.id.signin);

        dbHelperObject = new DbHelper(activity);


        signIn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //       if (!CheckDetails((TextInputEditText) tv1) && !CheckDetails((TextInputEditText) tv2) && dbHelperObject.checkUser(tv1.getText().toString().trim()
                //               , tv2.getText().toString().trim())) {

                if(!((tv1.getText().toString().trim()).length() == 0) && dbHelperObject.checkUser(tv1.getText().toString().trim(), tv2.getText().toString().trim())) {
                    setContentView(R.layout.activity_spinner);
                    Log.i("Intent Starting ", " for Registration");
                    Intent i = new Intent(getApplicationContext(), MenuPage.class);
                   i.putExtra("email_id", tv1.getText().toString().trim());
                    startActivity(i);
                    tv1.setText(null);
                    tv2.setText(null);
                } else {
                    Toast.makeText(getBaseContext(), "Password or username incorrect", Toast.LENGTH_LONG).show();
                }

            }

        });

        register1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("Intent Starting ", " for Registration");
                Intent i = new Intent(getApplicationContext(), SignUp.class);

                startActivity(i);
            }
        });
    }

    public void signin(View v) {
        if (v.getId() == R.id.signin) {

           // setContentView(R.layout.activity_navigation_menu);

        } else {
            System.exit(0);
        }


    }



    public void reset(View v) {
        if (v.getId() == R.id.resetbutton) {
            System.exit(0);

        }
    }



    public boolean CheckDetails(TextInputEditText textInputEditText) {
        String value = textInputEditText.getText().toString().trim();
        if (value.isEmpty()) {
            //  hideKeyboardFrom(textInputEditText);
            return false;
        }
        return true;
    }

}
