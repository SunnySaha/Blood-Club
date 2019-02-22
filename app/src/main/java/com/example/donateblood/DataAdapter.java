package com.example.donateblood;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends ArrayAdapter<DataModel> {

    private Activity context;
    private List<DataModel> datalist;


    public DataAdapter(Activity context, List<DataModel> datalist){
        super(context, R.layout.donor_layout, datalist);
        this.context = context;
        this.datalist = datalist;
    }


    @Override
    public View getView(int position, View convertView,ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View dataView = inflater.inflate(R.layout.donor_layout, null, true);

        TextView name, age, phone, lastdate, address, bloodgroup;
        name = dataView.findViewById(R.id.showname);
        age = dataView.findViewById(R.id.showage);
        bloodgroup = dataView.findViewById(R.id.showbloodgroup);
        phone = dataView.findViewById(R.id.showphone);
        lastdate = dataView.findViewById(R.id.showlastdate);
        address = dataView.findViewById(R.id.showaddress);

        final DataModel dataModel = datalist.get(position);

        name.setText("Name: "+dataModel.getName());
        age.setText("Age: "+dataModel.getAge());
        bloodgroup.setText("Blood Group: "+dataModel.getBloodgroup() );
        phone.setText("Contact: "+dataModel.getPhone());
        lastdate.setText("last Donate Date: "+dataModel.getLastdate());
        address.setText("Address: "+dataModel.getAddress());

        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+dataModel.getPhone()));
                context.startActivity(intent);


            }
        });



        return dataView;
    }
}
