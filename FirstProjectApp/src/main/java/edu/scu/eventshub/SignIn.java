package edu.scu.eventshub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class SignIn extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Intent Reached", "SignIn page");
        setContentView(R.layout.activity_menu_page);
        // final CalendarView calendarView=(CalendarView) findViewById(R.id.calendar);
        //calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
        //   @Override
        // public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

//               Toast.makeText(getApplicationContext(), ""+dayOfMonth, Toast.LENGTH_LONG).show();

        //          }
        //    });

        //  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        // FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //fab.setOnClickListener(new View.OnClickListener() {
      /*      @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }*/

    }
}