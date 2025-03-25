package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    private StringBuilder sbCalculator;

    private TextView tvExpressions;
    private TextView tvResult;

    private int[] values;

    private Stack<Character> operatorStack;
    private Stack<Integer> integerStack;

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

        // Initialize
        sbCalculator    = new StringBuilder();

        operatorStack   = new Stack<Character>();
        integerStack    = new Stack<Integer>();

        values          = new int[2];

        // TODO
        // Connect to text view
        tvExpressions   = findViewById(R.id.textViewExpressions);
        tvResult        = findViewById(R.id.textViewResult);
    }

    public void OnClickKeypad0(View view)
    {
        if(sbCalculator.length() <= 1) sbCalculator.append(0);
        else return;
        UpdateExpressions();
    }

    public void OnClickKeypad1(View view)
    {
        CheckIfFirstNumberIsZero();
        sbCalculator.append(1);
        UpdateExpressions();
    }

    public void OnClickKeypad2(View view)
    {
        CheckIfFirstNumberIsZero();
        sbCalculator.append(2);
        UpdateExpressions();
    }
    public void OnClickKeypad3(View view)
    {
        CheckIfFirstNumberIsZero();
        sbCalculator.append(3);
        UpdateExpressions();
    }

    public void OnClickKeypad4(View view)
    {
        CheckIfFirstNumberIsZero();
        sbCalculator.append(4);
        UpdateExpressions();
    }
    public void OnClickKeypad5(View view)
    {
        CheckIfFirstNumberIsZero();
        sbCalculator.append(5);
        UpdateExpressions();
    }

    public void OnClickKeypad6(View view)
    {
        CheckIfFirstNumberIsZero();
        sbCalculator.append(6);
        UpdateExpressions();
    }

    public void OnClickKeypad7(View view)
    {
        CheckIfFirstNumberIsZero();
        sbCalculator.append(7);
        UpdateExpressions();
    }

    public void OnClickKeypad8(View view)
    {
        CheckIfFirstNumberIsZero();
        sbCalculator.append(8);
        UpdateExpressions();
    }

    public void OnClickKeypad9(View view)
    {
        CheckIfFirstNumberIsZero();
        sbCalculator.append(9);
        UpdateExpressions();
    }

    private void CheckIfFirstNumberIsZero()
    {
        if(sbCalculator.length() == 1 && sbCalculator.toString().charAt(0) == '0')
        {
            sbCalculator.deleteCharAt(0);
        }
    }

    public void OnClickPlus(View view)
    {
        if(sbCalculator.length() == 0 || (sbCalculator.length() == 1 && sbCalculator.toString().charAt(0) == '0')) return;
        sbCalculator.append('+');
        UpdateExpressions();
    }

    public void OnClickMinus(View view)
    {
        if(sbCalculator.length() == 0 || (sbCalculator.length() == 1 && sbCalculator.toString().charAt(0) == '0')) return;
        sbCalculator.append('-');
        UpdateExpressions();
    }

    public void OnClickDivide(View view)
    {
        if(sbCalculator.length() == 0 || (sbCalculator.length() == 1 && sbCalculator.toString().charAt(0) == '0')) return;
        sbCalculator.append('/');
        UpdateExpressions();
    }

    public void OnClickMultiply(View view)
    {
        if(sbCalculator.length() == 0 || (sbCalculator.length() == 1 && sbCalculator.toString().charAt(0) == '0')) return;
        sbCalculator.append('*');
        UpdateExpressions();
    }

    private void UpdateExpressions()
    {
        tvExpressions.setText(sbCalculator.toString());
    }


    public void CalculateTest(View view)
    {

    }

    public void Calculate(View view)
    {
        StringBuilder sbInteger = new StringBuilder();

        char operator = '+';

        for(int i = 0; i<sbCalculator.length(); i++)
        {
            char currentChar = sbCalculator.charAt(i);

            if(sbInteger.length() >= 1)
            {
                if (currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/')
                {
                    integerStack.push(Integer.parseInt(sbInteger.toString()));
                    operator = currentChar;
                    // 초기화
                    sbInteger.delete(0, sbInteger.length());
                }
                else
                {
                    sbInteger.append(currentChar);
                }
            }
            else
            {
                sbInteger.append(currentChar);
            }

            if(i == sbCalculator.length() - 1)
            {
                integerStack.push(Integer.parseInt(sbInteger.toString()));
            }
        }

        for(int i = integerStack.size() - 1; i >= 0; --i)
        {
            values[i] = integerStack.pop();
        }

        int returnValue = 0;

        switch(operator)
        {
            case '+':
                returnValue = values[0] + values[1];
                break;
            case '-':
                returnValue = values[0] - values[1];
                break;
            case '*':
                returnValue = values[0] * values[1];
                break;
            case '/':
                returnValue = values[0] / values[1];
                break;
        }

        tvResult.setText("결과: " + returnValue);
    }

    public void OnClickClear(View view)
    {
        sbCalculator.delete(0, sbCalculator.length());
        tvResult.setText("");
        UpdateExpressions();
    }
}