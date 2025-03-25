package com.example.dice;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView ivDice1;
    private ImageView ivDice2;

    private ImageView[] ivDices;

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

        ivDices = new ImageView[2];

        ivDices[0] = findViewById(R.id.imageViewDice1);
        ivDices[1] = findViewById(R.id.imageViewDice2);
    }

    public void OnClickRollDice(View view)
    {
        Random rand = new Random();

        for(int i = 0; i<2; i++)
        {
            int next = rand.nextInt(6);

            switch(next)
            {
                case 0:
                    ivDices[i].setImageResource(R.drawable.dice1);
                    break;
                case 1:
                    ivDices[i].setImageResource(R.drawable.dice2);
                    break;
                case 2:
                    ivDices[i].setImageResource(R.drawable.dice3);
                    break;
                case 3:
                    ivDices[i].setImageResource(R.drawable.dice4);
                    break;
                case 4:
                    ivDices[i].setImageResource(R.drawable.dice5);
                    break;
                case 5:
                    ivDices[i].setImageResource(R.drawable.dice6);
                    break;
            }
        }
    }
}