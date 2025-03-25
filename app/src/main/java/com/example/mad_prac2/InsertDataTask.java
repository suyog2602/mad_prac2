package com.example.mad_prac2;



import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

public class InsertDataTask extends AsyncTask<Void, Void, Long> {
    private Context context;
    private Databasehelper databaseHelper;
    private String name;
    private int age;

    public InsertDataTask(Context context, Databasehelper databaseHelper, String name, int age) {
        this.context = context;
        this.databaseHelper = databaseHelper;
        this.name = name;
        this.age = age;
    }

    @Override
    protected Long doInBackground(Void... voids) {
        return databaseHelper.insertStudent(name, age);
    }

    @Override
    protected void onPostExecute(Long result) {
        if (result == -1) {
            Toast.makeText(context, "Insertion Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
        }
    }
}

