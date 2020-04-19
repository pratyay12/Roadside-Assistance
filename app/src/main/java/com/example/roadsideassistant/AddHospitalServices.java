package com.example.roadsideassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddHospitalServices extends AppCompatActivity {
    EditText mHospitalName, mHospitalCity, mHospitalNumber, mHospitalAddress,mHospitalRoad;
    Button mSubmit;
    DatabaseReference reff;
    Hospital hospital;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_hospital_services);

        mHospitalName = (EditText) findViewById(R.id.etHname);
        mHospitalCity = (EditText) findViewById(R.id.etHcity);
        mHospitalNumber = (EditText) findViewById(R.id.etHnumber);
        mHospitalAddress = (EditText) findViewById(R.id.etHaddress);
        mHospitalRoad = (EditText) findViewById(R.id.etHroad);
        mSubmit = (Button) findViewById(R.id.btnSubmit);
        reff = FirebaseDatabase.getInstance().getReference().child("Hospital");

        hospital = new Hospital();
        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mHospitalName.getText().toString().isEmpty()){
                    mHospitalName.setError("Please Enter Garage Name");
                    mHospitalName.requestFocus();
                }
                else if(mHospitalCity.getText().toString().isEmpty()){
                    mHospitalCity.setError("Please Enter Garage City");
                    mHospitalCity.requestFocus();
                }

                else if(mHospitalNumber.getText().toString().isEmpty()){
                    mHospitalNumber.setError("Please Enter Garage Number");
                    mHospitalNumber.requestFocus();
                }
                else if(mHospitalNumber.getText().toString().length() < 9)
                {
                    mHospitalNumber.setError("Please Enter Correct Garage Number");
                    mHospitalNumber.requestFocus();
                }
                else if(mHospitalNumber.getText().toString().length() >13)
                {
                    mHospitalNumber.setError("Please Enter Correct Garage Number");
                    mHospitalNumber.requestFocus();
                }
                else if(mHospitalRoad.getText().toString().isEmpty()){
                    mHospitalRoad.setError("Please Enter Garage Road");
                    mHospitalRoad.requestFocus();
                }
                else if(mHospitalAddress.getText().toString().isEmpty()){
                    mHospitalAddress.setError("Please Enter Garage Address");
                    mHospitalAddress.requestFocus();
                }
                else {
                    hospital.setCity(mHospitalCity.getText().toString());
                    hospital.setContact(mHospitalNumber.getText().toString());
                    hospital.setName(mHospitalName.getText().toString());
                    hospital.setRoad(mHospitalRoad.getText().toString());
                    hospital.setAddress(mHospitalAddress.getText().toString());

                    reff.push().setValue(hospital);
                    Toast.makeText(AddHospitalServices.this, "Data Inserted Succesfully", Toast.LENGTH_LONG).show();
                }
                }
        });
    }
}
