package com.codebly.zibro.view.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageView;


import com.codebly.zibro.R;
import com.codebly.zibro.view.home.HomeActivity;

public class AutoLoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_login);

        // SharedPreferences 객체 생성 (앱 내에 데이터를 저장할 수 있음)
        SharedPreferences sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE);
        boolean isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false);
        // 화면이동전에 로그인확인
        if (!isLoggedIn) {
            setContentView(R.layout.activity_login); //로그인하세요
        } else {
            setContentView(R.layout.activity_login);
            //자동로그인 되면, home으로 갑니다.
            Intent intent = new Intent(AutoLoginActivity.this, HomeActivity.class);
            startActivity(intent);
            finish(); // 현재 액티비티를 종료하여 뒤로가기 버튼을 눌렀을 때 메인 액티비티로 돌아가지 않게 함
        }
        ImageView loginButton = findViewById(R.id.login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO : 버튼 누르고 회원정보 검사

                // TODO : 백엔드에서 가져온 로그인상태가 성공이면 아래와 같은 코드 실행

                // 현재 로그인된 상태
                // 로그인 성공 시 SharedPreferences에 로그인 상태를 저장
                SharedPreferences sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("isLoggedIn", true);
                editor.apply();
                // TODO : "isLoggedIn" 이가 true라면 아래와 같은 액티비티 이동. 없으면 그냥 눌러도 홈으로 가는 것임.
                // 홈 액티비티로 이동
                Intent intent = new Intent(AutoLoginActivity.this, HomeActivity.class);
                startActivity(intent);
                finish(); // 로그인 액티비티 종료
            }
        });

        //회원가입창으로 이동하기
        ImageView imageView13 = (ImageView)findViewById(R.id.imageView13);
        imageView13.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
            startActivity(intent);
        });
        // TODO : ID찾기, pw찾기 구현
        // TODO : 카카오톡으로 로그인
        // TODO : 네이버로 로그인 구현
    }



}
