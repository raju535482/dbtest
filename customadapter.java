package com.example.test.testdb;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class customadapter extends BaseAdapter {
    Context context;
    ArrayList<Student> alist;

    public customadapter(Context context,ArrayList<Student>alist) {
        this.context = context;
        this.alist=alist;
    }


    @Override
    public int getCount() {
        return alist.size();
    }

    @Override
    public Object getItem(int position) {
        return alist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final Student s1=alist.get(position);
        LayoutInflater inf=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        convertView=inf.inflate(R.layout.list,null);
        TextView tv1,tv2,tv3;
        tv1=(TextView)convertView.findViewById(R.id.tvid);
        tv2= (TextView) convertView.findViewById(R.id.tvfname);
        tv3= (TextView) convertView.findViewById(R.id.tvlname);
        tv1.setText(Integer.toString(s1.getId()));
        tv2.setText(s1.getFname());
        tv3.setText(s1.getLname());
        Button update=(Button)convertView.findViewById(R.id.btup);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context,MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("id",Integer.toString(s1.getId()));
                i.putExtra("fname",s1.getFname());
                i.putExtra("lname",s1.getLname());
                v.getContext().startActivity(i);

            }
        });
        Button delete=(Button)convertView.findViewById((R.id.btdel));
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Database db;
                db=new Database(context);
                db.delete(s1);
                Intent i=new Intent(context,MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                v.getContext().startActivity(i);
            }
        });
        return  convertView;
    }
}
