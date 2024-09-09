package com.codebly.zibro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class activity_friend_page extends AppCompatActivity {
ImageView imageView27, imageView26;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_page);
        imageView27 = (ImageView)findViewById(R.id.imageView27);
        imageView27.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),activity_search_friend.class);
            startActivity(intent);

        });
        imageView26 = (ImageView)findViewById(R.id.imageView26);
        imageView26.setOnClickListener(view1 -> {
            Intent intent1 = new Intent(getApplicationContext(),activity_alter_friends.class);
            startActivity(intent1);
        } );

        EdgeToEdge.enable(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}