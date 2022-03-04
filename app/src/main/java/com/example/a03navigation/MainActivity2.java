package com.example.a03navigation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView textView;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView = findViewById(R.id.textView2);
        editText = findViewById(R.id.inputField2);
        button = findViewById(R.id.button2);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null && bundle.containsKey("inputField")) {
            String text = bundle.getString("inputField");
            textView.setText(text);
        }

        button.setOnClickListener(v -> {
            goBack();
        });
    }

    public void goBack() {
        Intent intent = new Intent();
        intent.putExtra("result", editText.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}