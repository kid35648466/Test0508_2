package com.example.test0508;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.rvMyData);

        List<StuData> stuDataList = new ArrayList<>();
        stuDataList.add(new StuData("https://png.pngtree.com/png-clipart/20210128/ourmid/pngtree-cute-villain-with-surprised-expression-png-image_2829431.jpg", "John", "180"));
        stuDataList.add(new StuData(R.drawable.logo, "Tom", "175"));
        stuDataList.add(new StuData(R.drawable.logo, "Jerry", "170"));
        stuDataList.add(new StuData(R.drawable.logo, "Mike", "165"));
        stuDataList.add(new StuData(R.drawable.logo, "Jack", "160"));
        stuDataList.add(new StuData(R.drawable.logo, "Rose", "155"));
        stuDataList.add(new StuData(R.drawable.logo, "Lily", "150"));
        stuDataList.add(new StuData(R.drawable.logo, "Lucy", "145"));
        stuDataList.add(new StuData(R.drawable.logo, "Linda", "140"));
        stuDataList.add(new StuData(R.drawable.logo, "Marry", "135"));
        recyclerView.setAdapter(new StuDataAdapter(stuDataList));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}