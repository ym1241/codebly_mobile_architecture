package com.example.maps_test;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class HomeActivity extends AppCompatActivity implements OnMapReadyCallback {
    ImageView imgView1;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        imgView1 = (ImageView) findViewById(R.id.start_button_imageView);
        imgView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FriendBottomSheetDialogFragment bottomSheet = new FriendBottomSheetDialogFragment();
                bottomSheet.show(getSupportFragmentManager(), bottomSheet.getTag());
            }
        });
    }
    public void onMapReady(final GoogleMap googleMap) {
        mMap = googleMap;

        LatLng SEOUL = new LatLng(37.556, 126.97);

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(SEOUL);
        markerOptions.title("서울");
        markerOptions.snippet("한국 수도");

        mMap.addMarker(markerOptions);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(SEOUL, 10));
    }

}