package com.example.mad_prac2;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivity2 extends AppCompatActivity {

    EditText selectdate, selecttime;
    Button set_date, set_time, nxt_prac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        selectdate = findViewById(R.id.selectdate);
        selecttime = findViewById(R.id.selecttime);
        set_date = findViewById(R.id.set_date);
        set_time = findViewById(R.id.set_time);
        nxt_prac = findViewById(R.id.nxt_prac);  // Fixed issue: used findViewById correctly

        set_date.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    MainActivity2.this,
                    (view, year1, month1, dayOfMonth) ->
                            selectdate.setText(dayOfMonth + "/" + (month1 + 1) + "/" + year1),
                    year, month, day
            );
            datePickerDialog.show();
        });

        set_time.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(
                    MainActivity2.this,
                    (view, hourOfDay, minute1) ->
                            selecttime.setText(hourOfDay + ":" + minute1),
                    hour, minute, true
            );
            timePickerDialog.show();
        });

        nxt_prac.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, helloworld.class);
            startActivity(intent);
        });


    }
}
