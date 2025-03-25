package com.example.mad_prac2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    CheckBox cb1, cb2, cb3;
    Button btn, btn2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        cb3 = findViewById(R.id.cb3);
        btn = findViewById(R.id.btn);
        btn2 = findViewById(R.id.btn2);

        // Button to navigate to MainActivity2
        btn2.setOnClickListener(v -> {
            Log.d("DEBUG", "Next button clicked");  // Debugging log
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
        });

        // Button to show order summary
        btn.setOnClickListener(v -> showOrderSummary());

        // Handling window insets for edge-to-edge layout
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void showOrderSummary() {
        int totalPrice = 0;
        StringBuilder orderSummary = new StringBuilder("Selected items:\n");

        if (cb1.isChecked()) {
            orderSummary.append("Pizza");
            totalPrice += 100;
        }
        if (cb2.isChecked()) {
            orderSummary.append("Coffee");
            totalPrice += 50;
        }
        if (cb3.isChecked()) {
            orderSummary.append("Burger");
            totalPrice += 120;
        }

        orderSummary.append("Total: ₹").append(totalPrice);
        Toast.makeText(this, orderSummary.toString(), Toast.LENGTH_SHORT).show();
    }
}
