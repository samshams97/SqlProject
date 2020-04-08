package com.example.sqlproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText edtName = findViewById(R.id.edt_name);
        final EditText edtFamily = findViewById(R.id.edt_family);
        final EditText edtGrade = findViewById(R.id.edt_grade);
        Button btnSave = findViewById(R.id.btn_save);
        Button btnShow = findViewById(R.id.btn_show);

        final TestDataBase testDataBase = new TestDataBase(MainActivity.this, "sam", null, 1);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                String family = edtFamily.getText().toString();
                String grade = edtGrade.getText().toString();
                testDataBase.insetIntoDb(name, family, Integer.parseInt(grade));

            }
        });
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String names = testDataBase.getAllName();
                Toast.makeText(MainActivity.this,names,Toast.LENGTH_LONG).show();
            }
        });

    }
}
