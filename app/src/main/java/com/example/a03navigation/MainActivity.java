package com.example.a03navigation;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        editText = findViewById(R.id.inputField);
        textView = findViewById(R.id.textView1);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null && bundle.containsKey("result")) {
            String text = bundle.getString("result");
            textView.setText(text);
        }

        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result -> {
                    Intent intent = result.getData();
                    if (intent != null) {
                        intent.putExtra("textView", textView.getText().toString());
                        textView.setText(intent.getStringExtra("result"));
                    }
                    else
                        textView.setText("Jeg er null, miv");
                });

        button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("inputField", editText.getText().toString());
            activityResultLauncher.launch(intent);
        });

    }
}