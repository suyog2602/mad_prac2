package com.example.mad_prac2;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4 extends AppCompatActivity {

    EditText ed1;
    Button insertbtn, fetchbtn,nextbtn;
    TextView view_msg;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        ed1 = findViewById(R.id.ed1);
        insertbtn = findViewById(R.id.insertbtn);
        fetchbtn = findViewById(R.id.fetchbtn);
        view_msg = findViewById(R.id.view_msg);

        nextbtn=findViewById(R.id.nextbtn);

        dbHelper = new DatabaseHelper(this);


        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity4.this,MainActivity5.class);
                startActivity(i);
            }
        });

        // Insert Button Click
        insertbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = ed1.getText().toString().trim();
                if (!data.isEmpty()) {
                    boolean isInserted = dbHelper.insertData(data);
                    if (isInserted) {
                        Toast.makeText(MainActivity4.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                        ed1.setText(""); // Clear input field
                    } else {
                        Toast.makeText(MainActivity4.this, "Insertion Failed", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity4.this, "Enter some data", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Fetch Button Click
        fetchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = dbHelper.getData();
                if (!data.isEmpty()) {
                    view_msg.setText(data);
                } else {
                    view_msg.setText("No data found");
                }
            }
        });
    }

    // SQLite Database Helper Class
    class DatabaseHelper extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "MyDatabase.db";
        private static final String TABLE_NAME = "UserData";
        private static final String COLUMN_ID = "ID";
        private static final String COLUMN_DATA = "Data";

        public DatabaseHelper(MainActivity4 context) {
            super(context, DATABASE_NAME, null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_DATA + " TEXT)";
            db.execSQL(createTable);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }

        // Insert Data
        public boolean insertData(String data) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(COLUMN_DATA, data);
            long result = db.insert(TABLE_NAME, null, values);
            return result != -1; // Returns true if insert was successful
        }

        // Fetch Data
        public String getData() {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
            StringBuilder sb = new StringBuilder();
            while (cursor.moveToNext()) {
                sb.append(cursor.getString(1)).append("\n"); // Column index 1 is 'Data'
            }
            cursor.close();
            return sb.toString();
        }
    }
}
