package com.example.example_loginlayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText[]  editTexts;
    private Button[]    buttons;
    private TextView    render;
    private ImageView   imgView;
    final int ET_ID         = 0;
    final int ET_PW         = 1;

    final int BTN_LOGIN     = 0;
    final int BTN_REGISTER  = 1;

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

        editTexts   = new EditText[2];
        buttons     = new Button[2];

        editTexts[ET_ID]    = findViewById(R.id.editTextID);
        editTexts[ET_PW]    = findViewById(R.id.editTextPassword);

        render  = findViewById(R.id.textViewRender);

        imgView = findViewById(R.id.imageView);
        imgView.setImageResource(com.google.android.material.R.drawable.abc_ic_voice_search_api_material);
    }

    // 일단 둘 다 같은 기능으로 설정
    public void OnClickLogin(View view)
    {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<editTexts.length; ++i)
        {
            sb.append(editTexts[i].getText());
            sb.append("\n");
        }

        render.setText(sb.toString());
    }

    public void OnClickRegister(View view)
    {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<editTexts.length; ++i)
        {
            sb.append(editTexts[i].getText());
            sb.append("\n");
        }

        render.setText(sb.toString());
    }
}