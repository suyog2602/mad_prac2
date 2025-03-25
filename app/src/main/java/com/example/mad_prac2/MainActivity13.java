package com.example.mad_prac2;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity13 extends AppCompatActivity {

    EditText phoneNumber, message;
    Button sendSmsButton,nextpract;
    private static final int REQUEST_SMS_PERMISSION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main13);
        nextpract=findViewById(R.id.nextpract);
        phoneNumber = findViewById(R.id.phoneNumber);
        message = findViewById(R.id.smsMessage);
        sendSmsButton = findViewById(R.id.sendSmsButton);

        nextpract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity13.this,MainActivity14.class);
                startActivity(i);
            }
        });



        sendSmsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendSMS();
            }
        });

        // Request SMS Permission
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.SEND_SMS}, REQUEST_SMS_PERMISSION);
        }
    }

    private void sendSMS() {
        String phone = phoneNumber.getText().toString();
        String msg = message.getText().toString();

        if (phone.isEmpty() || msg.isEmpty()) {
            Toast.makeText(this, "Enter phone number and message", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phone, null, msg, null, null);
            Toast.makeText(this, "SMS Sent!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Failed to send SMS!", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}
