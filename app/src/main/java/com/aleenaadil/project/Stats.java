package com.aleenaadil.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Stats extends AppCompatActivity {
    ImageButton back2;
    TextView temp;
    ProgressBar co2, seaLevel, airPollution, oceanAcidification, bioDiversity, weatherEvents, greenHouse, socialInequity;
    int co2Total=0, seaLevelTotal=0, airPollutionTotal=0, oceanAcidificationTotal=0, bioDiversityTotal=0, weatherEventsTotal=0, greenHouseTotal=0, socialInequityTotal=0;
    int co2Average, seaLevelAverage, airPollutionAverage, oceanAcidificationAverage, bioDiversityAverage, weatherEventsAverage, greenHouseAverage, socialInequityAverage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        back2 = findViewById(R.id.back2);
        temp = findViewById(R.id.temp);
        co2 = findViewById(R.id.C02Concentrationstat);
        seaLevel = findViewById(R.id.SeaLevelRiseStat);
        airPollution = findViewById(R.id.AirPollutionStat);
        oceanAcidification = findViewById(R.id.OceanAcidificationStat);
        bioDiversity = findViewById(R.id.BiodiversityStat);
        weatherEvents = findViewById(R.id.ExtremeWeatherEventsStat);
        greenHouse = findViewById(R.id.GreenHouseGaseConcentrationStat);
        socialInequity = findViewById(R.id.SocialInequityStat);


        //================Setting temperature stat value from user==============================
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        reference.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()) {
                    DataSnapshot dataSnapshot = task.getResult();
                    if (dataSnapshot.exists()) {
                        String temperature = dataSnapshot.child("temperature").getValue().toString();
                        temp.setText(temperature);
                    }
                }
            }
        });


        //==================Getting data from North America=======================================
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(FirebaseAuth.getInstance().getUid()).child("northAmerica").child("stats");
        mDatabase.get().addOnCompleteListener(
                new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (task.isSuccessful()) {
                            DataSnapshot dataSnapshot = task.getResult();
                            co2Total += (Integer.parseInt(dataSnapshot.child("co2").getValue().toString()));
                            seaLevelTotal += (Integer.parseInt(dataSnapshot.child("seaLevel").getValue().toString()));
                            airPollutionTotal += (Integer.parseInt(dataSnapshot.child("airPollution").getValue().toString()));
                            oceanAcidificationTotal += (Integer.parseInt(dataSnapshot.child("oceanAcidification").getValue().toString()));
                            socialInequityTotal += (Integer.parseInt(dataSnapshot.child("socialInequity").getValue().toString()));
                            bioDiversityTotal += (Integer.parseInt(dataSnapshot.child("bioDiversity").getValue().toString()));
                            greenHouseTotal += (Integer.parseInt(dataSnapshot.child("greenhouseGases").getValue().toString()));
                            weatherEventsTotal += (Integer.parseInt(dataSnapshot.child("weatherEvents").getValue().toString()));
                        }
                    }
                }
        );

        //==================Getting data from South America=======================================
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(FirebaseAuth.getInstance().getUid()).child("southAmerica").child("stats");
        mDatabase.get().addOnCompleteListener(
                new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (task.isSuccessful()) {
                            DataSnapshot dataSnapshot = task.getResult();
                            co2Total += (Integer.parseInt(dataSnapshot.child("co2").getValue().toString()));
                            seaLevelTotal += (Integer.parseInt(dataSnapshot.child("seaLevel").getValue().toString()));
                            airPollutionTotal += (Integer.parseInt(dataSnapshot.child("airPollution").getValue().toString()));
                            oceanAcidificationTotal += (Integer.parseInt(dataSnapshot.child("oceanAcidification").getValue().toString()));
                            socialInequityTotal += (Integer.parseInt(dataSnapshot.child("socialInequity").getValue().toString()));
                            bioDiversityTotal += (Integer.parseInt(dataSnapshot.child("bioDiversity").getValue().toString()));
                            greenHouseTotal += (Integer.parseInt(dataSnapshot.child("greenhouseGases").getValue().toString()));
                            weatherEventsTotal += (Integer.parseInt(dataSnapshot.child("weatherEvents").getValue().toString()));
                        }
                    }
                }
        );

        //==================Getting data from Europe=======================================
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(FirebaseAuth.getInstance().getUid()).child("europe").child("stats");
        mDatabase.get().addOnCompleteListener(
                new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (task.isSuccessful()) {
                            DataSnapshot dataSnapshot = task.getResult();
                            co2Total += (Integer.parseInt(dataSnapshot.child("co2").getValue().toString()));
                            seaLevelTotal += (Integer.parseInt(dataSnapshot.child("seaLevel").getValue().toString()));
                            airPollutionTotal += (Integer.parseInt(dataSnapshot.child("airPollution").getValue().toString()));
                            oceanAcidificationTotal += (Integer.parseInt(dataSnapshot.child("oceanAcidification").getValue().toString()));
                            socialInequityTotal += (Integer.parseInt(dataSnapshot.child("socialInequity").getValue().toString()));
                            bioDiversityTotal += (Integer.parseInt(dataSnapshot.child("bioDiversity").getValue().toString()));
                            greenHouseTotal += (Integer.parseInt(dataSnapshot.child("greenhouseGases").getValue().toString()));
                            weatherEventsTotal += (Integer.parseInt(dataSnapshot.child("weatherEvents").getValue().toString()));
                        }
                    }
                }
        );


        //==================Getting data from Asia=======================================
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(FirebaseAuth.getInstance().getUid()).child("asia").child("stats");
        mDatabase.get().addOnCompleteListener(
                new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (task.isSuccessful()) {
                            DataSnapshot dataSnapshot = task.getResult();
                            co2Total += (Integer.parseInt(dataSnapshot.child("co2").getValue().toString()));
                            seaLevelTotal += (Integer.parseInt(dataSnapshot.child("seaLevel").getValue().toString()));
                            airPollutionTotal += (Integer.parseInt(dataSnapshot.child("airPollution").getValue().toString()));
                            oceanAcidificationTotal += (Integer.parseInt(dataSnapshot.child("oceanAcidification").getValue().toString()));
                            socialInequityTotal += (Integer.parseInt(dataSnapshot.child("socialInequity").getValue().toString()));
                            bioDiversityTotal += (Integer.parseInt(dataSnapshot.child("bioDiversity").getValue().toString()));
                            greenHouseTotal += (Integer.parseInt(dataSnapshot.child("greenhouseGases").getValue().toString()));
                            weatherEventsTotal += (Integer.parseInt(dataSnapshot.child("weatherEvents").getValue().toString()));
                        }
                    }
                }
        );

        //==================Getting data from Africa=======================================
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(FirebaseAuth.getInstance().getUid()).child("africa").child("stats");
        mDatabase.get().addOnCompleteListener(
                new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (task.isSuccessful()) {
                            DataSnapshot dataSnapshot = task.getResult();
                            co2Total += (Integer.parseInt(dataSnapshot.child("co2").getValue().toString()));
                            seaLevelTotal += (Integer.parseInt(dataSnapshot.child("seaLevel").getValue().toString()));
                            airPollutionTotal += (Integer.parseInt(dataSnapshot.child("airPollution").getValue().toString()));
                            oceanAcidificationTotal += (Integer.parseInt(dataSnapshot.child("oceanAcidification").getValue().toString()));
                            socialInequityTotal += (Integer.parseInt(dataSnapshot.child("socialInequity").getValue().toString()));
                            bioDiversityTotal += (Integer.parseInt(dataSnapshot.child("bioDiversity").getValue().toString()));
                            greenHouseTotal += (Integer.parseInt(dataSnapshot.child("greenhouseGases").getValue().toString()));
                            weatherEventsTotal += (Integer.parseInt(dataSnapshot.child("weatherEvents").getValue().toString()));
                        }
                    }
                }
        );

        //==================Getting data from Oceania=======================================
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(FirebaseAuth.getInstance().getUid()).child("oceania").child("stats");
        mDatabase.get().addOnCompleteListener(
                new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (task.isSuccessful()) {
                            DataSnapshot dataSnapshot = task.getResult();
                            co2Total += (Integer.parseInt(dataSnapshot.child("co2").getValue().toString()));
                            seaLevelTotal += (Integer.parseInt(dataSnapshot.child("seaLevel").getValue().toString()));
                            airPollutionTotal += (Integer.parseInt(dataSnapshot.child("airPollution").getValue().toString()));
                            oceanAcidificationTotal += (Integer.parseInt(dataSnapshot.child("oceanAcidification").getValue().toString()));
                            socialInequityTotal += (Integer.parseInt(dataSnapshot.child("socialInequity").getValue().toString()));
                            bioDiversityTotal += (Integer.parseInt(dataSnapshot.child("bioDiversity").getValue().toString()));
                            greenHouseTotal += (Integer.parseInt(dataSnapshot.child("greenhouseGases").getValue().toString()));
                            weatherEventsTotal += (Integer.parseInt(dataSnapshot.child("weatherEvents").getValue().toString()));

                            //Getting Averages
                            co2Average = co2Total / 6;
                            seaLevelAverage = seaLevelTotal / 6;
                            airPollutionAverage = airPollutionTotal / 6;
                            oceanAcidificationAverage = oceanAcidificationTotal / 6;
                            socialInequityAverage = socialInequityTotal / 6;
                            bioDiversityAverage = bioDiversityTotal / 6;
                            greenHouseAverage = greenHouseTotal / 6;
                            weatherEventsAverage = weatherEventsTotal / 6;


                            //==================Setting Values=======================================
                            co2.setProgress(co2Average);
                            seaLevel.setProgress(seaLevelAverage);
                            airPollution.setProgress(airPollutionAverage);
                            oceanAcidification.setProgress(oceanAcidificationAverage);
                            socialInequity.setProgress(socialInequityAverage);
                            bioDiversity.setProgress(bioDiversityAverage);
                            greenHouse.setProgress(greenHouseAverage);
                            weatherEvents.setProgress(weatherEventsAverage);

                        }
                    }
                }
        );



        back2.setOnClickListener(view -> {
            finish();
        });
    }
}