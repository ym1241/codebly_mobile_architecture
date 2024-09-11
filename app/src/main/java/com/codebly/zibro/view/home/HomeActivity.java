package com.codebly.zibro.view.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.graphics.drawable.DrawableWrapper;
import android.widget.ImageView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import android.widget.TextView;

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
    }
}