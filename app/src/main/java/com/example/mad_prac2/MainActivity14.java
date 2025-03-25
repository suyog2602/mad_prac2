package com.example.mad_prac2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity14 extends AppCompatActivity {

    EditText emailAddress, emailSubject, emailMessage;
    Button sendEmailButton,next_pract;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main14);

        emailAddress = findViewById(R.id.emailAddress);
        emailSubject = findViewById(R.id.emailSubject);
        emailMessage = findViewById(R.id.emailMessage);
        sendEmailButton = findViewById(R.id.sendEmailButton);
        next_pract=findViewById(R.id.next_pract);

       next_pract.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             Intent i = new Intent(MainActivity14.this, MainActivity15.class);
                                             startActivity(i);
                                         }
                                     });


        sendEmailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });
    }

    private void sendEmail() {
        String recipient = emailAddress.getText().toString().trim();
        String subject = emailSubject.getText().toString().trim();
        String message = emailMessage.getText().toString().trim();

        if (recipient.isEmpty() || subject.isEmpty() || message.isEmpty()) {
            Toast.makeText(this, "Please fill all fields!", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:" + recipient));
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);

        try {
            startActivity(Intent.createChooser(intent, "Choose Email Client"));
        } catch (Exception e) {
            Toast.makeText(this, "No email app installed!", Toast.LENGTH_SHORT).show();
        }
    }
}
