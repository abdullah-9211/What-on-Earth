package com.aleenaadil.project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Home extends AppCompatActivity {

    //declaring all buttons
    ImageButton newsPageB, SDGB, profileB2, highscoresB2;
    ImageView logout;
    Button worldMapB;
    AlertDialog.Builder dialogBuilder;
    FirebaseDatabase database;
    FirebaseAuth auth;
    TextView currency, year, population, deaths;

    //------------------------------onCreate function--------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MediaPlayer music = MediaPlayer.create(Home.this, R.raw.sunset);
        music.start();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        //*************************************************************************************
        //linking buttons
        SDGB = (ImageButton)findViewById(R.id.SDGB);
        newsPageB = (ImageButton)findViewById(R.id.newsPageB);
        profileB2=(ImageButton)findViewById(R.id.profileB2);
        highscoresB2=(ImageButton)findViewById(R.id.highscoresB2);
        worldMapB=(Button)findViewById(R.id.worldMapB);
        logout=(ImageView)findViewById(R.id.logout);
        currency=(TextView)findViewById(R.id.currency);
        year=(TextView)findViewById(R.id.year);
        population=(TextView)findViewById(R.id.population);
        deaths=(TextView)findViewById(R.id.deaths);
        database = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();

        //*************************************************************************************

        //goes to news page place--------------------------------------------------------
        newsPageB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),NewsPage.class);
                startActivity(i);
            }
        });

        //goes to SDG progress tracking page----------------------------------------------
        SDGB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Stats.class);
                startActivity(i);
            }
        });

        //goes to profile----------------------------------------------------------------
        profileB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),ProfileScreen.class);
                startActivity(i);
            }
        });

        //Logout of game--------------------------------------------------------------------
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent i=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        //goes to world map screen------------------------------------------------------------
        worldMapB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),WorldMap.class);
                startActivity(i);
//                AnswerImpact answerImpact1 = new AnswerImpact(0, 0, +1, +1, 0, +3, +2,-3,0,-2);
//                AnswerImpact answerImpact2 = new AnswerImpact(0, -3, -1, -2, -1, -3, -1,-2,0,0);
//                AnswerImpact answerImpact3 = new AnswerImpact(0,0,0,-1,0,0,0,-3,0,-2);
//                Question question = new Question("Floods in this area are becoming increasingly common as time progresses, the governments in this region want to take measures in case of further floods, which ones would be most appropriate?", "Building Dams", "Planting Eucalyptus and Mangrove trees", "Implementing Rain harvesting systems", -5000, -3000, -2000, answerImpact1, answerImpact2, answerImpact3);
//
//                DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Questions");
//                reference.child("Question5").setValue(question);
//                Toast.makeText(Home.this, "Question Added", Toast.LENGTH_SHORT).show();
            }
        });

        //*********************************************************************************8

        //=================SETTING UP DATA ON SCREEN========================================//
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users").child(auth.getCurrentUser().getUid());
        reference.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                User user = task.getResult().getValue(User.class);
                currency.setText(String.valueOf(user.getCoins()));
                year.setText(String.valueOf(user.getYear()));
                population.setText(String.valueOf(user.getPopulation()));
                deaths.setText(String.valueOf(user.getDeaths()));
            }
        });

    }
}