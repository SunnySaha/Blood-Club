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

public class Bpositive extends AppCompatActivity  {

    ListView bpositive;
    FirebaseAuth mfirebaseAuth;
    DatabaseReference databaseReference;
    List<DataModel> dataModelList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bpositive);

        mfirebaseAuth = FirebaseAuth.getInstance();

        bpositive = findViewById(R.id.bpositivelist);


        dataModelList = new ArrayList<>();

        databaseReference = FirebaseDatabase.getInstance().getReference("Bpositive");
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

                DataAdapter adapter = new DataAdapter(Bpositive.this, dataModelList);
                bpositive.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


}
