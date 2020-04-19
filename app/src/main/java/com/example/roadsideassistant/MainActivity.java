package com.example.roadsideassistant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private Button Signup;
    EditText emailId,password;
    Button btnSignIn;
    ImageView emergencybutton;
    TextView fpass;
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        Signup = findViewById(R.id.tvRegister_here);
        btnSignIn =  findViewById(R.id.btnLogin);
        emailId = findViewById(R.id.et1);
        password = findViewById(R.id.et2);
    emergencybutton=findViewById(R.id.Emergency_call);
        FirebaseAuth.getInstance().signOut();
        mAuth = FirebaseAuth.getInstance();
    fpass = findViewById(R.id.btn3);
;        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = mAuth.getCurrentUser();
                if(user!=null){
                    Toast.makeText(MainActivity.this, "You are Logged In",
                            Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this,Home.class));
                }

            }
        };
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Register.class));
            }
        });
        fpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ForgotActivity.class));
            }
        });



        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=emailId.getText().toString();
                String pwd=password.getText().toString();

                if(email.isEmpty()){
                    emailId.setError("Please Enter Email");
                    emailId.requestFocus();
                }

                else if(pwd.isEmpty()){
                    password.setError("Please Enter Password");
                    password.requestFocus();
                }

                else if(email.isEmpty() && pwd.isEmpty()){
                    Toast.makeText(MainActivity.this, "Fields Are Empty",
                            Toast.LENGTH_SHORT).show();
                }
                else if(email.equals("a") && pwd.equals("a")){
                    Toast.makeText(MainActivity.this, "Welcome Admin!",
                            Toast.LENGTH_SHORT).show();
                    Intent a = new Intent(MainActivity.this,HomeAdmin.class);
                    startActivity(a);
                    a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                }

                else if(!(email.isEmpty() && pwd.isEmpty())){
                    mAuth.signInWithEmailAndPassword(email,pwd)
                            .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {

                                @Override
                                public void onComplete(@NonNull Task task) {
                                    if (task.isSuccessful()) {
                                        startActivity(new Intent(MainActivity.this,Home.class));

                                    } else {
                                        // If sign in fails, display a message to the user.

                                        Toast.makeText(MainActivity.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                    // ...
                                }
                            });
                }
            }
        });

        emergencybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Emergancy.class));
            }
        });





    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAuth.removeAuthStateListener(mAuthListener);
    }


}
