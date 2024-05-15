 package com.example.test0508;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

 public class AddDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        TextView tvName = findViewById(R.id.edAddName);
        TextView tvHeight = findViewById(R.id.edAddHeight);
        TextView tvImageUrl = findViewById(R.id.edAddImageUrl);
    }
}