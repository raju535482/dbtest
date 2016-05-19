package com.example.test.testdb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
    TextView tv1, tv2, tv3;
    EditText ed1, ed2, ed3;
    Button bt1, bt2;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView) findViewById(R.id.t1);
        tv2 = (TextView) findViewById(R.id.t2);
        tv3 = (TextView) findViewById(R.id.t3);
        ed1 = (EditText) findViewById(R.id.edt1);
        ed2 = (EditText) findViewById(R.id.edt2);
        ed3 = (EditText) findViewById(R.id.edt3);
        bt1 = (Button) findViewById(R.id.Btn1);
        bt2 = (Button) findViewById(R.id.Btn2);
        db = new Database(getApplicationContext());
        if (getIntent().getExtras() != null) {
            ed1.setText(getIntent().getStringExtra("id"));
            ed2.setText(getIntent().getStringExtra("fname"));
            ed3.setText(getIntent().getStringExtra("lname"));
            bt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Student s1 = new Student();
                    s1.setId(Integer.parseInt(ed1.getText().toString()));
                    s1.setFname(ed2.getText().toString());
                    s1.setLname(ed3.getText().toString());
                    db.update(s1);
                    Toast.makeText(getApplicationContext(), "updated....", Toast.LENGTH_LONG).show();
                }
            });
        } else {
            bt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Student s1 = new Student();
                    s1.setId(Integer.parseInt(ed1.getText().toString()));
                    s1.setFname(ed2.getText().toString());
                    s1.setLname(ed3.getText().toString());
                    db.insert(s1);
                    Toast.makeText(getApplication(), "Inserted...", Toast.LENGTH_LONG).show();


                }
            });
        }
            bt2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getApplication(), Display.class);
                    startActivity(i);
                }
            });
        }
    }

