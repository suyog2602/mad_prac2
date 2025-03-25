package com.example.mad_prac2;

import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity6 extends AppCompatActivity implements SensorEventListener {
        SensorManager sensorManager;
        Sensor acceroSensor;
        View mainlayout;
        Button nxt_prac;
    private static final float SHAKE_THRESHOLD = 12.0f; // Adjust sensitivity
    private long lastUpdate = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main6);


        nxt_prac=findViewById(R.id.nxt_prac);

        nxt_prac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity6.this,MainActivity7.class);
                startActivity(i);
            }
        });

        mainlayout = findViewById(R.id.main);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        if (sensorManager != null) {
            acceroSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        }

    }
    @Override
    protected void onResume(){
        super.onResume();
        if(acceroSensor!=null){
            sensorManager.registerListener( this,acceroSensor,SensorManager.SENSOR_DELAY_NORMAL);
        }

    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            float acceleration = (float) Math.sqrt(x * x + y * y + z * z);
            long currentTime = System.currentTimeMillis();

            if (acceleration > SHAKE_THRESHOLD) {
                if (currentTime - lastUpdate > 500) { // Prevents rapid color changes
                    lastUpdate = currentTime;
                    changeBackgroundColor();
                }
            }
        }
    }
    private void changeBackgroundColor() {
        Random random = new Random();
        int color = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        mainlayout.setBackgroundColor(color);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Not needed for this implementation
    }

}
