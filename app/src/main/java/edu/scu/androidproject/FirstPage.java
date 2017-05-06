package edu.scu.androidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class FirstPage extends AppCompatActivity {
DbHelper helper =new DbHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_first_page);

    }
    public void signin(View v)
    {

        if(v.getId() == R.id.signin)
        {
            setContentView(R.layout.content_sign_in);
            EditText a =(EditText)findViewById(R.id.emailaddress);
            EditText b=(EditText)findViewById(R.id.password);
            String s1=a.getText().toString();
            String s2 =b.getText().toString();
            String password =helper.searchPass(s1);
            if(s2.equals(password))
            {
                Intent i=new Intent(FirstPage.this,Display.class);
                i.putExtra("Username",s1);
                startActivity(i);
            }
            else
            {
                Toast t= Toast.makeText(FirstPage.this,"Usredhfgsdjfg",Toast.LENGTH_SHORT);
                t.show();;
            }
        }





        setContentView(R.layout.activity_sign_in);
    }
    public void register(View arg0)
    {

        setContentView(R.layout.activity_sign_up);
    }
 /*   public void register1(View v)
    {
        if(v.getId()== R.id.button4)
        {
            setContentView(R.layout.activity_sign_in);
            EditText fName = (EditText)findViewById(R.id.fName);
            EditText  lName=(EditText) findViewById(R.id.lName);
            EditText userName=(EditText) findViewById(R.id.userName);
            EditText password=(EditText) findViewById(R.id.pass);
            EditText confirmPassword=(EditText) findViewById(R.id.cPass);
            EditText email =(EditText)findViewById(R.id.email);


            String fname1=fName.getText().toString();
            String lname1=lName.getText().toString();
            String userName1=userName.getText().toString();
            String password1=password.getText().toString();
            String confirmPassword1=confirmPassword.getText().toString();
            String email1=email.getText().toString();

            DbContact b =new DbContact();
            b.setPass(password1);
            b.setcPass(confirmPassword1);
            b.setEmail(email1);
            b.setfName(fname1);
            b.setlName(lname1);
            b.setUserName(userName1);
            helper.insertContact(b);
        }
    }*/


}
