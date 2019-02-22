package com.example.donateblood;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Onegative extends AppCompatActivity {

    ListView onegative;
    DatabaseReference databaseReference;
    List<DataModel> dataModelList;

    FirebaseAuth mfirebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onegative);

        mfirebaseAuth = FirebaseAuth.getInstance();

        onegative = findViewById(R.id.onegativeList);



        dataModelList = new ArrayList<>();

        databaseReference = FirebaseDatabase.getInstance().getReference("Onegative");
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                dataModelList.clear();
                for(DataSnapshot data : dataSnapshot.getChildren() ){

                    DataModel dataModel = data.getValue(DataModel.class);
                    dataModelList.add(dataModel);

                }

                DataAdapter adapter = new DataAdapter(Onegative.this, dataModelList);
                onegative.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }



}
