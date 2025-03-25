package com.example.mad_prac2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity12 extends AppCompatActivity {
    private EditText username, password;
    private Button loginButton;
    private int loginAttempts = 0;
    private static final int MAX_ATTEMPTS = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateLogin();
            }
        });
    }

    private void validateLogin() {
        String user = username.getText().toString().trim();
        String pass = password.getText().toString().trim();

        if (user.isEmpty() || pass.isEmpty()) {
            Toast.makeText(this, "Fields cannot be empty!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (user.length() < 4) {
            Toast.makeText(this, "Username must be at least 4 characters!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (pass.length() < 6) {
            Toast.makeText(this, "Password must be at least 6 characters!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (user.equals("suyog") && pass.equals("123456")) {
            Intent intent = new Intent(MainActivity12.this, MainActivity13.class);
            startActivity(intent);
            Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show();
            loginAttempts = 0;  // Reset attempts after success
        } else {
            loginAttempts++;
            Toast.makeText(this, "Login Failed! Attempts: " + loginAttempts, Toast.LENGTH_SHORT).show();
            if (loginAttempts >= MAX_ATTEMPTS) {
                loginButton.setEnabled(false);
                Toast.makeText(this, "Too many failed attempts. Login Disabled!", Toast.LENGTH_LONG).show();
            }
        }
    }
}
