package com.example.test0508;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class UpdateActivity extends AppCompatActivity {
    private TextView addName;
    private TextView addHeight;
    private TextView addUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        addName = findViewById(R.id.edAddName);
        addHeight = findViewById(R.id.edAddHeight);
        addUrl = findViewById(R.id.edAddImgURL);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String height = intent.getStringExtra("height");
        String url = intent.getStringExtra("url");

        addName.setText(name);
        addHeight.setText(height);
        addUrl.setText(url);
    }
}
