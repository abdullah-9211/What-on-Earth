package com.aleenaadil.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    //declaring all buttons
    Button startB, continueB;
    FirebaseAuth auth;

    @Override
    protected void onStart(){
        super.onStart();
        FirebaseUser user = auth.getInstance().getCurrentUser();
        if(user == null){

        }
        else{
            startActivity(new Intent(MainActivity.this, Home.class));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //---------------------------------------linking buttons---------------------------------
        startB=(Button)findViewById(R.id.startB);
        continueB=(Button)findViewById(R.id.continueB);

        //*****************************************************************************************8

        // When clicking on Start Button in the main screen goes to home screen
        // should set all DB to 0 or null to start the game from the start
        startB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),SignUp.class);
                startActivity(i);
            }
        });
        // When clicking on continue Button in the main screen goes to home screen
        // should restore all DB from before or use the same one for the game ahead
        continueB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Login.class);
                startActivity(i);
            }
        });




    }
}