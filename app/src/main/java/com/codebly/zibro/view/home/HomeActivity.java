package com.codebly.zibro.view.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.codebly.zibro.view.home.menu.customerservice.CustomerServiceActivity;
import com.codebly.zibro.view.home.menu.friends.FriendPageActivity;
import com.codebly.zibro.view.home.menu.alarm.AlarmActivity;
import com.codebly.zibro.view.home.menu.mypage.MyPageActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.navigation.NavigationView;
import com.codebly.zibro.R;


public class HomeActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private MapView mapView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull GoogleMap googleMap) {
                LatLng location = new LatLng(37.4600, 127.1271 );
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 15));


                // 마커 추가
                googleMap.addMarker(new MarkerOptions()
                        .position(location)
                        .title("내 핀")
                        .snippet("이곳이 내가 지정한 장소"));
            }
        });

        //drawerlayout 시작
        drawerLayout = findViewById(R.id.drawer_layout);

        navigationView = findViewById(R.id.nav_view);

        View headerView = navigationView.getHeaderView(0);

        ImageView imageView1 = headerView.findViewById(R.id.imageView3);
        ImageView imageView11 = headerView.findViewById(R.id.imageView11);
        ImageView imageView10 = headerView.findViewById(R.id.imageView10);
        ImageView imageView9 = headerView.findViewById(R.id.imageView9);
        ImageView imageView2 = headerView.findViewById(R.id.imageView2);
        ImageView imageView8 = headerView.findViewById(R.id.imageView8);
        ImageView imageView7 = headerView.findViewById(R.id.imageView7);
        ImageView imageView6 = headerView.findViewById(R.id.imageView6);
        ImageView imageView4 = headerView.findViewById(R.id.imageView4);
        ImageView imageView5 = findViewById(R.id.imageView5);

        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 드로어 열기
                drawerLayout.openDrawer(findViewById(R.id.nav_view));
            }
        });

        //drawerlayout 끝

        // drawerlayout에서 버튼 클릭시 화면전환 코드 시작
        imageView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 클릭 시 새로운 Activity로 화면 전환
                Intent intent = new Intent(HomeActivity.this, AlarmActivity.class);
                startActivity(intent);

            }
        });

        imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 클릭 시 새로운 Activity로 화면 전환
                Intent intent = new Intent(HomeActivity.this, FriendPageActivity.class);
                startActivity(intent);

            }
        });

        imageView11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 클릭 시 새로운 Activity로 화면 전환
                Intent intent = new Intent(HomeActivity.this, MyPageActivity.class);
                startActivity(intent);

            }
        });
        //고객센터
        imageView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 클릭 시 새로운 Activity로 화면 전환
                Intent intent = new Intent(HomeActivity.this, CustomerServiceActivity.class);
                startActivity(intent);

            }
        });


    }
    // MapView 라이프사이클 메서드 추가
    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
}


