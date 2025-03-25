package com.example.mad_prac2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity16 extends AppCompatActivity {
    EditText src;
    EditText dest;
    Button next_pract;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main16);

        Button btnShowRoute = findViewById(R.id.btnShowRoute);
         src  =findViewById(R.id.src);
         dest=findViewById(R.id.dest);
         next_pract=findViewById(R.id.next_pract);

         next_pract.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {
                                               Intent i = new Intent(MainActivity16.this, MainActivity17.class);
                                               startActivity(i);
                                           }
                                       });

        btnShowRoute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRoute();
            }
        });
    }

    private void showRoute() {
        // Example: Route from Mumbai to Delhi
        String source = src.getText().toString();
        String destination = dest.getText().toString();
        // Open Google Maps with directions
        Uri gmmIntentUri = Uri.parse("https://www.google.com/maps/dir/?api=1&origin=" + source + "&destination=" + destination + "&travelmode=driving");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");

        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }
}
