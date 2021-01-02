package com.example.bigcash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_settings);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                        overridePendingTransition(0,0);
                        break;
                    case R.id.nav_qr_code:
                        startActivity(new Intent(getApplicationContext(),ScanActivity.class));
                        overridePendingTransition(0,0);
                        break;
                    case R.id.nav_articles:
                        startActivity(new Intent(getApplicationContext(),ArticleActivity.class));
                        overridePendingTransition(0,0);
                        break;
                    case R.id.nav_settings:
                        startActivity(new Intent(getApplicationContext(),SettingsActivity.class));
                        break;

                }
                return true;
            }
        });
    }
}