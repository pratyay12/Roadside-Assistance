package com.example.roadsideassistant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DataRetrieved extends AppCompatActivity {
    private ListView listView;
    DatabaseReference reff;
    List<Refreshments>refreshmentsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_retrieved);

        listView = findViewById(R.id.list_view);
        reff = FirebaseDatabase.getInstance().getReference().child("Refreshment");
        refreshmentsList = new ArrayList<>();


    }

    @Override
    protected void onStart() {
        super.onStart();
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot refreshmentSnapshot : dataSnapshot.getChildren()) {

                    Refreshments refreshment = refreshmentSnapshot.getValue(Refreshments.class);
                    refreshmentsList.add(refreshment);
                }
                RefreshmentInfoAdapter refreshmentInfoAdapter = new RefreshmentInfoAdapter(DataRetrieved.this, refreshmentsList);
                listView.setAdapter(refreshmentInfoAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
