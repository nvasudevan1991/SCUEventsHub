package edu.scu.calendermonthviewtest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by lakshmimanasavelaga on 5/12/17.
 */

public class Fragment2 extends Fragment {
    public View onCreateView(LayoutInflater inflator, ViewGroup container, Bundle savedInstanceState) {
        return inflator.inflate(R.layout.activity_maps,container,false);
    }
}