package com.aleenaadil.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileScreen extends AppCompatActivity {

    ImageButton highscoresB3, Back10;
    TextView changePass, viewStats;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_screen);

        //**********************************************************\\
        highscoresB3=(ImageButton) findViewById(R.id.highscoresB3);
        Back10=(ImageButton) findViewById(R.id.back10);
        changePass = findViewById(R.id.changePass);
        viewStats = findViewById(R.id.viewStats);
        database = FirebaseDatabase.getInstance();

        //*********************************************************\\
        highscoresB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),LeaderBoards.class);
                startActivity(i);
            }
        });
        //-------------------------------back------------------------------------------
        Back10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Home.class);
                startActivity(i);
            }
        });
        //------------------------------change password----------------------------------
        changePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),ChangePassword.class);
                startActivity(i);
            }
        });
        //----------------------view stats-----------------------------------
        viewStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Stats.class));
            }
        });
        //**********************************************************************\\
        final String[] username = new String[1];
        database.getReference().child("Users").child(FirebaseAuth.getInstance().getUid()).get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                username[0] = task.getResult().child("name").getValue().toString();
                TextView usernameText = findViewById(R.id.username);
                usernameText.setText(username[0]);
            }
        });

    }
}