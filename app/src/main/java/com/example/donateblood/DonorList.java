package com.example.donateblood;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DonorList extends AppCompatActivity {

    ListView listView;

    DatabaseReference databaseReference;
    List<DataModel> dataModelList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_list);

        listView = findViewById(R.id.donorlist);

        dataModelList = new ArrayList<>();

        databaseReference = FirebaseDatabase.getInstance().getReference("Blood");


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

                DataAdapter adapter = new DataAdapter(DonorList.this, dataModelList);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
