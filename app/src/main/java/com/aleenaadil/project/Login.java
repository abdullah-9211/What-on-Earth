package com.aleenaadil.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity {
    EditText email, password;
    Button login;
    FirebaseAuth auth;
    FirebaseDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.emailinput4);
        password = findViewById(R.id.passinput4);
        login = findViewById(R.id.login_btn);
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        login.setOnClickListener(v -> {
            String emailStr = this.email.getText().toString();
            String passwordStr = this.password.getText().toString();

            if (emailStr.isEmpty() || passwordStr.isEmpty()) {
                this.email.setError("Please enter your email");
                this.password.setError("Please enter your password");
            } else {
                auth.signInWithEmailAndPassword(emailStr, passwordStr).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Login.this, "User Logged in Successfully" , Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Login.this, Home.class));
                        }else{
                            Toast.makeText(Login.this, "" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}