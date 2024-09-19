package com.codebly.zibro.view.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.codebly.zibro.view.home.menu.customerservice.CustomerServiceActivity;
import com.codebly.zibro.view.home.menu.friends.FriendPageActivity;
import com.codebly.zibro.view.home.menu.alarm.AlarmActivity;
import com.codebly.zibro.view.home.menu.mypage.MyPageActivity;
import com.google.android.material.navigation.NavigationView;
import com.codebly.zibro.R;


public class HomeActivity extends AppCompatActivity{
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.imageView5), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        //drawerlayout 시작
        drawerLayout = findViewById(R.id.drawer_layout);

        navigationView = findViewById(R.id.nav_view);

        View headerView = navigationView.getHeaderView(0);

        // imageView1 = headerView.findViewById(R.id.imageView3);
        ImageView imageView11 = headerView.findViewById(R.id.imageView11);
        //ImageView imageView10 = headerView.findViewById(R.id.imageView10);
        ImageView imageView9 = headerView.findViewById(R.id.imageView9);//고객센터
       // ImageView imageView2 = headerView.findViewById(R.id.imageView2);
        ImageView imageView8 = headerView.findViewById(R.id.imageView8);
        ImageView imageView7 = headerView.findViewById(R.id.imageView7);
        //ImageView imageView6 = headerView.findViewById(R.id.imageView6);
        //ImageView imageView4 = headerView.findViewById(R.id.imageView4);
        ImageView imageView5 = findViewById(R.id.imageView5);

        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 드로어 열기
                drawerLayout.openDrawer(findViewById(R.id.nav_view));
            }
        });

        //drawerlayout 끝

        // drawerlayout 에서 버튼 클릭시 화면 전환 코드 시작
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
        // TODO : 이미지뷰 이름변환
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
    // TODO : SOS화면
    // TODO : 집으로 버튼 누르면 위치 공유할 친구 선택 bottomsheet 나오는 기능
    // TODO : 상단에 장소 검색
    // TODO : 검색후 (activity_location_search_list 화면전환)
    // TODO map : 맵 구현
}