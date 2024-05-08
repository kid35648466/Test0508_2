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
        stuDataList.add(new StuData("1", "John", "180"));
        stuDataList.add(new StuData("2", "Tom", "175"));
        stuDataList.add(new StuData("3", "Jerry", "170"));
        stuDataList.add(new StuData("4", "Mike", "165"));
        stuDataList.add(new StuData("5", "Jack", "160"));
        stuDataList.add(new StuData("6", "Rose", "155"));
        stuDataList.add(new StuData("7", "Lily", "150"));
        stuDataList.add(new StuData("8", "Lucy", "145"));
        stuDataList.add(new StuData("9", "Linda", "140"));
        stuDataList.add(new StuData("10", "Marry", "135"));
        recyclerView.setAdapter(new StuDataAdapter(stuDataList));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}