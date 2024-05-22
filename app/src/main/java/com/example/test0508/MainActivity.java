package com.example.test0508;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<StuData> stuDataList;
    private StuDataAdapter adapter;

//建立一個ActivityRe
private  ActivityResultLauncher<Intent> activityResultLauncher =
                registerForActivityResult (new ActivityResultContracts.StartActivityForResult(),result-> {
                    if (result != null) {
                        Intent data = result.getData();
                        String name = data.getStringExtra("name");
                        String height = data.getStringExtra("height");
                        String url = data.getStringExtra("url");
                        stuDataList.add(new StuData(url, name, height));
                        adapter.notifyDataSetChanged();
                    }
                });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvMyData);

        stuDataList = new ArrayList<>();

        List<StuData> stuDataList = new ArrayList<>();
        stuDataList.add(new StuData("https://png.pngtree.com/png-vector/20221222/ourmid/pngtree-super-cute-cartoon-vector-bear-png-image_6504049.png", "John", "180"));
        stuDataList.add(new StuData("https://www.cjcu.edu.tw/images/logo_story/logo-xl.jpg", "Tom", "175"));
        stuDataList.add(new StuData("https://www.cjcu.edu.tw/images/logo_story/logo-xl.jpg", "Jerry", "170"));
        stuDataList.add(new StuData("https://www.cjcu.edu.tw/images/logo_story/logo-xl.jpg", "Mike", "165"));
        stuDataList.add(new StuData("https://www.cjcu.edu.tw/images/logo_story/logo-xl.jpg", "Jack", "160"));
        stuDataList.add(new StuData("https://www.cjcu.edu.tw/images/logo_story/logo-xl.jpg", "Rose", "155"));
        stuDataList.add(new StuData("https://www.cjcu.edu.tw/images/logo_story/logo-xl.jpg", "Lily", "150"));
        stuDataList.add(new StuData("https://www.cjcu.edu.tw/images/logo_story/logo-xl.jpg", "Lucy", "145"));
        stuDataList.add(new StuData("https://www.cjcu.edu.tw/images/logo_story/logo-xl.jpg", "Linda", "140"));
        stuDataList.add(new StuData("https://png.pngtree.com/png-vector/20221222/ourmid/pngtree-super-cute-cartoon-vector-bear-png-image_6504049.png", "Marry", "135"));
        adapter = new StuDataAdapter(stuDataList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public void addData(View view) {
        Intent intent = new Intent(this, AddDataActivity.class);
//        startActivityForResult(intent, 1);
        activityResultLauncher.launch(intent);
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
