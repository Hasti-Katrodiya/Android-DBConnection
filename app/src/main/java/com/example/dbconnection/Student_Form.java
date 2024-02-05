package com.example.dbconnection;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Student_Form extends AppCompatActivity {

    EditText edtName, edtRollno, edtMarks1,edtMarks2,edtMarks3;
    Button btn_submit;

    public  DBHelper dbhelper ;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_form);
        Log.d("Student_Form", "Student_Form activity created");

        edtName = findViewById(R.id.edtName);
        edtRollno = findViewById(R.id.edtRollno);
        edtMarks1 = findViewById(R.id.edtMarks1);
        edtMarks2 = findViewById(R.id.edtMarks2);
        edtMarks3 = findViewById(R.id.edtMarks3);
        btn_submit = findViewById(R.id.btn_submit);
        dbhelper = new DBHelper(Student_Form.this, "MyDB", null, 1);


        btn_submit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                int rno = Integer.parseInt(edtRollno.getText().toString());
                int mrk1 = Integer.parseInt(edtMarks1.getText().toString());
                int mrk2 = Integer.parseInt(edtMarks2.getText().toString());
                int mrk3 = Integer.parseInt(edtMarks3.getText().toString());

                dbhelper.Insert(name,rno,mrk1,mrk2, mrk3);
                Toast.makeText(Student_Form.this, "values inserted", Toast.LENGTH_SHORT).show();

                edtName.setText("");
                edtRollno.setText("");
                edtMarks1.setText("");
                edtMarks2.setText("");
                edtMarks3.setText("");
            }
        });

//
//        btn_submit.setOnClickListener(v -> {
//
//        });




    }
}