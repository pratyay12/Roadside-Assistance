package com.example.roadsideassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddRefreshmentServices extends AppCompatActivity {
    EditText mRefreshmentName, mRefreshmentAddress;
    Button mSubmit;
    DatabaseReference reff;
    Refreshments refreshment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_refreshment_services);

        mRefreshmentName = (EditText) findViewById(R.id.etRname);
        mRefreshmentAddress = (EditText) findViewById(R.id.etRaddress);

        mSubmit = (Button) findViewById(R.id.btnSubmit);
        reff = FirebaseDatabase.getInstance().getReference().child("Refreshment");

        refreshment = new Refreshments();
        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mRefreshmentName.getText().toString().isEmpty()){
                    mRefreshmentName.setError("Please Enter Refreshment Centre Name");
                    mRefreshmentName.requestFocus();
                }
                else if(mRefreshmentAddress.getText().toString().isEmpty()){
                    mRefreshmentAddress.setError("Please Enter Refreshment Centre Address ");
                    mRefreshmentAddress.requestFocus();
                }
                else {
                    refreshment.setRefreshmentcity(mRefreshmentAddress.getText().toString());
                    refreshment.setRefreshmentname(mRefreshmentName.getText().toString());
                }

                reff.push().setValue(refreshment);
                Toast.makeText(AddRefreshmentServices.this,"Data Inserted Succesfully", Toast.LENGTH_LONG).show();
            }
        });
    }
}
