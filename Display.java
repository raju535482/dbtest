package com.example.test.testdb;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by root on 4/2/16.
 */
public class Display extends Activity {
    ListView lv;
    Database db;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lv = (ListView) findViewById(R.id.lv1);
        db = new Database(getApplicationContext());

        ArrayList<Student> alist = new ArrayList<Student>();

            alist = db.showdata();
            //ArrayAdapter<Student> aa=new ArrayAdapter<Student>(getApplicationContext(),android.R.layout.simple_list_item_1,alist);

            customadapter aa = new customadapter(getApplicationContext(), alist);
            lv.setAdapter(aa);
        }

    }
