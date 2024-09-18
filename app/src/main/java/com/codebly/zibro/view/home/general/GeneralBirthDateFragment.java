package com.codebly.zibro.view.home.general;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.codebly.zibro.R;

public class GeneralBirthDateFragment extends AppCompatActivity {
/*
    public MyFragment(){
        //기본 생성자
    }
    public MyFragment(String title){
        this.title = title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
 */
ImageView imageView6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_general_birth_date);
        imageView6 = (ImageView) findViewById(R.id.imageView6);
        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GeneralBirthDateFragment.this, GeneralGenderFragment.class));
            }//용만이가 중단시킴
        });
    }
}


