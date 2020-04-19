package com.example.roadsideassistant;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.roadsideassistant.R;

public class Emergancy extends AppCompatActivity {

    ImageView callchar,callchar1,callchar2,callchar3,callchar4;
    EditText charphn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_emergancy );

        callchar = findViewById(R.id.imageViewEmergency);
        callchar1 = findViewById(R.id.imageViewEmergency2);
        callchar2 = findViewById(R.id.imageViewEmergency3);
        callchar3 = findViewById(R.id.imageView4);
        callchar4 = findViewById(R.id.imageview5);



        callchar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL); //use ACTION_CALL class
                callIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                callIntent.setData(Uri.parse("tel:+919537927873"));    //this is the phone number calling
                    startActivity(callIntent);
            }




        } );
        callchar1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL); //use ACTION_CALL class
                callIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                callIntent.setData(Uri.parse("tel:+919737114455"));    //this is the phone number calling
                startActivity(callIntent);
            }




        } );
        callchar2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL); //use ACTION_CALL class
                callIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                callIntent.setData(Uri.parse("tel:+91100"));    //this is the phone number calling
                startActivity(callIntent);
            }




        } );
        callchar3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL); //use ACTION_CALL class
                callIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                callIntent.setData(Uri.parse("tel:+911091"));    //this is the phone number calling
                startActivity(callIntent);
            }




        } );
        callchar4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL); //use ACTION_CALL class
                callIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                callIntent.setData(Uri.parse("tel:+917574838111"));    //this is the phone number calling
                startActivity(callIntent);
            }




        } );



    }


}
