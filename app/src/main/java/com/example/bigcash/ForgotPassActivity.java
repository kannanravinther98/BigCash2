package com.example.bigcash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassActivity extends AppCompatActivity {

    EditText enterEmail;
    Button sendEmail;

    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);

        enterEmail= findViewById(R.id.user_email);
        sendEmail= findViewById(R.id.btnSendtoEmail);

        firebaseAuth = FirebaseAuth.getInstance();

        sendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.sendPasswordResetEmail(enterEmail.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(ForgotPassActivity.this, "Password sent to your email", Toast.LENGTH_LONG).show();

                        }else{
                            Toast.makeText(ForgotPassActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();

                        }

                        }

                    });
                }
        });

    }
}