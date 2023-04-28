package com.aleenaadil.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;

public class ChangePassword extends AppCompatActivity {

    //*****************************************************************\\
    //declaring buttons
    ImageButton back_Btn;
    Button confirm_Btn;
    EditText current_password, new_password, repeat_password;
    FirebaseAuth auth;
    FirebaseDatabase database;
    FirebaseUser user;
    //********************************************************************\\

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        //********************************************************************\\
        //---------------------linking buttons----------------------------------------
        back_Btn = (ImageButton)findViewById(R.id.back_btn);
        confirm_Btn=(Button)findViewById(R.id.confirm_button);
        current_password=(EditText)findViewById(R.id.current_password);
        new_password=(EditText)findViewById(R.id.new_password);
        repeat_password=(EditText)findViewById(R.id.repeat_password);
        database = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();

        //********************************************************************\\


        //goes back to the profile screen where password can be changed
        //needs to erase whatever was typed, as in, just do nothing and go back
        back_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),ProfileScreen.class);
                startActivity(i);
            }
        });

        //goes back to the profile screen where password can be changed
        //needs to update password saved in db
        confirm_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String oldPass=current_password.getText().toString();
                String newPass=new_password.getText().toString();
                String repeatPass=repeat_password.getText().toString();
                String curr_email = auth.getCurrentUser().getEmail();
                user = auth.getCurrentUser();

                if(oldPass.equals("") || newPass.equals("") || repeatPass.equals("")){
                    current_password.setError("Please enter all fields");
                    new_password.setError("Please enter all fields");
                    repeat_password.setError("Please enter all fields");
                }
                else if(!newPass.equals(repeatPass)){
                    new_password.setError("Passwords do not match");
                    repeat_password.setError("Passwords do not match");
                }
                else{
                    database.getReference().child("Users").child(auth.getUid()).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {
                            if(task.isSuccessful()){
                                String currPass = task.getResult().child("password").getValue().toString();
                                if(currPass.equals(oldPass)){
                                    database.getReference().child("Users").child(auth.getUid()).child("password").setValue(newPass);
                                    user.updatePassword(newPass);
                                    Intent i=new Intent(getApplicationContext(),ProfileScreen.class);
                                    startActivity(i);
                                }
                                else{
                                    current_password.setError("Incorrect password");
                                }
                            }
                        }
                    });
                }

            }
        });

        //********************************************************************\\

    }
}