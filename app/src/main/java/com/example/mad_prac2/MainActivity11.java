package com.example.mad_prac2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity11 extends AppCompatActivity {
    EditText username;
    Button loginButton;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11); // ✅ Correct layout file

         username = findViewById(R.id.username);
         password = findViewById(R.id.password);
         loginButton = findViewById(R.id.loginButton);

        if (username == null || password == null || loginButton == null) {
            Log.e("ERROR", "One or more views are null! Check XML IDs.");
        }

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("suyog") && pass.equals("1234")) {
                    Intent intent = new Intent(MainActivity11.this, MainActivity12.class);
                    startActivity(intent);
                    Toast.makeText(MainActivity11.this, "Login Successful!", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(MainActivity11.this, "Login Failed! Try again.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

