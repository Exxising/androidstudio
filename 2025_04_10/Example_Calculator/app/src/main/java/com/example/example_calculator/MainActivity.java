package com.example.example_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    final int ADD = 0;
    final int SUB = 1;
    final int MTP = 2;
    final int DIV = 3;

    private int value1;
    private int value2;

    private Button[] operator;

    private EditText[] editTexts;
    private TextView result;

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

        // 연산자
        operator        = new Button[4];
        operator[ADD]   = findViewById(R.id.buttonAdd);
        operator[SUB]   = findViewById(R.id.buttonSub);
        operator[MTP]   = findViewById(R.id.buttonMultiple);
        operator[DIV]   = findViewById(R.id.buttonDivide);

        // 숫자 에딧텍스트
        editTexts       = new EditText[2];
        editTexts[0]    = findViewById(R.id.editTextValue1);
        editTexts[1]    = findViewById(R.id.editTextValue2);

        // 결과 텍스트창
        result          = findViewById(R.id.textViewResult);
    }

    public void CalculateAdd(View view)
    {
        value1 = Integer.parseInt(editTexts[0].getText().toString());
        value2 = Integer.parseInt(editTexts[1].getText().toString());

        int res = value1+value2;
        result.setText(Integer.toString(res));
    }

    public void CalculateSub(View view)
    {
        value1 = Integer.parseInt(editTexts[0].getText().toString());
        value2 = Integer.parseInt(editTexts[1].getText().toString());

        int res = value1-value2;
        result.setText(Integer.toString(res));
    }

    public void CalculateMultiple(View view)
    {
        value1 = Integer.parseInt(editTexts[0].getText().toString());
        value2 = Integer.parseInt(editTexts[1].getText().toString());

        int res = value1*value2;
        result.setText(Integer.toString(res));
    }

    public void CalculateDivide(View view)
    {
        value1 = Integer.parseInt(editTexts[0].getText().toString());
        value2 = Integer.parseInt(editTexts[1].getText().toString());

        float res = (float)value1/value2;
        result.setText(Float.toString(res));
    }
}