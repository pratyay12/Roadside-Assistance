package com.example.roadsideassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddFourWheelerServices extends AppCompatActivity {
    EditText mGarageName, mGarageCity, mGarageNumber, mGarageServices,mGarageRange,mGarageAddress;
    Button mSubmit;
    DatabaseReference reff;
    FourWheeler fourWheeler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_four_wheeler_services);

        mGarageName = (EditText) findViewById(R.id.etGarageName);
        mGarageCity = (EditText) findViewById(R.id.etGarageCity);
        mGarageNumber = (EditText) findViewById(R.id.etHnumber);
        mGarageServices = (EditText) findViewById(R.id.etServices);
        mGarageRange = (EditText) findViewById(R.id.etHroad);
        mGarageAddress = (EditText) findViewById(R.id.etHaddress);
        mSubmit = (Button) findViewById(R.id.btnSubmit);
        reff = FirebaseDatabase.getInstance().getReference().child("FourWheeler");

        fourWheeler = new FourWheeler();
        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mGarageName.getText().toString().isEmpty()){
                    mGarageName.setError("Please Enter Garage Name");
                    mGarageName.requestFocus();
                }
                else if(mGarageCity.getText().toString().isEmpty()){
                    mGarageCity.setError("Please Enter Garage City");
                    mGarageCity.requestFocus();
                }
                else if(mGarageServices.getText().toString().isEmpty()){
                    mGarageServices.setError("Please Enter Garage Services");
                    mGarageServices.requestFocus();
                }
                else if(mGarageNumber.getText().toString().isEmpty()){
                    mGarageNumber.setError("Please Enter Garage Number");
                    mGarageNumber.requestFocus();
                }
                else if(mGarageNumber.getText().toString().length() < 9)
                {
                    mGarageNumber.setError("Please Enter Correct Garage Number");
                    mGarageNumber.requestFocus();
                }
                else if(mGarageNumber.getText().toString().length() >13)
                {
                    mGarageNumber.setError("Please Enter Correct Garage Number");
                    mGarageNumber.requestFocus();
                }
                else if(mGarageRange.getText().toString().isEmpty()){
                    mGarageRange.setError("Please Enter Garage Road");
                    mGarageRange.requestFocus();
                }
                else if(mGarageAddress.getText().toString().isEmpty()){
                    mGarageAddress.setError("Please Enter Garage Address");
                    mGarageAddress.requestFocus();
                }

                else {
                    fourWheeler.setCity(mGarageCity.getText().toString());
                    fourWheeler.setContact(mGarageNumber.getText().toString());
                    fourWheeler.setName(mGarageName.getText().toString());
                    fourWheeler.setRoad(mGarageRange.getText().toString());
                    fourWheeler.setServices(mGarageServices.getText().toString());
                    fourWheeler.setAddress(mGarageAddress.getText().toString());

                    reff.push().setValue(fourWheeler);
                    Toast.makeText(AddFourWheelerServices.this, "Data Inserted Succesfully", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
