package com.codebly.zibro.view.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;

import com.codebly.zibro.R;
import com.codebly.zibro.view.home.bottom.FriendBottomSheetDialogFragment;
import com.codebly.zibro.view.home.menu.alarm.AlarmActivity;
import com.codebly.zibro.view.home.menu.customerservice.CustomerServiceActivity;
import com.codebly.zibro.view.home.menu.friends.FriendPageActivity;
import com.codebly.zibro.view.home.menu.mypage.MyPageActivity;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity{
    private DrawerLayout drawerLayout;
    private ConstraintLayout bottomSheetFriends;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //drawerlayout 시작
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);

        // TODO : 위젯들 이름좀 바꾸기. xml에서 id값먼저 다바꾸고 그다음에는 자바.
        // TODO : homeactivity 종료할려면, finish() 추가할것.
        //여기 이미지 뷰는 headerview에 가져온 위젯들임. 유의할것.
        ImageView imageView9 = headerView.findViewById(R.id.imageView9);
        imageView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, CustomerServiceActivity.class);
                startActivity(intent);
            }
        });
        ImageView imageView7 = headerView.findViewById(R.id.imageView7);
        imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, FriendPageActivity.class);
                startActivity(intent);
            }
        });
        ImageView imageView8 = headerView.findViewById(R.id.imageView8);
        imageView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, AlarmActivity.class);
                startActivity(intent);
            }
        });
        ImageView imageView11 = headerView.findViewById(R.id.login);
        imageView11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MyPageActivity.class);
                startActivity(intent);
            }
        });
        // TODO : Popup알림설정

        // 여기부터는 home에 있는 id임.
        ImageView btnHamburger = findViewById(R.id.BtnHamburger);
        btnHamburger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(findViewById(R.id.nav_view));
            }
        });
        // TODO : 메뉴 눌렀으면, 내 장소 액티비티 추가
        // TODO : 오른쪽 상단 버튼 알람화면 액티비티 추가(잇기만 하면됨)
        // TODO : ? 아이콘 액티비티 추가

        // TODO : 홈 액티비이 상단에 장소 검색
        // TODO : 검색후 (activity_location_search_list 화면전환)
        ImageView btnSearch = findViewById(R.id.BtnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO : LocationSearchActivity 만들기
                //Intent intent = new Intent(HomeActivity.this, LocationSearchActivity.class);
                //startActivity(intent);
            }
        });
        ImageView btnMyPoint = findViewById(R.id.BtnMyPoint);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO : 구글맵스 내위치 띄우기

            }
        });
        // TODO : SOS화면
        // TODO : 긴급 호출 기록
        // TODO : 긴급 연락처 api

        // TODO : 집으로 버튼 누르면 위치 공유할 친구 선택 bottomsheet 나오는 기능
        ImageView btnStart = findViewById(R.id.BtnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO : bottomsheet 열기
                FriendBottomSheetDialogFragment bottomSheet = new FriendBottomSheetDialogFragment();
                bottomSheet.show(getSupportFragmentManager(), bottomSheet.getTag());
            }
        });
        // TODO : 눌렀으면 공유버튼 작동
        // TODO : TCP 프로그래밍
        // TODO : https 통신 프로그래밍 : okhttp
        // TODO map : cloud 30일 남았다고 함.
        // TODO login : 로그인 시스템(gemini)

        // TODO(2) : nodejs + express + sequlize(orm)
        // TODO(2) : 액션바 스타일을 변경해야 화면 기본테마가 바꿔짐.
        // TODO(2) : 온디바이스에서 머신러닝, 딥러닝을 돌리는 프로그램
    }
}