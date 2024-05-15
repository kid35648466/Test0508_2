package com.example.test0508;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<StuData> stuDataList;
    private StuDataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvMyData);

        stuDataList = new ArrayList<>();

        List<StuData> stuDataList = new ArrayList<>();
        stuDataList.add(new StuData("https://png.pngtree.com/png-vector/20221222/ourmid/pngtree-super-cute-cartoon-vector-bear-png-image_6504049.png", "John", "180"));
        stuDataList.add(new StuData(R.drawable.logo, "Tom", "175"));
        stuDataList.add(new StuData(R.drawable.logo, "Jerry", "170"));
        stuDataList.add(new StuData(R.drawable.logo, "Mike", "165"));
        stuDataList.add(new StuData(R.drawable.logo, "Jack", "160"));
        stuDataList.add(new StuData(R.drawable.logo, "Rose", "155"));
        stuDataList.add(new StuData(R.drawable.logo, "Lily", "150"));
        stuDataList.add(new StuData(R.drawable.logo, "Lucy", "145"));
        stuDataList.add(new StuData(R.drawable.logo, "Linda", "140"));
        stuDataList.add(new StuData(R.drawable.logo, "Marry", "135"));
        adapter = new StuDataAdapter(stuDataList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public void addData(View view) {
        Intent intent = new Intent(this, AddDataActivity.class);
        startActivityForResult(intent, 1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            String name = data.getStringExtra("name");
            String height = data.getStringExtra("height");
            String url = data.getStringExtra("url");
            stuDataList.add(new StuData(url, name, height));
            adapter.notifyDataSetChanged();
        }
    }
}
