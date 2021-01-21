package com.example.bigcash;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class SettingsActivity extends AppCompatActivity {
    private Button btn;
    private BottomNavigationView mBottomNavigationView;
    TextView profileFullName,profileEmail;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    Button saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

//        Intent data = getIntent();
//        String fullName = data.getStringExtra("fullName");
//        String email = data.getStringExtra("Email");
//
//        fAuth = FirebaseAuth.getInstance();
//        fStore = FirebaseFirestore.getInstance();
//
//
//
//        profileFullName = findViewById(R.id.edit_name);
//        profileEmail = findViewById(R.id.edit_email);
//
//
//        profileEmail.setText(email);
//        profileEmail.setText(fullName);
//        Button saveBtn = (Button)findViewById(R.id.saveBtn);
//        saveBtn.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(profileFullName.getText().toString().isEmpty()||profileEmail.getText().toString().isEmpty())
//                    Toast.makeText(SettingsActivity.this,"One or many fields are empty",Toast.LENGTH_SHORT).show();
//                return;
//            }
////            Final string email = profileEmail.getText().toString();
//            user.updateEmail(email).addOnSuccessListener(new OnSuccessListener<void>(){
//                public void OnSuccess (Void aVoid){
//                    DocumentReference docRef = fStore.collection("Users").document(user.getUid());
//                    Map<String,object>edited = new HashMap<>();
//                    edited.put("email",email);
//                    edited.put("fname",profileFullName.getText().toString());
//                    docRef.update(edited).addOnSuccessListener(new OnSuccessListener<Void>() {
//                        @Override
//                        public void onSuccess(Void aVoid) {
//                            Toast.makeText(SettingsActivity.this,"Profile Updated",Toast.LENGTH_SHORT).show();
//                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
//                            finish();
//                    })
//
//                    Toast.makeText(SettingsActivity.this,"Email is changed",Toast.LENGTH_SHORT).show();
//                    }
//                 }).addOnFailurelistener(new OnFailureListener(){
//                @Override
//                public void onFailure (@NonNull Exception e){
//                @Override
//                public void onFailure((@NonNull Exception e){
//                        Toast.makeText(SettingsActivity.this,e.getMessage(),,Toast.LENGTH_SHORT).show();
//
//                   }
//
//            };
//
//        });
//
//

        Button btn = (Button) findViewById(R.id.logoutBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(SettingsActivity.this,MainActivity.class));
                finish();
            }
        });



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
                        break;

                }
                return true;
            }
        });




    }
}
