package com.example.donateblood;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    FirebaseAuth mfirebaseAuth;
    String user_id;
    ListView userList;
    DataModel dataModel;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    List<DataModel> dataModelList;

    DatabaseReference all;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        if(!isConnected(UserActivity.this)) buildDialog(UserActivity.this).show();
        else{

        }
        mfirebaseAuth = FirebaseAuth.getInstance();


        dataModelList = new ArrayList<>();

        drawerLayout = findViewById(R.id.drawyer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(UserActivity.this, drawerLayout, R.string.nav_open, R.string.nav_closed);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = findViewById(R.id.navigation_view);

        navigationView.setNavigationItemSelectedListener(this);
        userList = findViewById(R.id.userList);


        all = FirebaseDatabase.getInstance().getReference("All");




    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentuser = mfirebaseAuth.getCurrentUser();

        if(currentuser == null){
            Intent i = new Intent(UserActivity.this, MainActivity.class);
            startActivity(i);
            finish();
        }else{
            user_id = mfirebaseAuth.getCurrentUser().getUid();
            all.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    dataModelList.clear();
                    for(DataSnapshot data : dataSnapshot.getChildren() ){

                        dataModel = data.getValue(DataModel.class);
                        if(user_id.equals(dataModel.getId())) {
                            dataModelList.add(dataModel);
                        }
                    }

                    if(user_id.equals(dataModel.getId())){

                        DataAdapter adapter = new DataAdapter(UserActivity.this, dataModelList);
                        userList.setAdapter(adapter);


                    }


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

        }


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){
            case R.id.opositiveId:
                Intent i = new Intent(UserActivity.this, DonorList.class);
                startActivity(i);
                break;
        }

        switch (menuItem.getItemId()){
            case R.id.onegativeId:
                Intent i = new Intent(UserActivity.this, Onegative.class);
                startActivity(i);
                break;
        }
        switch (menuItem.getItemId()){
            case R.id.apositiveId:
                Intent i = new Intent(UserActivity.this, Apositive.class);
                startActivity(i);
                break;
        }
        switch (menuItem.getItemId()){
            case R.id.anegativeId:
                Intent i = new Intent(UserActivity.this, Anegative.class);
                startActivity(i);
                break;
        }
        switch (menuItem.getItemId()){
            case R.id.abpositiveId:
                Intent i = new Intent(UserActivity.this, ABpositive.class);
                startActivity(i);
                break;
        }
        switch (menuItem.getItemId()){
            case R.id.abnegativeId:
                Intent i = new Intent(UserActivity.this, ABnegative.class);
                startActivity(i);
                break;
        }
        switch (menuItem.getItemId()){
            case R.id.bpositiveId:
                Intent i = new Intent(UserActivity.this, Bpositive.class);
                startActivity(i);
                break;
        }
        switch (menuItem.getItemId()){
            case R.id.bnegativeId:
                Intent i = new Intent(UserActivity.this, Bnegative.class);
                startActivity(i);
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean isConnected(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netinfo = cm.getActiveNetworkInfo();

        if (netinfo != null && netinfo.isConnectedOrConnecting()) {
            android.net.NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            android.net.NetworkInfo mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if((mobile != null && mobile.isConnectedOrConnecting()) || (wifi != null &&wifi.isConnectedOrConnecting())) return true;
        else return false;
        } else
        return false;
    }
    public AlertDialog.Builder buildDialog(Context c) {

        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setCancelable(false);
        builder.setTitle("No Internet Connection");
        builder.setMessage("You need to have Mobile Data or wifi to access this. Press ok to Exit");

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                finish();
            }
        });

        return builder;
    }


}
