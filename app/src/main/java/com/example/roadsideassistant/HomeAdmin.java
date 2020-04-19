package com.example.roadsideassistant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;

public class HomeAdmin extends AppCompatActivity {
    private CardView mFourWheeler,mTwoWheeler, mHospital, mRefreshment,mLogout,mEmergancy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_admin);



        mFourWheeler = (CardView) findViewById(R.id.etfw);
        mHospital = (CardView) findViewById(R.id.eths);
        mTwoWheeler = (CardView) findViewById(R.id.ettw);
        mRefreshment = (CardView) findViewById(R.id.etrs);
        mLogout = (CardView) findViewById(R.id.etlog);
        mEmergancy = (CardView) findViewById(R.id.etemer);

        mFourWheeler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeAdmin.this,AddFourWheelerServices.class);
                startActivity(i);
            }
        });

        mHospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeAdmin.this,AddHospitalServices.class);
                startActivity(i);
            }
        });

        mTwoWheeler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeAdmin.this,AddTwoWheeler.class);
                startActivity(i);
            }
        });

        mRefreshment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeAdmin.this,AddRefreshmentServices.class);
                startActivity(i);
            }
        });

        mEmergancy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeAdmin.this,Emergancy.class);
                startActivity(i);
            }
        });

        mLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                /** startActivity( new Intent( HomeActivity.this,LoginActivity.class ) );
                 */
                Intent intent = new Intent( HomeAdmin.this,MainActivity.class);
                intent.addFlags( Intent.FLAG_ACTIVITY_CLEAR_TOP );
                startActivity( intent );

            }
        } );



            }}
