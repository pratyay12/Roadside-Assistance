package com.example.roadsideassistant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity {
    private CardView mlogout,mtwowheeler,mfourwheeler,memergancey,mhospital;
    private LinearLayout mrefreshment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mlogout = findViewById(R.id.lg);
        memergancey = findViewById(R.id.cs);
        mfourwheeler = findViewById(R.id.fw);
        mhospital = findViewById(R.id.hs);
        mrefreshment = findViewById(R.id.rs);
        mtwowheeler = findViewById(R.id.tw);

        mtwowheeler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this,DataRetrieved.class));
            }
        });
        mfourwheeler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this,DataRetrieved.class));
            }
        });
        mhospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this,DataRetrieved.class));
            }
        });
        mrefreshment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this,DataRetrieved.class));
            }
        });
        mlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                /** startActivity( new Intent( HomeActivity.this,LoginActivity.class ) );
                 */
                Intent intent = new Intent( Home.this,MainActivity.class);
                intent.addFlags( Intent.FLAG_ACTIVITY_CLEAR_TOP );
                startActivity( intent );

            }
        });
        memergancey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this,Emergancy.class));
            }
        });



    }
}
