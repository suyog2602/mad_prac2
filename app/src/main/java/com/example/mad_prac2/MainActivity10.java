package com.example.mad_prac2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mad_prac2.Databasehelper;

public class MainActivity10 extends AppCompatActivity {

    private Databasehelper databaseHelper;
    private EditText etName, etAge;
    private Button btnInsert,btnnext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);

        databaseHelper = new Databasehelper(this);
        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        btnInsert = findViewById(R.id.btnInsert);
        btnnext=findViewById(R.id.btnnext);


        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity10.this,MainActivity11.class);
                startActivity(i);
            }
        });

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                int age = Integer.parseInt(etAge.getText().toString());

                // Call AsyncTask to insert data
                new InsertDataTask(MainActivity10.this, databaseHelper, name, age).execute();
            }
        });
    }
}
