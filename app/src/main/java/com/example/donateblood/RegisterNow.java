package com.example.donateblood;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.HashMap;
import java.util.Map;

public class RegisterNow extends AppCompatActivity {

    EditText editname, editage, editlastdate, editphone, editaddress, editemail, editpass;
    Button registrarionButton, backtologin;
    Spinner spinner;

    FirebaseAuth mfirebaseAuth;
    FirebaseDatabase mfirebase;
    DatabaseReference databaseReference, databaseReference2;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_now);

        FirebaseApp.initializeApp(this);

        mfirebase = FirebaseDatabase.getInstance();

        mfirebaseAuth = FirebaseAuth.getInstance();

        editemail = findViewById(R.id.email);
        editpass = findViewById(R.id.password);
        editname = findViewById(R.id.name);
        editaddress = findViewById(R.id.address);
        editage = findViewById(R.id.age);
        editlastdate = findViewById(R.id.lastdate);
        editphone = findViewById(R.id.number);
        spinner = findViewById(R.id.bloodgroup);

        backtologin = findViewById(R.id.backlogin);

        registrarionButton = findViewById(R.id.registrationId);

        backtologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RegisterNow.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        registrarionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String name = editname.getText().toString();
                final String age = editage.getText().toString();
                final String bloodgroup = spinner.getSelectedItem().toString();
                final String phone = editphone.getText().toString();
                final String address = editaddress.getText().toString();
                final String lastdate = editlastdate.getText().toString();
                final String email = editemail.getText().toString();
                final String pass = editpass.getText().toString();


                if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(pass) && !TextUtils.isEmpty(bloodgroup)){
                    mfirebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {

                                String user_id = mfirebaseAuth.getCurrentUser().getUid();

                                if (bloodgroup.equals("O Positive")) {
                                    databaseReference = mfirebase.getReference("Blood");
                                    DataModel dataModel = new DataModel(user_id, email, pass, name, age, bloodgroup, phone, address, lastdate);
                                    databaseReference.child(user_id).setValue(dataModel);

                                    databaseReference2 = mfirebase.getReference("All");
                                    DataModel dataModel2 = new DataModel(user_id, email, pass, name, age, bloodgroup, phone, address, lastdate);
                                    databaseReference2.child(user_id).setValue(dataModel2);

                                    Toast.makeText(RegisterNow.this, "Registration Successfull", Toast.LENGTH_SHORT).show();

                                    Intent i = new Intent(RegisterNow.this, MainActivity.class);
                                    i.putExtra("value", user_id);
                                    startActivity(i);
                                    finish();
                                }
                                if (bloodgroup.equals("O Negative")) {
                                    databaseReference = mfirebase.getReference("Onegative");
                                    DataModel dataModel = new DataModel(user_id, email, pass, name, age, bloodgroup, phone, address, lastdate);
                                    databaseReference.child(user_id).setValue(dataModel);

                                    databaseReference2 = mfirebase.getReference("All");
                                    DataModel dataModel2 = new DataModel(user_id, email, pass, name, age, bloodgroup, phone, address, lastdate);
                                    databaseReference2.child(user_id).setValue(dataModel2);
                                    Toast.makeText(RegisterNow.this, "Registration Successfull", Toast.LENGTH_SHORT).show();

                                    Intent i = new Intent(RegisterNow.this, MainActivity.class);
                                    startActivity(i);
                                    finish();
                                }
                                if (bloodgroup.equals("A Positive")) {
                                    databaseReference = mfirebase.getReference("Apositive");
                                    DataModel dataModel = new DataModel(user_id, email, pass, name, age, bloodgroup, phone, address, lastdate);
                                    databaseReference.child(user_id).setValue(dataModel);

                                    databaseReference2 = mfirebase.getReference("All");
                                    DataModel dataModel2 = new DataModel(user_id, email, pass, name, age, bloodgroup, phone, address, lastdate);
                                    databaseReference2.child(user_id).setValue(dataModel2);


                                    Toast.makeText(RegisterNow.this, "Registration Successfull", Toast.LENGTH_SHORT).show();

                                    Intent i = new Intent(RegisterNow.this, MainActivity.class);
                                    startActivity(i);
                                    finish();
                                }
                                if (bloodgroup.equals("A Negative")) {
                                    databaseReference = mfirebase.getReference("Anegative");
                                    DataModel dataModel = new DataModel(user_id, email, pass, name, age, bloodgroup, phone, address, lastdate);
                                    databaseReference.child(user_id).setValue(dataModel);

                                    databaseReference2 = mfirebase.getReference("All");
                                    DataModel dataModel2 = new DataModel(user_id, email, pass, name, age, bloodgroup, phone, address, lastdate);
                                    databaseReference2.child(user_id).setValue(dataModel2);

                                    Toast.makeText(RegisterNow.this, "Registration Successfull", Toast.LENGTH_SHORT).show();

                                    Intent i = new Intent(RegisterNow.this, MainActivity.class);
                                    startActivity(i);
                                    finish();
                                }
                                if (bloodgroup.equals("AB Positive")) {
                                    databaseReference = mfirebase.getReference("ABpositive");
                                    DataModel dataModel = new DataModel(user_id, email, pass, name, age, bloodgroup, phone, address, lastdate);
                                    databaseReference.child(user_id).setValue(dataModel);

                                    databaseReference2 = mfirebase.getReference("All");
                                    DataModel dataModel2 = new DataModel(user_id, email, pass, name, age, bloodgroup, phone, address, lastdate);
                                    databaseReference2.child(user_id).setValue(dataModel2);

                                    Toast.makeText(RegisterNow.this, "Registration Successfull", Toast.LENGTH_SHORT).show();

                                    Intent i = new Intent(RegisterNow.this, MainActivity.class);
                                    startActivity(i);
                                    finish();
                                }
                                if (bloodgroup.equals("AB Negative")) {
                                    databaseReference = mfirebase.getReference("ABnegative");
                                    DataModel dataModel = new DataModel(user_id, email, pass, name, age, bloodgroup, phone, address, lastdate);
                                    databaseReference.child(user_id).setValue(dataModel);

                                    databaseReference2 = mfirebase.getReference("All");
                                    DataModel dataModel2 = new DataModel(user_id, email, pass, name, age, bloodgroup, phone, address, lastdate);
                                    databaseReference2.child(user_id).setValue(dataModel2);

                                    Toast.makeText(RegisterNow.this, "Registration Successfull", Toast.LENGTH_SHORT).show();

                                    Intent i = new Intent(RegisterNow.this, MainActivity.class);
                                    startActivity(i);
                                    finish();
                                }
                                if (bloodgroup.equals("B Positive")) {
                                    databaseReference = mfirebase.getReference("Bpositive");
                                    DataModel dataModel = new DataModel(user_id, email, pass, name, age, bloodgroup, phone, address, lastdate);
                                    databaseReference.child(user_id).setValue(dataModel);

                                    databaseReference2 = mfirebase.getReference("All");
                                    DataModel dataModel2 = new DataModel(user_id, email, pass, name, age, bloodgroup, phone, address, lastdate);
                                    databaseReference2.child(user_id).setValue(dataModel2);

                                    Toast.makeText(RegisterNow.this, "Registration Successfull", Toast.LENGTH_SHORT).show();

                                    Intent i = new Intent(RegisterNow.this, MainActivity.class);
                                    startActivity(i);
                                    finish();
                                }
                                if (bloodgroup.equals("B Negative")) {
                                    databaseReference = mfirebase.getReference("Bnegative");
                                    DataModel dataModel = new DataModel(user_id, email, pass, name, age, bloodgroup, phone, address, lastdate);
                                    databaseReference.child(user_id).setValue(dataModel);

                                    databaseReference2 = mfirebase.getReference("All");
                                    DataModel dataModel2 = new DataModel(user_id, email, pass, name, age, bloodgroup, phone, address, lastdate);
                                    databaseReference2.child(user_id).setValue(dataModel2);

                                    Intent i = new Intent(RegisterNow.this, MainActivity.class);
                                    startActivity(i);
                                    finish();
                                }

                            }
                        }
                    });

            }else{
                    Toast.makeText(RegisterNow.this, "Required Fields and Blood Group needed",Toast.LENGTH_SHORT).show();
                }








            }
        });

    }
}
