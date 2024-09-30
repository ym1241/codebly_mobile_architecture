package com.codebly.zibro.view.home.menu.mypage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.codebly.zibro.R;
import com.codebly.zibro.view.login.AutoLoginActivity;

public class MyPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);

        //툴바구현하기위한 코드
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_white);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        //뒤로가기버튼을 생성
        actionBar.setDisplayHomeAsUpEnabled(true);

        //logout버튼 구현
        Button btnLogout = (Button) findViewById(R.id.BtnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // SharedPreferences에서 로그인 상태를 false로 변경
                SharedPreferences sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("isLoggedIn", false);
                editor.apply();

                // 모든 액티비티 종료 후 LoginActivity로 이동
                Intent intent = new Intent(MyPageActivity.this, AutoLoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);//LoginActivity 시작
                finishAffinity();  // 현재 액티비티 포함 모든 액티비티 종료.
                //TODO : 오케이! 이제 뒤로가면 앱 종료됨
            }
        });
    }
    //툴바에있는 뒤로가기 버튼 누르면 현재 액티비티 종료
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
