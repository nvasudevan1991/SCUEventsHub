package edu.scu.calendermonthviewtest;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    TabLayout tl;
    ViewPager v;
    String va =null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        v = (ViewPager) findViewById(R.id.viewPager);
     //   toolbar = (Toolbar) findViewById(R.id.tool_bar);
        v.setAdapter(new CustomAdapter(getSupportFragmentManager(), getApplicationContext()));
        va = getIntent().getStringExtra("e_d");
    }

    private class CustomAdapter extends FragmentPagerAdapter {
       private String fragments [] = {"Month View","Map View"};
        public CustomAdapter(FragmentManager supportFragmentManager, Context applicationContext) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            switch(position) {
                case 0:
                    Fragment1 f1 = new Fragment1();
                    Bundle bundle = new Bundle();
                    bundle.putString("u_email", va);
                    f1.setArguments(bundle);
                    return f1;
                case 1:
                     return new Fragment2();

                default:
                    return null;
            }

        }

        @Override
        public int getCount() {
            return fragments.length;
        }

        public CharSequence getPageTitle(int position) {
            return fragments[position];
        }
    }
}
