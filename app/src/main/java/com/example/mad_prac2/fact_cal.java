    package com.example.mad_prac2;

    import android.content.Intent;
    import android.os.Bundle;
    import android.widget.Button;
    import android.widget.TextView;

    import androidx.activity.EdgeToEdge;
    import androidx.appcompat.app.AppCompatActivity;
    import androidx.core.graphics.Insets;
    import androidx.core.view.ViewCompat;
    import androidx.core.view.WindowInsetsCompat;

    public class fact_cal extends AppCompatActivity {
            TextView textView;
            Button next_prac;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_fact_cal);

            int fact_num=getIntent().getIntExtra("fact_num",0);
            textView=findViewById(R.id.display_fact);
            textView.setText(String.valueOf(fact_num));
            next_prac=findViewById(R.id.next_prac);
            int result=1;
            for(int i=1;i<=fact_num;i++){
                result=result*i;
            }


            textView.setText(String.valueOf(result));

            next_prac.setOnClickListener(v -> {
                Intent intent = new Intent(fact_cal.this, MainActivity4.class);
                startActivity(intent);
                    });

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }
    }