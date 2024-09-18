package com.codebly.zibro.view.home.general;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.codebly.zibro.R;

public class GeneralGenderFragment extends AppCompatActivity {
//아직 fragment관련 클래스 내부 수정하지 않았음.
    ImageView imageView12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_general_gender);
        imageView12 = (ImageView) findViewById(R.id.imageView12);
        imageView12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GeneralGenderFragment.this, GeneralHomeLocationFragment.class));
            }//용만이가 중단 시킴
        });
    }
}