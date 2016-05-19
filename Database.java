package com.example.test.testdb;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;


public class Database extends SQLiteOpenHelper {
    public static final int DATABASE_version=1;
    public static final String DATABASE_NAME="user_db";
    public static final String Table_Name="stu";

    public Database(Context context) {
        super(context, DATABASE_NAME,null, DATABASE_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    String s="Create Table "+Table_Name+"(id INTEGER, fname TEXT, lname TEXT);";
        db.execSQL(s);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exist"+Table_Name);
    }
    public void insert(Student s1){
        SQLiteDatabase sh1=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("id",s1.getId());
        cv.put("fname",s1.getFname());
        cv.put("lname",s1.getLname());
        sh1.insert(Table_Name, null, cv);
        Log.e("Inserted...", "Successfully..");

    }
    public ArrayList<Student>showdata() {
        SQLiteDatabase sh1 = getReadableDatabase();
        ArrayList<Student> alist = new ArrayList<Student>();
        Cursor c = sh1.rawQuery("SELECT * FROM stu", null);
        c.moveToFirst();
        if (c != null) {

            do {
                Student s1 = new Student();
                s1.setId(Integer.parseInt(c.getString(0)));
                s1.setFname(c.getString(1));
                s1.setLname(c.getString(2));
                alist.add(s1);
            } while (c.moveToNext());

        }
   return alist;
    }
    public void update(Student s1){
        SQLiteDatabase sd=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("id",s1.getId());
        cv.put("fname",s1.getFname());
        cv.put("lname",s1.getFname());
        sd.update(Table_Name, cv, "id=?", new String[]{String.valueOf(s1.getId())});
        Log.e("Updated..","update");


    }
    public void delete(Student s1){

        SQLiteDatabase st=getWritableDatabase();
        st.delete(Table_Name,"id=?",new String[]{String.valueOf(s1.getId())});
    }
}
