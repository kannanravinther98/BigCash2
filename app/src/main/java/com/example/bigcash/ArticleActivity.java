package com.example.bigcash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class ArticleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        ImageSlider imageSlider=findViewById(R.id.slider);

        List<SlideModel> slideModels=new ArrayList<>();
        slideModels.add(new SlideModel("https://i.imgur.com/lpcimlu.png","IMoney"));
        slideModels.add(new SlideModel("https://i.imgur.com/ZdhgWdb.png","KCLau"));
        slideModels.add(new SlideModel("https://i.imgur.com/4P9w3J0.png","CompareHero"));
        imageSlider.setImageList(slideModels,true);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_articles);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.nav_qr_code:
                        startActivity(new Intent(getApplicationContext(), ScanActivity.class));
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.nav_articles:
                        break;
                    case R.id.nav_settings:
                        startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
                        overridePendingTransition(0, 0);
                        break;

                }
                return true;
            }

        });
    }


    public void GetUrlFromIntent(View view) {
        String url = "https://kclau.com/";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    public void GetUrlFromIntentTwo(View view) {
        String url = "http://www.imoney.my";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    public void GetUrlFromIntentThree(View view) {
        String url = "https://www.comparehero.my/";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }}












