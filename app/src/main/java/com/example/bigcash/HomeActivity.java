package com.example.bigcash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button mButtonBalance;
        mButtonBalance = (Button) findViewById(R.id.buttonBalance);
        mButtonBalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),HomeWebviewBalanceActivity.class));            }

        });


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected( MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
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
                        overridePendingTransition(0,0);
                        break;
                }
                return true;
            }
        });



    }


    }


