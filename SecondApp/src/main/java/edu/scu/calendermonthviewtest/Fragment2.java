package edu.scu.calendermonthviewtest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by lakshmimanasavelaga on 5/12/17.
 */

public class Fragment2 extends Fragment implements OnMapReadyCallback {
    private GoogleMap mMap;
    public View onCreateView(LayoutInflater inflator, ViewGroup container, Bundle savedInstanceState) {
      //  Intent myIntent = new Intent(getActivity(), MapsActivity.class);
      //  getActivity().startActivity(myIntent);
        View view = inflator.inflate(R.layout.activity_maps, container, false);

        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        SupportMapFragment fragment = new SupportMapFragment();
        transaction.add(R.id.map, fragment);
        transaction.commit();

        fragment.getMapAsync(this);

        return view;
     //   return inflator.inflate(R.layout.activity_maps,container,false);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(37.3496418,-121.9411762);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Santa Clara University"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}