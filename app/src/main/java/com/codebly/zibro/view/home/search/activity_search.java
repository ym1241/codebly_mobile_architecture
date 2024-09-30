package com.codebly.zibro.view.home.search;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.codebly.zibro.R;

public class activity_search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        // TODO(feature) : GoogleMaps에서 정보 가져오고난 상황을 textview나 ratingbar로 만들기
        // TODO : 나머지 3개 fragment로 전환. 하나의 액티비티.

        // TODO : 모든 ui 구성이 끝나면, 여기서부터 TCP 라이브데이터가 필요.
    }
}