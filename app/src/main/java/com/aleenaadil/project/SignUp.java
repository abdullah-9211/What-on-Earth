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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignUp extends AppCompatActivity {
    EditText name, email, password;
    Button signup;
    FirebaseAuth auth;
    FirebaseDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name = findViewById(R.id.nameInput2);
        email = findViewById(R.id.emailinput2);
        password = findViewById(R.id.passinput2);
        signup = findViewById(R.id.signup_btn);
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        signup.setOnClickListener(v -> {
            String nameStr = this.name.getText().toString();
            String emailStr = this.email.getText().toString();
            String passwordStr = this.password.getText().toString();

            if (nameStr.isEmpty() || emailStr.isEmpty() || passwordStr.isEmpty()) {
                this.name.setError("Please enter your name");
                this.email.setError("Please enter your email");
                this.password.setError("Please enter your password");
            } else {
                createUser(nameStr, emailStr, passwordStr);
            }

        });
    }


    private void createUser(String nameStr, String emailStr, String passwordStr) {
        auth.createUserWithEmailAndPassword(emailStr, passwordStr).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    FirebaseUser user = task.getResult().getUser();
                    String userid = user.getUid();

                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users").child(userid);

                    database.getReference().child("Users").child(FirebaseAuth.getInstance().getUid())
                            .addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    User users = snapshot.getValue(User.class);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });
                    AnswerImpact stats = new AnswerImpact(30,30,30,30,30,30,30,30,0,30);
                    Continent asia = new Continent("Asia", stats);
                    Continent africa = new Continent("Africa", stats);
                    Continent europe = new Continent("Europe", stats);
                    Continent northAmerica = new Continent("North America", stats);
                    Continent southAmerica = new Continent("South America", stats);
                    Continent oceania = new Continent("Oceania", stats);
                    User insertUser = new User(nameStr, emailStr, passwordStr, 50000, 2020, 0, 200000000, asia, africa, europe, northAmerica, southAmerica, oceania, 3.5);


                    reference.setValue(insertUser).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(SignUp.this, "User Created", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(SignUp.this, Login.class));
                                finish();
                            }
                        }
                    });

                }
                else{
                    Toast.makeText(SignUp.this, "" +  task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}