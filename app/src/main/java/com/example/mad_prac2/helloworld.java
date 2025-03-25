package com.example.mad_prac2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class helloworld extends AppCompatActivity {

    TextView textView;
    Button next_prac;

    private static final String tag="HElloWorldActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_helloworld);

        Log.d(tag,"onCreate:Activity is created");
        textView=findViewById(R.id.textView2);
        next_prac=findViewById(R.id.next_prac);
        textView.setText("Activity is created");

        next_prac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(helloworld.this, MainActivity3.class);
                startActivity(intent);
            }
        });



    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(tag,"onStart:Activity is started");
        textView.setText("Activity is started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(tag,"onResume:Activity is resumed");
        textView.setText("Activity is resume");
    }

    @Override
        protected void onPause(){
        super.onPause();
        Log.d(tag,"onPause:Activity is paused");
        textView.setText("Activity is paused");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d(tag,"onStop:Activity is stopped");
        textView.setText("Activity is stopped");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(tag,"onRestart:Activity is restarted");
        textView.setText("Activity is restart");
    }

    @Override
     protected void onDestroy(){
        super.onDestroy();
        Log.d(tag,"onDestroy:Activity is destroyed");
        textView.setText("Activity is destroyed");
    }


}