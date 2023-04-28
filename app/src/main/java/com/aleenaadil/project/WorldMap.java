package com.aleenaadil.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.Random;

public class WorldMap extends AppCompatActivity {
    ImageButton back11, SDGB2, NewsB2;
    ImageButton NAButton, SAButton, EuropeButton, AsiaButton, AfricaButton, OceaniaButton;
    ImageView getActivity;
    TextView currency2;
    AlertDialog.Builder dialogBuilder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world_map);

        //*****************************************************************************\\
        back11 = (ImageButton) findViewById(R.id.back11);
        SDGB2 = (ImageButton) findViewById(R.id.SDGB2);
        NewsB2 =(ImageButton) findViewById(R.id.newsB2);
        NAButton = (ImageButton)findViewById(R.id.NAButton);
        SAButton = (ImageButton)findViewById(R.id.SAButton);
        EuropeButton = (ImageButton)findViewById(R.id.EuropeButton);
        AsiaButton = (ImageButton)findViewById(R.id.AsiaButton);
        AfricaButton = (ImageButton)findViewById(R.id.AfricaButton);
        OceaniaButton = (ImageButton)findViewById(R.id.OceaniaButton);
        getActivity = (ImageView) findViewById(R.id.getActivity);
        currency2 = (TextView) findViewById(R.id.currency2);

        //*********************************************************************\\


        //-------------------------------back------------------------------------------
        back11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Home.class);
                startActivity(i);
            }
        });

        SDGB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Stats.class);
                startActivity(i);
            }
        });
        NewsB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),NewsPage.class);
                startActivity(i);
            }
        });
        //**********************************************************************\\
        //continents--------------------------------------------------------------

        NAButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogBuilder = new AlertDialog.Builder(WorldMap.this);
                final View popupView = getLayoutInflater().inflate(R.layout.fragment_north_america, null);
                ImageButton back4 = (ImageButton) popupView.findViewById(R.id.back3);
                ProgressBar co2 = (ProgressBar) popupView.findViewById(R.id.C02ConcentrationStatbar4);
                ProgressBar seaLevel = (ProgressBar) popupView.findViewById(R.id.SeaLevelStatbar4);
                ProgressBar airPollution = (ProgressBar) popupView.findViewById(R.id.AirPollutionStatbar4);
                ProgressBar oceanAcidification = (ProgressBar) popupView.findViewById(R.id.OceanAcidificationStatbar4);
                ProgressBar socialInequity = (ProgressBar) popupView.findViewById(R.id.SocialInequityStatbar4);
                ProgressBar biodiversity = (ProgressBar) popupView.findViewById(R.id.BiodiversityStatbar4);
                ProgressBar greenHouse = (ProgressBar) popupView.findViewById(R.id.GreenHouseGasConcentrationStatbar4);
                ProgressBar extremeWeather = (ProgressBar) popupView.findViewById(R.id.extremeWeatherStatbar4);
                dialogBuilder.setView(popupView);
                AlertDialog dialog = dialogBuilder.create();

                back4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(FirebaseAuth.getInstance().getUid()).child("northAmerica").child("stats");
                mDatabase.get().addOnCompleteListener(
                        new OnCompleteListener<DataSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DataSnapshot> task) {
                                if (task.isSuccessful()) {
                                    DataSnapshot dataSnapshot = task.getResult();
                                    co2.setProgress(Integer.parseInt(dataSnapshot.child("co2").getValue().toString()));
                                    seaLevel.setProgress(Integer.parseInt(dataSnapshot.child("seaLevel").getValue().toString()));
                                    airPollution.setProgress(Integer.parseInt(dataSnapshot.child("airPollution").getValue().toString()));
                                    oceanAcidification.setProgress(Integer.parseInt(dataSnapshot.child("oceanAcidification").getValue().toString()));
                                    socialInequity.setProgress(Integer.parseInt(dataSnapshot.child("socialInequity").getValue().toString()));
                                    biodiversity.setProgress(Integer.parseInt(dataSnapshot.child("bioDiversity").getValue().toString()));
                                    greenHouse.setProgress(Integer.parseInt(dataSnapshot.child("greenhouseGases").getValue().toString()));
                                    extremeWeather.setProgress(Integer.parseInt(dataSnapshot.child("weatherEvents").getValue().toString()));
                                }
                            }
                        }
                );

                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                lp.copyFrom(dialog.getWindow().getAttributes());
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.height = WindowManager.LayoutParams.MATCH_PARENT;
                dialog.show();
                dialog.getWindow().setAttributes(lp);

            }
        });
        SAButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogBuilder = new AlertDialog.Builder(WorldMap.this);
                final View popupView = getLayoutInflater().inflate(R.layout.fragment_south_america, null);
                ImageButton back4 = (ImageButton) popupView.findViewById(R.id.back8);
                ProgressBar co2 = (ProgressBar) popupView.findViewById(R.id.C02ConcentrationStatbar1);
                ProgressBar seaLevel = (ProgressBar) popupView.findViewById(R.id.SeaLevelStatbar1);
                ProgressBar airPollution = (ProgressBar) popupView.findViewById(R.id.AirPollutionStatbar1);
                ProgressBar oceanAcidification = (ProgressBar) popupView.findViewById(R.id.OceanAcidificationStatbar1);
                ProgressBar socialInequity = (ProgressBar) popupView.findViewById(R.id.SocialInequityStatbar1);
                ProgressBar biodiversity = (ProgressBar) popupView.findViewById(R.id.BiodiversityStatbar1);
                ProgressBar greenHouse = (ProgressBar) popupView.findViewById(R.id.GreenHouseGasConcentrationStatbar1);
                ProgressBar extremeWeather = (ProgressBar) popupView.findViewById(R.id.extremeWeatherEventsStatbar1);
                dialogBuilder.setView(popupView);
                AlertDialog dialog = dialogBuilder.create();

                back4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(FirebaseAuth.getInstance().getUid()).child("southAmerica").child("stats");
                mDatabase.get().addOnCompleteListener(
                        new OnCompleteListener<DataSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DataSnapshot> task) {
                                if (task.isSuccessful()) {
                                    DataSnapshot dataSnapshot = task.getResult();
                                    co2.setProgress(Integer.parseInt(dataSnapshot.child("co2").getValue().toString()));
                                    seaLevel.setProgress(Integer.parseInt(dataSnapshot.child("seaLevel").getValue().toString()));
                                    airPollution.setProgress(Integer.parseInt(dataSnapshot.child("airPollution").getValue().toString()));
                                    oceanAcidification.setProgress(Integer.parseInt(dataSnapshot.child("oceanAcidification").getValue().toString()));
                                    socialInequity.setProgress(Integer.parseInt(dataSnapshot.child("socialInequity").getValue().toString()));
                                    biodiversity.setProgress(Integer.parseInt(dataSnapshot.child("bioDiversity").getValue().toString()));
                                    greenHouse.setProgress(Integer.parseInt(dataSnapshot.child("greenhouseGases").getValue().toString()));
                                    extremeWeather.setProgress(Integer.parseInt(dataSnapshot.child("weatherEvents").getValue().toString()));
                                }
                            }
                        }
                );

                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                lp.copyFrom(dialog.getWindow().getAttributes());
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.height = WindowManager.LayoutParams.MATCH_PARENT;
                dialog.show();
                dialog.getWindow().setAttributes(lp);
            }
        });
        EuropeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogBuilder = new AlertDialog.Builder(WorldMap.this);
                final View popupView = getLayoutInflater().inflate(R.layout.fragment_europe, null);
                ImageButton back4 = (ImageButton) popupView.findViewById(R.id.back6);
                ProgressBar co2 = (ProgressBar) popupView.findViewById(R.id.C02ConcentrationStatbar3);
                ProgressBar seaLevel = (ProgressBar) popupView.findViewById(R.id.SeaLevelStatbar3);
                ProgressBar airPollution = (ProgressBar) popupView.findViewById(R.id.AirPollutionStatbar3);
                ProgressBar oceanAcidification = (ProgressBar) popupView.findViewById(R.id.OceanAcidificationStatbar3);
                ProgressBar socialInequity = (ProgressBar) popupView.findViewById(R.id.SocialInequityStatbar3);
                ProgressBar biodiversity = (ProgressBar) popupView.findViewById(R.id.BiodiversityStatbar3);
                ProgressBar greenHouse = (ProgressBar) popupView.findViewById(R.id.GreenHouseGasConcentrationStatbar3);
                ProgressBar extremeWeather = (ProgressBar) popupView.findViewById(R.id.extremeWeatherStatbar3);
                dialogBuilder.setView(popupView);
                AlertDialog dialog = dialogBuilder.create();

                back4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(FirebaseAuth.getInstance().getUid()).child("europe").child("stats");
                mDatabase.get().addOnCompleteListener(
                        new OnCompleteListener<DataSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DataSnapshot> task) {
                                if (task.isSuccessful()) {
                                    DataSnapshot dataSnapshot = task.getResult();
                                    co2.setProgress(Integer.parseInt(dataSnapshot.child("co2").getValue().toString()));
                                    seaLevel.setProgress(Integer.parseInt(dataSnapshot.child("seaLevel").getValue().toString()));
                                    airPollution.setProgress(Integer.parseInt(dataSnapshot.child("airPollution").getValue().toString()));
                                    oceanAcidification.setProgress(Integer.parseInt(dataSnapshot.child("oceanAcidification").getValue().toString()));
                                    socialInequity.setProgress(Integer.parseInt(dataSnapshot.child("socialInequity").getValue().toString()));
                                    biodiversity.setProgress(Integer.parseInt(dataSnapshot.child("bioDiversity").getValue().toString()));
                                    greenHouse.setProgress(Integer.parseInt(dataSnapshot.child("greenhouseGases").getValue().toString()));
                                    extremeWeather.setProgress(Integer.parseInt(dataSnapshot.child("weatherEvents").getValue().toString()));
                                }
                            }
                        }
                );

                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                lp.copyFrom(dialog.getWindow().getAttributes());
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.height = WindowManager.LayoutParams.MATCH_PARENT;
                dialog.show();
                dialog.getWindow().setAttributes(lp);
            }
        });
        AsiaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogBuilder = new AlertDialog.Builder(WorldMap.this);
                final View popupView = getLayoutInflater().inflate(R.layout.fragment_asia, null);
                ImageButton back4 = (ImageButton) popupView.findViewById(R.id.back4);
                ProgressBar co2 = (ProgressBar) popupView.findViewById(R.id.C02ConcentrationStatbar5);
                ProgressBar seaLevel = (ProgressBar) popupView.findViewById(R.id.SeaLevelStatbar5);
                ProgressBar airPollution = (ProgressBar) popupView.findViewById(R.id.AirPollutionStatbar5);
                ProgressBar oceanAcidification = (ProgressBar) popupView.findViewById(R.id.OceanAcidificationStatbar5);
                ProgressBar socialInequity = (ProgressBar) popupView.findViewById(R.id.SocialInequityStatbar5);
                ProgressBar biodiversity = (ProgressBar) popupView.findViewById(R.id.BiodiversityStatbar5);
                ProgressBar greenHouse = (ProgressBar) popupView.findViewById(R.id.GreenHouseGasConcentrationStatbar5);
                ProgressBar extremeWeather = (ProgressBar) popupView.findViewById(R.id.extremeWeatherStatbar5);
                dialogBuilder.setView(popupView);
                AlertDialog dialog = dialogBuilder.create();

                back4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(FirebaseAuth.getInstance().getUid()).child("asia").child("stats");
                mDatabase.get().addOnCompleteListener(
                        new OnCompleteListener<DataSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DataSnapshot> task) {
                                if (task.isSuccessful()) {
                                    DataSnapshot dataSnapshot = task.getResult();
                                    co2.setProgress(Integer.parseInt(dataSnapshot.child("co2").getValue().toString()));
                                    seaLevel.setProgress(Integer.parseInt(dataSnapshot.child("seaLevel").getValue().toString()));
                                    airPollution.setProgress(Integer.parseInt(dataSnapshot.child("airPollution").getValue().toString()));
                                    oceanAcidification.setProgress(Integer.parseInt(dataSnapshot.child("oceanAcidification").getValue().toString()));
                                    socialInequity.setProgress(Integer.parseInt(dataSnapshot.child("socialInequity").getValue().toString()));
                                    biodiversity.setProgress(Integer.parseInt(dataSnapshot.child("bioDiversity").getValue().toString()));
                                    greenHouse.setProgress(Integer.parseInt(dataSnapshot.child("greenhouseGases").getValue().toString()));
                                    extremeWeather.setProgress(Integer.parseInt(dataSnapshot.child("weatherEvents").getValue().toString()));
                                }
                            }
                        }
                );

                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                lp.copyFrom(dialog.getWindow().getAttributes());
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.height = WindowManager.LayoutParams.MATCH_PARENT;
                dialog.show();
                dialog.getWindow().setAttributes(lp);
            }
        });
        AfricaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogBuilder = new AlertDialog.Builder(WorldMap.this);
                final View popupView = getLayoutInflater().inflate(R.layout.fragment_africa, null);
                ImageButton back4 = (ImageButton) popupView.findViewById(R.id.back5);
                ProgressBar co2 = (ProgressBar) popupView.findViewById(R.id.C02ConcentrationStatbar6);
                ProgressBar seaLevel = (ProgressBar) popupView.findViewById(R.id.SeaLevelStatbar6);
                ProgressBar airPollution = (ProgressBar) popupView.findViewById(R.id.AirPollutionStatbar6);
                ProgressBar oceanAcidification = (ProgressBar) popupView.findViewById(R.id.OceanAcidificationStatbar5);
                ProgressBar socialInequity = (ProgressBar) popupView.findViewById(R.id.SocialInequityStatbar6);
                ProgressBar biodiversity = (ProgressBar) popupView.findViewById(R.id.BiodiversityStatbar6);
                ProgressBar greenHouse = (ProgressBar) popupView.findViewById(R.id.GreenHouseGasConcentrationStatbar6);
                ProgressBar extremeWeather = (ProgressBar) popupView.findViewById(R.id.extremeWeatherStatbar6);
                dialogBuilder.setView(popupView);
                AlertDialog dialog = dialogBuilder.create();

                back4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(FirebaseAuth.getInstance().getUid()).child("africa").child("stats");
                mDatabase.get().addOnCompleteListener(
                        new OnCompleteListener<DataSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DataSnapshot> task) {
                                if (task.isSuccessful()) {
                                    DataSnapshot dataSnapshot = task.getResult();
                                    co2.setProgress(Integer.parseInt(dataSnapshot.child("co2").getValue().toString()));
                                    seaLevel.setProgress(Integer.parseInt(dataSnapshot.child("seaLevel").getValue().toString()));
                                    airPollution.setProgress(Integer.parseInt(dataSnapshot.child("airPollution").getValue().toString()));
                                    oceanAcidification.setProgress(Integer.parseInt(dataSnapshot.child("oceanAcidification").getValue().toString()));
                                    socialInequity.setProgress(Integer.parseInt(dataSnapshot.child("socialInequity").getValue().toString()));
                                    biodiversity.setProgress(Integer.parseInt(dataSnapshot.child("bioDiversity").getValue().toString()));
                                    greenHouse.setProgress(Integer.parseInt(dataSnapshot.child("greenhouseGases").getValue().toString()));
                                    extremeWeather.setProgress(Integer.parseInt(dataSnapshot.child("weatherEvents").getValue().toString()));
                                }
                            }
                        }
                );


                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                lp.copyFrom(dialog.getWindow().getAttributes());
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.height = WindowManager.LayoutParams.MATCH_PARENT;
                dialog.show();
                dialog.getWindow().setAttributes(lp);

            }
        });
        OceaniaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogBuilder = new AlertDialog.Builder(WorldMap.this);
                final View popupView = getLayoutInflater().inflate(R.layout.fragment_oceania, null);
                ImageButton back4 = (ImageButton) popupView.findViewById(R.id.back7);
                ProgressBar co2 = (ProgressBar) popupView.findViewById(R.id.C02ConcentrationStatbar2);
                ProgressBar seaLevel = (ProgressBar) popupView.findViewById(R.id.SeaLevelStatbar2);
                ProgressBar airPollution = (ProgressBar) popupView.findViewById(R.id.AirPollutionStatbar2);
                ProgressBar oceanAcidification = (ProgressBar) popupView.findViewById(R.id.OceanAcidificationStatbar2);
                ProgressBar socialInequity = (ProgressBar) popupView.findViewById(R.id.SocialInequityStatbar2);
                ProgressBar biodiversity = (ProgressBar) popupView.findViewById(R.id.BiodiversityStatbar2);
                ProgressBar greenHouse = (ProgressBar) popupView.findViewById(R.id.GreenHouseGasConcentrationStatbar2);
                ProgressBar extremeWeather = (ProgressBar) popupView.findViewById(R.id.extremeWeatherStatbar2);
                dialogBuilder.setView(popupView);
                AlertDialog dialog = dialogBuilder.create();

                back4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(FirebaseAuth.getInstance().getUid()).child("oceania").child("stats");
                mDatabase.get().addOnCompleteListener(
                        new OnCompleteListener<DataSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DataSnapshot> task) {
                                if (task.isSuccessful()) {
                                    DataSnapshot dataSnapshot = task.getResult();
                                    co2.setProgress(Integer.parseInt(dataSnapshot.child("co2").getValue().toString()));
                                    seaLevel.setProgress(Integer.parseInt(dataSnapshot.child("seaLevel").getValue().toString()));
                                    airPollution.setProgress(Integer.parseInt(dataSnapshot.child("airPollution").getValue().toString()));
                                    oceanAcidification.setProgress(Integer.parseInt(dataSnapshot.child("oceanAcidification").getValue().toString()));
                                    socialInequity.setProgress(Integer.parseInt(dataSnapshot.child("socialInequity").getValue().toString()));
                                    biodiversity.setProgress(Integer.parseInt(dataSnapshot.child("bioDiversity").getValue().toString()));
                                    greenHouse.setProgress(Integer.parseInt(dataSnapshot.child("greenhouseGases").getValue().toString()));
                                    extremeWeather.setProgress(Integer.parseInt(dataSnapshot.child("weatherEvents").getValue().toString()));
                                }
                            }
                        }
                );

                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                lp.copyFrom(dialog.getWindow().getAttributes());
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.height = WindowManager.LayoutParams.MATCH_PARENT;
                dialog.show();
                dialog.getWindow().setAttributes(lp);

            }
        });
        //**********************************************************************\\


        //==========================SETTING UP COIN DATA========================//

        DatabaseReference df = FirebaseDatabase.getInstance().getReference().child("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        df.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String coins = dataSnapshot.child("coins").getValue().toString();
                currency2.setText(coins);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        //**********************************************************************\\
        getActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogBuilder = new AlertDialog.Builder(WorldMap.this);
                final View popupView = getLayoutInflater().inflate(R.layout.fragment_questions, null);
                LinearLayout option1 = (LinearLayout) popupView.findViewById(R.id.option1);
                LinearLayout option2 = (LinearLayout) popupView.findViewById(R.id.option2);
                LinearLayout option3 = (LinearLayout) popupView.findViewById(R.id.option3);

                TextView question = (TextView) popupView.findViewById(R.id.question);
                TextView option1Text = (TextView) popupView.findViewById(R.id.option1Text);
                TextView option2Text = (TextView) popupView.findViewById(R.id.option2Text);
                TextView option3Text = (TextView) popupView.findViewById(R.id.option3Text);

                TextView coins1 = (TextView) popupView.findViewById(R.id.coins1);
                TextView coins2 = (TextView) popupView.findViewById(R.id.coins2);
                TextView coins3 = (TextView) popupView.findViewById(R.id.coins3);

                TextView option1P = (TextView) popupView.findViewById(R.id.option1P);
                TextView option1N = (TextView) popupView.findViewById(R.id.option1N);
                TextView option2P = (TextView) popupView.findViewById(R.id.option2P);
                TextView option2N = (TextView) popupView.findViewById(R.id.option2N);
                TextView option3P = (TextView) popupView.findViewById(R.id.option3P);
                TextView option3N = (TextView) popupView.findViewById(R.id.option3N);

                Random random = new Random();
                int randomNumber = random.nextInt(5)+1;
                int continentNum = random.nextInt(6)+1;
                String continent = "";

                switch (continentNum){
                    case 1:
                        continent = "asia";
                        break;
                    case 2:
                        continent = "africa";
                        break;
                    case 3:
                        continent = "europe";
                        break;
                    case 4:
                        continent = "northAmerica";
                        break;
                    case 5:
                        continent = "oceania";
                        break;
                    case 6:
                        continent = "southAmerica";
                        break;
                }

                String finalContinent = continent;


                dialogBuilder.setView(popupView);
                AlertDialog dialog = dialogBuilder.create();

                option1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        FirebaseDatabase.getInstance().getReference().child("Questions").child("Question" + randomNumber).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DataSnapshot> task) {
                                if (task.isSuccessful()){
                                    DataSnapshot dataSnapshot = task.getResult();
                                    String title = dataSnapshot.child("question").getValue().toString();
                                    AnswerImpact impact = dataSnapshot.child("answerImpact1").getValue(AnswerImpact.class);
                                    NewsFlash newsFlash = new NewsFlash(title, "Solution effects:-\n Carbon Emissions: " + impact.getCo2() + ", Sea Level: " + impact.getSeaLevel() + ", Air Pollution: " + impact.getAirPollution() + ", Ocean Acidification: " + impact.getOceanAcidification() + ", Social Inequity: " + impact.getSocialInequity() + ", Biodiversity: " + impact.getBioDiversity() + ", Greenhouse Gases: " + impact.getGreenhouseGases() + ", Extreme Weather Events: " + impact.getWeatherEvents() + ", Deaths Caused: " + impact.getDeaths());
                                    SQLDBHelper dbHelper = new SQLDBHelper(WorldMap.this);
                                    if (dbHelper.addNewsData(newsFlash)){
                                        Toast.makeText(WorldMap.this, "News Flash Added", Toast.LENGTH_SHORT).show();
                                    }else{
                                        Toast.makeText(WorldMap.this, "Couldn't add News Flash", Toast.LENGTH_SHORT).show();
                                    }
                                    if (impact.getDeaths() > 0){
                                        DatabaseReference user = FirebaseDatabase.getInstance().getReference().child("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
                                        user.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                            @Override
                                            public void onComplete(@NonNull Task<DataSnapshot> task) {
                                                if (task.isSuccessful()){
                                                    DataSnapshot dataSnapshot = task.getResult();
                                                    int deaths = Integer.parseInt(dataSnapshot.child("deaths").getValue().toString());
                                                    int population = Integer.parseInt(dataSnapshot.child("population").getValue().toString());
                                                    user.child("deaths").setValue(deaths + impact.getDeaths());
                                                    user.child("population").setValue(population - impact.getDeaths());
                                                }
                                            }
                                        });
                                    }
                                    else {
                                        DatabaseReference user = FirebaseDatabase.getInstance().getReference().child("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
                                        user.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                            @Override
                                            public void onComplete(@NonNull Task<DataSnapshot> task) {
                                                if (task.isSuccessful()){
                                                    DataSnapshot dataSnapshot = task.getResult();
                                                    int population = Integer.parseInt(dataSnapshot.child("population").getValue().toString());
                                                    user.child("population").setValue(population + 50000);
                                                }
                                            }
                                        });
                                    }
                                    int coins = Integer.parseInt(dataSnapshot.child("coins1").getValue().toString());
                                    DatabaseReference user = FirebaseDatabase.getInstance().getReference().child("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
                                    user.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                        @Override
                                        public void onComplete(@NonNull Task<DataSnapshot> task) {
                                            if (task.isSuccessful()){
                                                DataSnapshot dataSnapshot = task.getResult();
                                                int userCoins = Integer.parseInt(dataSnapshot.child("coins").getValue().toString());
                                                int years = Integer.parseInt(dataSnapshot.child("year").getValue().toString());
                                                user.child("year").setValue(years + 1);
                                                if (userCoins + coins <= 0){
                                                    user.child("coins").setValue(0);
                                                }
                                                else
                                                {
                                                    user.child("coins").setValue(userCoins + coins);
                                                }
                                            }
                                        }
                                    });
                                }
                            }
                        });

                        FirebaseDatabase.getInstance().getReference().child("Questions").child("Question" + randomNumber).child("answerImpact1").get().addOnCompleteListener(
                                new OnCompleteListener<DataSnapshot>() {
                                    @Override
                                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                                        if (task.isSuccessful()) {
                                            DataSnapshot dataSnapshot = task.getResult();
                                            AnswerImpact answerImpact = dataSnapshot.getValue(AnswerImpact.class);
                                            DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(FirebaseAuth.getInstance().getUid()).child(finalContinent).child("stats");
                                            mDatabase.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                                @Override
                                                public void onComplete(@NonNull Task<DataSnapshot> task) {
                                                    if (task.isSuccessful()) {
                                                        DataSnapshot dataSnapshot = task.getResult();
                                                        AnswerImpact stats = dataSnapshot.getValue(AnswerImpact.class);
                                                        if (stats.getCo2() + answerImpact.getCo2() <= 0){
                                                            mDatabase.child("co2").setValue(0);
                                                        }
                                                        else if (stats.getCo2() + answerImpact.getCo2() >= 100){
                                                            mDatabase.child("co2").setValue(100);
                                                        }
                                                        else
                                                        {
                                                            mDatabase.child("co2").setValue(stats.getCo2() + answerImpact.getCo2());
                                                        }
                                                        //==================================================================================================\\
                                                        if (stats.getSeaLevel() + answerImpact.getSeaLevel() <= 0){
                                                            mDatabase.child("seaLevel").setValue(0);
                                                        }
                                                        else if (stats.getSeaLevel() + answerImpact.getSeaLevel() >= 100){
                                                            mDatabase.child("seaLevel").setValue(100);
                                                        }
                                                        else
                                                        {
                                                            mDatabase.child("seaLevel").setValue(stats.getSeaLevel() + answerImpact.getSeaLevel());
                                                        }
                                                        //==================================================================================================\\
                                                        if(stats.getAirPollution() + answerImpact.getAirPollution() <= 0){
                                                            mDatabase.child("airPollution").setValue(0);
                                                        }
                                                        else if (stats.getAirPollution() + answerImpact.getAirPollution() >= 100){
                                                            mDatabase.child("airPollution").setValue(100);
                                                        }
                                                        else
                                                        {
                                                            mDatabase.child("airPollution").setValue(stats.getAirPollution() + answerImpact.getAirPollution());
                                                        }
                                                        //==================================================================================================\\
                                                        if (stats.getOceanAcidification() + answerImpact.getOceanAcidification() <= 0){
                                                            mDatabase.child("oceanAcidification").setValue(0);
                                                        }
                                                        else if (stats.getOceanAcidification() + answerImpact.getOceanAcidification() >= 100){
                                                            mDatabase.child("oceanAcidification").setValue(100);
                                                        }
                                                        else
                                                        {
                                                            mDatabase.child("oceanAcidification").setValue(stats.getOceanAcidification() + answerImpact.getOceanAcidification());
                                                        }
                                                        //==================================================================================================\\
                                                        if (stats.getSocialInequity() + answerImpact.getSocialInequity() <= 0){
                                                            mDatabase.child("socialInequity").setValue(0);
                                                        }
                                                        else if (stats.getSocialInequity() + answerImpact.getSocialInequity() >= 100){
                                                            mDatabase.child("socialInequity").setValue(100);
                                                        }
                                                        else
                                                        {
                                                            mDatabase.child("socialInequity").setValue(stats.getSocialInequity() + answerImpact.getSocialInequity());
                                                        }
                                                        //==================================================================================================\\
                                                        if (stats.getBioDiversity() + answerImpact.getBioDiversity() <= 0){
                                                            mDatabase.child("bioDiversity").setValue(0);
                                                        }
                                                        else if (stats.getBioDiversity() + answerImpact.getBioDiversity() >= 100){
                                                            mDatabase.child("bioDiversity").setValue(100);
                                                        }
                                                        else
                                                        {
                                                            mDatabase.child("bioDiversity").setValue(stats.getBioDiversity() + answerImpact.getBioDiversity());
                                                        }
                                                        //==================================================================================================\\
                                                        if (stats.getWeatherEvents() + answerImpact.getWeatherEvents() <= 0){
                                                            mDatabase.child("weatherEvents").setValue(0);
                                                        }
                                                        else if (stats.getWeatherEvents() + answerImpact.getWeatherEvents() >= 100){
                                                            mDatabase.child("weatherEvents").setValue(100);
                                                        }
                                                        else
                                                        {
                                                            mDatabase.child("weatherEvents").setValue(stats.getWeatherEvents() + answerImpact.getWeatherEvents());
                                                        }
                                                        //==================================================================================================\\
                                                        if (stats.getGreenhouseGases() + answerImpact.getGreenhouseGases() <= 0){
                                                            mDatabase.child("greenhouseGases").setValue(0);
                                                        }
                                                        else if (stats.getGreenhouseGases() + answerImpact.getGreenhouseGases() >= 100){
                                                            mDatabase.child("greenhouseGases").setValue(100);
                                                        }
                                                        else
                                                        {
                                                            mDatabase.child("greenhouseGases").setValue(stats.getGreenhouseGases() + answerImpact.getGreenhouseGases());
                                                        }
                                                    }
                                                }
                                            });
                                        }
                                    }
                                });
                        Toast.makeText(WorldMap.this, "Option 1 Selected!", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });


                option2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        FirebaseDatabase.getInstance().getReference().child("Questions").child("Question" + randomNumber).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DataSnapshot> task) {
                                if (task.isSuccessful()){
                                    DataSnapshot dataSnapshot = task.getResult();
                                    String title = dataSnapshot.child("question").getValue().toString();
                                    AnswerImpact impact = dataSnapshot.child("answerImpact2").getValue(AnswerImpact.class);
                                    NewsFlash newsFlash = new NewsFlash(title, "Solution effects:-\n Carbon Emissions: " + impact.getCo2() + ", Sea Level: " + impact.getSeaLevel() + ", Air Pollution: " + impact.getAirPollution() + ", Ocean Acidification: " + impact.getOceanAcidification() + ", Social Inequity: " + impact.getSocialInequity() + ", Biodiversity: " + impact.getBioDiversity() + ", Greenhouse Gases: " + impact.getGreenhouseGases() + ", Extreme Weather Events: " + impact.getWeatherEvents() + ", Deaths Caused: " + impact.getDeaths());
                                    SQLDBHelper dbHelper = new SQLDBHelper(WorldMap.this);
                                    if (dbHelper.addNewsData(newsFlash)){
                                        Toast.makeText(WorldMap.this, "News Flash Added", Toast.LENGTH_SHORT).show();
                                    }else{
                                        Toast.makeText(WorldMap.this, "Couldn't add News Flash", Toast.LENGTH_SHORT).show();
                                    }
                                    if (impact.getDeaths() > 0){
                                        DatabaseReference user = FirebaseDatabase.getInstance().getReference().child("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
                                        user.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                            @Override
                                            public void onComplete(@NonNull Task<DataSnapshot> task) {
                                                if (task.isSuccessful()){
                                                    DataSnapshot dataSnapshot = task.getResult();
                                                    int deaths = Integer.parseInt(dataSnapshot.child("deaths").getValue().toString());
                                                    int population = Integer.parseInt(dataSnapshot.child("population").getValue().toString());
                                                    user.child("deaths").setValue(deaths + impact.getDeaths());
                                                    user.child("population").setValue(population - impact.getDeaths());
                                                }
                                            }
                                        });
                                    }
                                    else {
                                        DatabaseReference user = FirebaseDatabase.getInstance().getReference().child("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
                                        user.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                            @Override
                                            public void onComplete(@NonNull Task<DataSnapshot> task) {
                                                if (task.isSuccessful()){
                                                    DataSnapshot dataSnapshot = task.getResult();
                                                    int population = Integer.parseInt(dataSnapshot.child("population").getValue().toString());
                                                    user.child("population").setValue(population + 50000);
                                                }
                                            }
                                        });
                                    }
                                    int coins = Integer.parseInt(dataSnapshot.child("coins2").getValue().toString());
                                    DatabaseReference user = FirebaseDatabase.getInstance().getReference().child("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
                                    user.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                        @Override
                                        public void onComplete(@NonNull Task<DataSnapshot> task) {
                                            if (task.isSuccessful()){
                                                DataSnapshot dataSnapshot = task.getResult();
                                                int userCoins = Integer.parseInt(dataSnapshot.child("coins").getValue().toString());
                                                int years = Integer.parseInt(dataSnapshot.child("year").getValue().toString());
                                                user.child("year").setValue(years + 1);
                                                if (userCoins + coins <= 0){
                                                    user.child("coins").setValue(0);
                                                }
                                                else
                                                {
                                                    user.child("coins").setValue(userCoins + coins);
                                                }
                                            }
                                        }
                                    });
                                }
                            }
                        });

                        FirebaseDatabase.getInstance().getReference().child("Questions").child("Question" + randomNumber).child("answerImpact2").get().addOnCompleteListener(
                                new OnCompleteListener<DataSnapshot>() {
                                    @Override
                                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                                        if (task.isSuccessful()) {
                                            DataSnapshot dataSnapshot = task.getResult();
                                            AnswerImpact answerImpact = dataSnapshot.getValue(AnswerImpact.class);
                                            DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(FirebaseAuth.getInstance().getUid()).child(finalContinent).child("stats");
                                            mDatabase.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                                @Override
                                                public void onComplete(@NonNull Task<DataSnapshot> task) {
                                                    if (task.isSuccessful()) {
                                                        DataSnapshot dataSnapshot = task.getResult();
                                                        AnswerImpact stats = dataSnapshot.getValue(AnswerImpact.class);
                                                        if (stats.getCo2() + answerImpact.getCo2() <= 0){
                                                            mDatabase.child("co2").setValue(0);
                                                        }
                                                        else if (stats.getCo2() + answerImpact.getCo2() >= 100){
                                                            mDatabase.child("co2").setValue(100);
                                                        }
                                                        else
                                                        {
                                                            mDatabase.child("co2").setValue(stats.getCo2() + answerImpact.getCo2());
                                                        }
                                                        //==================================================================================================\\
                                                        if (stats.getSeaLevel() + answerImpact.getSeaLevel() <= 0){
                                                            mDatabase.child("seaLevel").setValue(0);
                                                        }
                                                        else if (stats.getSeaLevel() + answerImpact.getSeaLevel() >= 100){
                                                            mDatabase.child("seaLevel").setValue(100);
                                                        }
                                                        else
                                                        {
                                                            mDatabase.child("seaLevel").setValue(stats.getSeaLevel() + answerImpact.getSeaLevel());
                                                        }
                                                        //==================================================================================================\\
                                                        if(stats.getAirPollution() + answerImpact.getAirPollution() <= 0){
                                                            mDatabase.child("airPollution").setValue(0);
                                                        }
                                                        else if (stats.getAirPollution() + answerImpact.getAirPollution() >= 100){
                                                            mDatabase.child("airPollution").setValue(100);
                                                        }
                                                        else
                                                        {
                                                            mDatabase.child("airPollution").setValue(stats.getAirPollution() + answerImpact.getAirPollution());
                                                        }
                                                        //==================================================================================================\\
                                                        if (stats.getOceanAcidification() + answerImpact.getOceanAcidification() <= 0){
                                                            mDatabase.child("oceanAcidification").setValue(0);
                                                        }
                                                        else if (stats.getOceanAcidification() + answerImpact.getOceanAcidification() >= 100){
                                                            mDatabase.child("oceanAcidification").setValue(100);
                                                        }
                                                        else
                                                        {
                                                            mDatabase.child("oceanAcidification").setValue(stats.getOceanAcidification() + answerImpact.getOceanAcidification());
                                                        }
                                                        //==================================================================================================\\
                                                        if (stats.getSocialInequity() + answerImpact.getSocialInequity() <= 0){
                                                            mDatabase.child("socialInequity").setValue(0);
                                                        }
                                                        else if (stats.getSocialInequity() + answerImpact.getSocialInequity() >= 100){
                                                            mDatabase.child("socialInequity").setValue(100);
                                                        }
                                                        else
                                                        {
                                                            mDatabase.child("socialInequity").setValue(stats.getSocialInequity() + answerImpact.getSocialInequity());
                                                        }
                                                        //==================================================================================================\\
                                                        if (stats.getBioDiversity() + answerImpact.getBioDiversity() <= 0){
                                                            mDatabase.child("bioDiversity").setValue(0);
                                                        }
                                                        else if (stats.getBioDiversity() + answerImpact.getBioDiversity() >= 100){
                                                            mDatabase.child("bioDiversity").setValue(100);
                                                        }
                                                        else
                                                        {
                                                            mDatabase.child("bioDiversity").setValue(stats.getBioDiversity() + answerImpact.getBioDiversity());
                                                        }
                                                        //==================================================================================================\\
                                                        if (stats.getWeatherEvents() + answerImpact.getWeatherEvents() <= 0){
                                                            mDatabase.child("weatherEvents").setValue(0);
                                                        }
                                                        else if (stats.getWeatherEvents() + answerImpact.getWeatherEvents() >= 100){
                                                            mDatabase.child("weatherEvents").setValue(100);
                                                        }
                                                        else
                                                        {
                                                            mDatabase.child("weatherEvents").setValue(stats.getWeatherEvents() + answerImpact.getWeatherEvents());
                                                        }
                                                        //==================================================================================================\\
                                                        if (stats.getGreenhouseGases() + answerImpact.getGreenhouseGases() <= 0){
                                                            mDatabase.child("greenhouseGases").setValue(0);
                                                        }
                                                        else if (stats.getGreenhouseGases() + answerImpact.getGreenhouseGases() >= 100){
                                                            mDatabase.child("greenhouseGases").setValue(100);
                                                        }
                                                        else
                                                        {
                                                            mDatabase.child("greenhouseGases").setValue(stats.getGreenhouseGases() + answerImpact.getGreenhouseGases());
                                                        }
                                                    }
                                                }
                                            });
                                        }
                                    }
                                });
                        Toast.makeText(WorldMap.this, "Option 2 Selected!", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
                option3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        FirebaseDatabase.getInstance().getReference().child("Questions").child("Question" + randomNumber).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DataSnapshot> task) {
                                if (task.isSuccessful()){
                                    DataSnapshot dataSnapshot = task.getResult();
                                    String title = dataSnapshot.child("question").getValue().toString();
                                    AnswerImpact impact = dataSnapshot.child("answerImpact3").getValue(AnswerImpact.class);
                                    NewsFlash newsFlash = new NewsFlash(title, "Solution effects:-\n Carbon Emissions: " + impact.getCo2() + ", Sea Level: " + impact.getSeaLevel() + ", Air Pollution: " + impact.getAirPollution() + ", Ocean Acidification: " + impact.getOceanAcidification() + ", Social Inequity: " + impact.getSocialInequity() + ", Biodiversity: " + impact.getBioDiversity() + ", Greenhouse Gases: " + impact.getGreenhouseGases() + ", Extreme Weather Events: " + impact.getWeatherEvents() + ", Deaths Caused: " + impact.getDeaths());
                                    SQLDBHelper dbHelper = new SQLDBHelper(WorldMap.this);
                                    if (dbHelper.addNewsData(newsFlash)){
                                        Toast.makeText(WorldMap.this, "News Flash Added", Toast.LENGTH_SHORT).show();
                                    }else{
                                        Toast.makeText(WorldMap.this, "Couldn't add News Flash", Toast.LENGTH_SHORT).show();
                                    }
                                    if (impact.getDeaths() > 0){
                                        DatabaseReference user = FirebaseDatabase.getInstance().getReference().child("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
                                        user.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                            @Override
                                            public void onComplete(@NonNull Task<DataSnapshot> task) {
                                                if (task.isSuccessful()){
                                                    DataSnapshot dataSnapshot = task.getResult();
                                                    int deaths = Integer.parseInt(dataSnapshot.child("deaths").getValue().toString());
                                                    int population = Integer.parseInt(dataSnapshot.child("population").getValue().toString());
                                                    user.child("deaths").setValue(deaths + impact.getDeaths());
                                                    user.child("population").setValue(population - impact.getDeaths());
                                                }
                                            }
                                        });
                                    }
                                    else {
                                        DatabaseReference user = FirebaseDatabase.getInstance().getReference().child("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
                                        user.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                            @Override
                                            public void onComplete(@NonNull Task<DataSnapshot> task) {
                                                if (task.isSuccessful()){
                                                    DataSnapshot dataSnapshot = task.getResult();
                                                    int population = Integer.parseInt(dataSnapshot.child("population").getValue().toString());
                                                    user.child("population").setValue(population + 50000);
                                                }
                                            }
                                        });
                                    }
                                    int coins = Integer.parseInt(dataSnapshot.child("coins3").getValue().toString());
                                    DatabaseReference user = FirebaseDatabase.getInstance().getReference().child("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
                                    user.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                        @Override
                                        public void onComplete(@NonNull Task<DataSnapshot> task) {
                                            if (task.isSuccessful()){
                                                DataSnapshot dataSnapshot = task.getResult();
                                                int userCoins = Integer.parseInt(dataSnapshot.child("coins").getValue().toString());
                                                int years = Integer.parseInt(dataSnapshot.child("year").getValue().toString());

                                                user.child("year").setValue(years + 1);
                                                if (userCoins + coins <= 0){
                                                    user.child("coins").setValue(0);
                                                }
                                                else
                                                {
                                                    user.child("coins").setValue(userCoins + coins);
                                                }
                                            }
                                        }
                                    });
                                }
                            }
                        });

                        FirebaseDatabase.getInstance().getReference().child("Questions").child("Question" + randomNumber).child("answerImpact3").get().addOnCompleteListener(
                                new OnCompleteListener<DataSnapshot>() {
                                    @Override
                                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                                        if (task.isSuccessful()) {
                                            DataSnapshot dataSnapshot = task.getResult();
                                            AnswerImpact answerImpact = dataSnapshot.getValue(AnswerImpact.class);
                                            DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(FirebaseAuth.getInstance().getUid()).child(finalContinent).child("stats");
                                            mDatabase.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                                @Override
                                                public void onComplete(@NonNull Task<DataSnapshot> task) {
                                                    if (task.isSuccessful()) {
                                                        DataSnapshot dataSnapshot = task.getResult();
                                                        AnswerImpact stats = dataSnapshot.getValue(AnswerImpact.class);
                                                        if (stats.getCo2() + answerImpact.getCo2() <= 0){
                                                            mDatabase.child("co2").setValue(0);
                                                        }
                                                        else if (stats.getCo2() + answerImpact.getCo2() >= 100){
                                                            mDatabase.child("co2").setValue(100);
                                                        }
                                                        else
                                                        {
                                                            mDatabase.child("co2").setValue(stats.getCo2() + answerImpact.getCo2());
                                                        }
                                                        //==================================================================================================\\
                                                        if (stats.getSeaLevel() + answerImpact.getSeaLevel() <= 0){
                                                            mDatabase.child("seaLevel").setValue(0);
                                                        }
                                                        else if (stats.getSeaLevel() + answerImpact.getSeaLevel() >= 100){
                                                            mDatabase.child("seaLevel").setValue(100);
                                                        }
                                                        else
                                                        {
                                                            mDatabase.child("seaLevel").setValue(stats.getSeaLevel() + answerImpact.getSeaLevel());
                                                        }
                                                        //==================================================================================================\\
                                                        if(stats.getAirPollution() + answerImpact.getAirPollution() <= 0){
                                                            mDatabase.child("airPollution").setValue(0);
                                                        }
                                                        else if (stats.getAirPollution() + answerImpact.getAirPollution() >= 100){
                                                            mDatabase.child("airPollution").setValue(100);
                                                        }
                                                        else
                                                        {
                                                            mDatabase.child("airPollution").setValue(stats.getAirPollution() + answerImpact.getAirPollution());
                                                        }
                                                        //==================================================================================================\\
                                                        if (stats.getOceanAcidification() + answerImpact.getOceanAcidification() <= 0){
                                                            mDatabase.child("oceanAcidification").setValue(0);
                                                        }
                                                        else if (stats.getOceanAcidification() + answerImpact.getOceanAcidification() >= 100){
                                                            mDatabase.child("oceanAcidification").setValue(100);
                                                        }
                                                        else
                                                        {
                                                            mDatabase.child("oceanAcidification").setValue(stats.getOceanAcidification() + answerImpact.getOceanAcidification());
                                                        }
                                                        //==================================================================================================\\
                                                        if (stats.getSocialInequity() + answerImpact.getSocialInequity() <= 0){
                                                            mDatabase.child("socialInequity").setValue(0);
                                                        }
                                                        else if (stats.getSocialInequity() + answerImpact.getSocialInequity() >= 100){
                                                            mDatabase.child("socialInequity").setValue(100);
                                                        }
                                                        else
                                                        {
                                                            mDatabase.child("socialInequity").setValue(stats.getSocialInequity() + answerImpact.getSocialInequity());
                                                        }
                                                        //==================================================================================================\\
                                                        if (stats.getBioDiversity() + answerImpact.getBioDiversity() <= 0){
                                                            mDatabase.child("bioDiversity").setValue(0);
                                                        }
                                                        else if (stats.getBioDiversity() + answerImpact.getBioDiversity() >= 100){
                                                            mDatabase.child("bioDiversity").setValue(100);
                                                        }
                                                        else
                                                        {
                                                            mDatabase.child("bioDiversity").setValue(stats.getBioDiversity() + answerImpact.getBioDiversity());
                                                        }
                                                        //==================================================================================================\\
                                                        if (stats.getWeatherEvents() + answerImpact.getWeatherEvents() <= 0){
                                                            mDatabase.child("weatherEvents").setValue(0);
                                                        }
                                                        else if (stats.getWeatherEvents() + answerImpact.getWeatherEvents() >= 100){
                                                            mDatabase.child("weatherEvents").setValue(100);
                                                        }
                                                        else
                                                        {
                                                            mDatabase.child("weatherEvents").setValue(stats.getWeatherEvents() + answerImpact.getWeatherEvents());
                                                        }
                                                        //==================================================================================================\\
                                                        if (stats.getGreenhouseGases() + answerImpact.getGreenhouseGases() <= 0){
                                                            mDatabase.child("greenhouseGases").setValue(0);
                                                        }
                                                        else if (stats.getGreenhouseGases() + answerImpact.getGreenhouseGases() >= 100){
                                                            mDatabase.child("greenhouseGases").setValue(100);
                                                        }
                                                        else
                                                        {
                                                            mDatabase.child("greenhouseGases").setValue(stats.getGreenhouseGases() + answerImpact.getGreenhouseGases());
                                                        }
                                                    }
                                                }
                                            });
                                        }
                                    }
                                });

                        Toast.makeText(WorldMap.this, "Option 3 Selected!", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });



                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                lp.copyFrom(dialog.getWindow().getAttributes());
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.height = WindowManager.LayoutParams.MATCH_PARENT;
                dialog.show();
                dialog.getWindow().setAttributes(lp);


                FirebaseDatabase.getInstance().getReference().child("Questions").child("Question" + randomNumber).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (task.isSuccessful()) {
                            DataSnapshot dataSnapshot = task.getResult();
                            question.setText(dataSnapshot.child("question").getValue().toString() + "\nContinent:- " + finalContinent);
                            option1Text.setText(dataSnapshot.child("option1").getValue().toString());
                            option2Text.setText(dataSnapshot.child("option2").getValue().toString());
                            option3Text.setText(dataSnapshot.child("option3").getValue().toString());
                            coins1.setText(dataSnapshot.child("coins1").getValue().toString());
                            coins2.setText(dataSnapshot.child("coins2").getValue().toString());
                            coins3.setText(dataSnapshot.child("coins3").getValue().toString());

                            option1P.setText(dataSnapshot.child("option1P").getValue().toString());
                            option1N.setText(dataSnapshot.child("option1N").getValue().toString());
                            option2P.setText(dataSnapshot.child("option2P").getValue().toString());
                            option2N.setText(dataSnapshot.child("option2N").getValue().toString());
                            option3P.setText(dataSnapshot.child("option3P").getValue().toString());
                            option3N.setText(dataSnapshot.child("option3N").getValue().toString());
                        }
                    }
                });

            }
        });
    }
}