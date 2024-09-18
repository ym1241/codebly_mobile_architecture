package com.codebly.zibro.view.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.ImageView;


import com.codebly.zibro.R;

public class LoginActivity extends AppCompatActivity {
ImageView imageView13;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView btnGoToSecondActivity = findViewById(R.id.imageView13);

        //imageView13 = ~뭐이다.
        imageView13 = (ImageView)findViewById(R.id.imageView13);
        imageView13.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
            startActivity(intent);

        });
        // TODO : SignIn 버튼 누르면, (activity_home)으로 전환
        // TODO : ID찾기 화면과 구현
        // TODO : PW찾기 화면과 구현
        // TODO : 카카오톡으로 로그인
        // TODO : 네이버로 로그인 구현
        // TODO : 로그인 상태 유지 버튼 누르면 다시 꺼지지 않음 -> login 템플릿이용하면 괜찮음
    }



}
