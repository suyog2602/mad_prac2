package com.example.mad_prac2;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.*;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity9 extends AppCompatActivity {

    private ImageView imageView;
    private boolean isRotated = false;
    private boolean isZoomed = false;
    private boolean isFaded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        imageView = findViewById(R.id.imageView);
        Button btnRotate = findViewById(R.id.btnRotate);
        Button btnZoom = findViewById(R.id.btnZoom);
        Button btnFade = findViewById(R.id.btnFade);
        Button btn5=findViewById(R.id.btn5);

        btn5.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity9.this,MainActivity10.class);
            startActivity(intent);
        });

        // Rotate Animation
        btnRotate.setOnClickListener(v -> {
            imageView.clearAnimation();
            float fromDegrees = isRotated ? 360f : 0f;
            float toDegrees = isRotated ? 0f : 360f;
            isRotated = !isRotated;

            RotateAnimation rotate = new RotateAnimation(fromDegrees, toDegrees,
                    Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            rotate.setDuration(1000);
            rotate.setInterpolator(new DecelerateInterpolator());
            rotate.setFillAfter(true);
            imageView.startAnimation(rotate);
        });

        // Zoom Animation
        btnZoom.setOnClickListener(v -> {
            imageView.clearAnimation();
            float fromScale = isZoomed ? 1.5f : 1f;
            float toScale = isZoomed ? 1f : 1.5f;
            isZoomed = !isZoomed;

            ScaleAnimation scale = new ScaleAnimation(fromScale, toScale, fromScale, toScale,
                    Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            scale.setDuration(1000);
            scale.setInterpolator(new AccelerateDecelerateInterpolator());
            scale.setFillAfter(true);
            imageView.startAnimation(scale);
        });

        // Fade Animation
        btnFade.setOnClickListener(v -> {
            imageView.clearAnimation();
            float fromAlpha = isFaded ? 0f : 1f;
            float toAlpha = isFaded ? 1f : 0f;
            isFaded = !isFaded;

            AlphaAnimation fade = new AlphaAnimation(fromAlpha, toAlpha);
            fade.setDuration(1000);
            fade.setInterpolator(new LinearInterpolator());
            fade.setFillAfter(true);
            imageView.startAnimation(fade);
        });
    }
}
