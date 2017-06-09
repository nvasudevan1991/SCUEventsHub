package edu.scu.calendermonthviewtest;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Marker mark;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        ArrayList<LatLng> marker1 =new ArrayList<>();
        mark.remove();
        mark.setVisible(false);
        mMap = googleMap;
        //googleMap.clear();
        //marker.add(new LatLng(37.3496418,-121.9411762));
        //marker.add(new LatLng(37.347684,-121.9416632));
        mMap.clear();

        for(LatLng markers:marker1)
        {
            //markers.remove();
           mMap.addMarker(new MarkerOptions().position(markers).title("mark"));
            //mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(scu, 25.0f));
            //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(scu, 25));

        }




        // Add a marker in Sydney and move the camera
        //LatLng scu = new LatLng(37.3496418,-121.9411762);
        //mMap.addMarker(new MarkerOptions().position(scu).title("SCU"));

//        mMap.addMarker(new MarkerOptions()
  //              .position(new LatLng(37.347684,-121.9416632))
             //   .anchor(0.5f, 0.5f)
    //            .title("Title3"));
           //     .snippet("Snippet3"));
          //      .icon(BitmapDescriptorFactory.fromResource(R.drawable.logo3)));
     //   mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney, 17.0f));
     //   mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 17));

    }
}
