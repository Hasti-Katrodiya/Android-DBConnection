package com.example.dbconnection;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.time.LocalDate;

public class DBHelper extends SQLiteOpenHelper {

    private  static  final  String dbname = "MyDB";
    private  static  final  int version = 1;
    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, dbname, null,1 );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table student( student_id integer primary key autoincrement , student_name text, student_rollno integer, student_mark1 integer, student_mark2 integer, student_mark3 integer, total integer, entry_date text )";
        db.execSQL(query);
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public  void Insert(String name, int rollno, int mrk1, int mrk2, int mrk3)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        int Total = mrk1+ mrk2+mrk3;
        LocalDate date = LocalDate.now();
        String d = date.toString();

        ContentValues values = new ContentValues();
        values.put("student_name", name);
        values.put("student_rollno", rollno);
        values.put("student_mark1", mrk1);
        values.put("student_mark2", mrk2);
        values.put("student_mark3", mrk3);
        values.put("total", Total);

        values.put("entry_date", d);

        db.insert("student", null, values);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists student");
        onCreate(db);
    }
}
