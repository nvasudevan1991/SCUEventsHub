package edu.scu.androidproject;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class WelcomeActivity extends AppCompatActivity {

    String APP_TAG = "SPLASH_SCREEN";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        LongOperation lo = new LongOperation();
        lo.execute("5");

    }

    private class LongOperation extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            Log.d(APP_TAG, "in doInBackground()");
            try{
                int time = Integer.parseInt(params[0])*1000;
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            Log.d(APP_TAG, "in onPostExecute()");
            // After 5 seconds redirect to another intent
            Intent i=new Intent(getBaseContext(),FirstPage.class);
            startActivity(i);

            //Remove activity
            finish();
        }

        @Override
        protected void onPreExecute() {
            Log.d(APP_TAG, "in onPreExecute()");
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            Log.d(APP_TAG, "in onPostExecute()");
        }
    }
}