package com.example.roadsideassistant;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;


public class Register extends AppCompatActivity {
    EditText emailId;
    EditText password;
    EditText phonenumber;
    ImageView phone;
    Button btnSignup;
    TextView signin;
    FirebaseAuth mFirebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFirebaseAuth = FirebaseAuth.getInstance();


        emailId=findViewById(R.id.suname);
        password=findViewById(R.id.spass);
        btnSignup=findViewById(R.id.btn1);
        signin = findViewById(R.id.btn3);
        phonenumber = findViewById(R.id.sphn);
        //phone = findViewById(R.id.ephone);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailId.getText().toString();
                final String pwd = password.getText().toString();
                String phn = phonenumber.getText().toString();

                if(email.isEmpty())
                {
                    emailId.setError("Please enter email id");
                    emailId.requestFocus();
                }
                else if(pwd.isEmpty())
                {
                    emailId.setError("Please enter password");
                    emailId.requestFocus();
                }
                else if(email.isEmpty() && pwd.isEmpty())
                {
                    Toast.makeText(Register.this,"Fields are empty!",Toast.LENGTH_SHORT).show();
                }


                else if(!(email.isEmpty() && pwd.isEmpty()))
                {
                    mFirebaseAuth.createUserWithEmailAndPassword(email,pwd).addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()) {
                                if (pwd.length() < 8) {
                                    Toast.makeText(Register.this, "Please Enter Minimum 8 Characters", Toast.LENGTH_SHORT).show();
                                }
                                else if (task.getException() instanceof FirebaseAuthUserCollisionException){
                                    Toast.makeText( getApplicationContext(),"You are already registered",Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    Toast.makeText(Register.this, "Sign Up Unsuccessful!", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else if(task.isSuccessful())
                            {
                                startActivity(new Intent(Register.this, Home.class));
                                Toast.makeText(Register.this,"SignUp Successful!",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }


                signin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(Register.this, MainActivity.class);
                        startActivity(i);

                    }
                });

            }
        });
    }}