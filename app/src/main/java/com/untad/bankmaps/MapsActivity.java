package com.untad.bankmaps;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

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
        mMap = googleMap;

        LatLng Bank = new LatLng(-0.91905, 119.88502);
        LatLng Rumah = new LatLng(-0.90425, 119.91151);

        int tinggi = 100;
        int lebar = 100;
        BitmapDrawable bitmapBank = (BitmapDrawable)getResources().getDrawable((R.drawable.pin));
        BitmapDrawable bitmapRumah = (BitmapDrawable)getResources().getDrawable((R.drawable.pinb));
        Bitmap b = bitmapBank.getBitmap();
        Bitmap c = bitmapRumah.getBitmap();
        Bitmap markerK = Bitmap.createScaledBitmap(b, lebar, tinggi, false);
        Bitmap markerZ = Bitmap.createScaledBitmap(b, lebar, tinggi, false);

        mMap.addMarker(new MarkerOptions().position(Bank).title("Marker in Bank BCA")
                .snippet("Bank BCA")
                .icon(BitmapDescriptorFactory.fromBitmap(markerK)));
        mMap.addMarker(new MarkerOptions().position(Rumah).title("Marker in Rumahku")
                .snippet("Rumahku")
                .icon(BitmapDescriptorFactory.fromBitmap(markerZ)));
        mMap.addPolyline(new PolylineOptions().add(
                Bank,
                new LatLng(-0.91888, 119.89268),
                new LatLng(-0.90621, 119.88938),
                new LatLng(-0.90285, 119.90691),
                new LatLng(-0.90173, 119.90715),
                new LatLng(-0.90187, 119.90741),
                new LatLng(-0.90153, 119.90950),
                new LatLng(-0.90272, 119.90971),
                new LatLng(-0.90293, 119.91163),
                Rumah
        ).width(10)
        .color(Color.BLUE)
        );


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Bank, 14.5f));
    }
}