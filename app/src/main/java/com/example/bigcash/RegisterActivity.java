package com.example.bigcash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    private EditText mName;
    private EditText mEmail;
    private EditText mPassword;
    private Button mButton;
    private FirebaseAuth mAuth;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mName = findViewById(R.id.reg_name);
        mEmail = findViewById(R.id.reg_email);
        mPassword = findViewById(R.id.reg_password);
        mButton = findViewById(R.id.reg_btn);
        mAuth = FirebaseAuth.getInstance();

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mName.getText().toString();
                String email = mEmail.getText().toString();
                String password = mPassword.getText().toString();
                if(!name.isEmpty() && !email.isEmpty() && !password.isEmpty()){
                    mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                mAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()){
                                            Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                                            startActivity(intent);
                                            Toast.makeText(RegisterActivity.this,"Registered successfully, Please check your email for verification",Toast.LENGTH_LONG).show();

                                        mEmail.setText("");
                                        mPassword.setText("");}
                                        else{
                                            Toast.makeText(RegisterActivity.this,""+task.getException(),Toast.LENGTH_SHORT).show();
                                        }

                                    }
                                });

                            }else{
                                Toast.makeText(RegisterActivity.this,""+task.getException(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }else{
                    Toast.makeText(RegisterActivity.this,"Please fill empty field",Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}