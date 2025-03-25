package com.example.onehour;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        img = findViewById(R.id.imageView);
        img.setImageResource(R.drawable.android);
    }

    int scaleTypeIdx = 0;
    public void ChangeScale(View view)
    {
        ImageView.ScaleType[] types =
                {
                        ImageView.ScaleType.CENTER,
                        ImageView.ScaleType.CENTER_CROP,
                        ImageView.ScaleType.CENTER_INSIDE,
                        ImageView.ScaleType.FIT_CENTER,
                        ImageView.ScaleType.FIT_XY
                };
        img.setScaleType(types[scaleTypeIdx++]);
        scaleTypeIdx = (scaleTypeIdx % types.length);
    }

    public void RotateImage(View view)
    {
        img.setRotation(img.getRotation() + 45f);
    }

    public void SetAlpha(View view)
    {
        float alpha = img.getAlpha();

        if(alpha == 1.0f)   alpha = 0.5f;
        else                alpha = 1.0f;

        img.setAlpha(alpha);
    }
}