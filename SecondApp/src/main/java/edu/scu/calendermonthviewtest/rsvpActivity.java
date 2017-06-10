package edu.scu.calendermonthviewtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static edu.scu.calendermonthviewtest.R.id.buttonMaybe;
import static edu.scu.calendermonthviewtest.R.id.buttonNo;
import static edu.scu.calendermonthviewtest.R.id.buttonyes;
import static edu.scu.calendermonthviewtest.R.id.editText2;
//import static edu.scu.calendermonthviewtest.R.id.textView;

public class rsvpActivity extends AppCompatActivity {
    String toSend = null;
    String eventd = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rsvp);
        final EditText text1 = (EditText) findViewById(editText2);
        //final TextView text2 = (TextView) findViewById(textView);
        Button button1 = (Button) findViewById(buttonyes);
        Button button2 =(Button)findViewById(buttonNo);
        Button button3 =(Button)findViewById(buttonMaybe) ;
        toSend = getIntent().getStringExtra("email_id");
        eventd = getIntent().getStringExtra("EventDetails");
        Toast.makeText(getApplicationContext(),toSend,Toast.LENGTH_LONG).show();
        text1.setText(eventd);

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Thanks for Registering" ,Toast.LENGTH_LONG).show();
                sendEmail();
                Intent in = new Intent();
                PendingIntent pi = PendingIntent.getActivity(rsvpActivity.this,0,in,0);
                Notification noti = new Notification.Builder(rsvpActivity.this)
                        .setTicker("SCU Events Hub")
                        .setContentTitle(eventd)
                        .setContentText(eventd)
                        .setSmallIcon(R.drawable.notification_flat_resized)
                        .setContentIntent(pi).getNotification();

                noti.flags=Notification.FLAG_AUTO_CANCEL;

                String servName = Context.NOTIFICATION_SERVICE;
                NotificationManager notificationManager;

                notificationManager = (NotificationManager) getSystemService(servName);

                notificationManager.notify(0,noti);

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setContentView(R.layout.frag1);
            }
        });

    }
   private void sendEmail(){
//
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:" + toSend));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "View your registered event details");
        emailIntent.putExtra(Intent.EXTRA_TEXT, eventd);
//
        try {
            startActivity(Intent.createChooser(emailIntent, "Send email using..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(rsvpActivity.this, "No email clients installed.", Toast.LENGTH_SHORT).show();
        }

    }
//    private void sendEmail() {
//        Intent intent = new Intent(Intent.ACTION_SENDTO)
//                .setData(new Uri.Builder().scheme("mailto").build())
//                .putExtra(Intent.EXTRA_EMAIL, new String[]{ "Manasa VL <manasavl91@gmail.com>" })
//                .putExtra(Intent.EXTRA_SUBJECT, "Email subject")
//                .putExtra(Intent.EXTRA_TEXT, "Email body")
//                ;
//
//        ComponentName emailApp = intent.resolveActivity(getPackageManager());
//        ComponentName unsupportedAction = ComponentName.unflattenFromString("com.android.fallback/.Fallback");
//        if (emailApp != null && !emailApp.equals(unsupportedAction))
//            try {
//                // Needed to customise the chooser dialog title since it might default to "Share with"
//                // Note that the chooser will still be skipped if only one app is matched
//                Intent chooser = Intent.createChooser(intent, "Send email with");
//                startActivity(chooser);
//                return;
//            }
//            catch (ActivityNotFoundException ignored) {
//            }
//
//        Toast.makeText(this, "Couldn't find an email app and account", Toast.LENGTH_LONG)
//                .show();
//    }
}
