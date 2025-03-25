package com.example.mad_prac2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {
        Button btn_dial,btn_fact;
        EditText fact_input;
        String fact_str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        btn_dial=findViewById(R.id.btn_dial);
        btn_fact=findViewById(R.id.btn_fact);
        fact_input=findViewById(R.id.fact_num);



        btn_dial.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            startActivity(intent);
        });

        btn_fact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fact_str=fact_input.getText().toString();
                int fact_num=Integer.parseInt(fact_str);
                Intent i=new Intent(MainActivity3.this,fact_cal.class);
                i.putExtra("fact_num",fact_num);
                startActivity(i);
            }
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}