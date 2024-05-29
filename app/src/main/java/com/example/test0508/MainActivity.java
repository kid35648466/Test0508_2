package com.example.test0508;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<StuData> stuDataList;
    private StuDataAdapter adapter;

    //建立一個 ActivityResultContract 可以接收 addDataActivity 的資料
    @SuppressLint("NotifyDataSetChanged")
    private ActivityResultLauncher<Intent> activityResultLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                Log.d("DDDDD", "onActivityResult: " + result.getResultCode());
                    if (result.getResultCode() == 200) {     //addDataActivity
                        Intent data = result.getData();
                        String name = data.getStringExtra("name");
                        String height = data.getStringExtra("height");
                        String url = data.getStringExtra("url");
                        Log.d("DDDDD", "name: " + name + " height: " + height + " url: " + url);
                        stuDataList.add(new StuData(url, name, height));
                        adapter.notifyDataSetChanged();
                        recyclerView.setAdapter(adapter);
                    }
                    if (result.getResultCode() == 100) {    //UpdateActivity
                        Intent data = result.getData();
                        String name = data.getStringExtra("name");
                        String height = data.getStringExtra("height");
                        String url = data.getStringExtra("url");
                        int position = data.getIntExtra("position", 0);
                        Log.d("DDDDD", "name: " + name + " height: " + height + " url: " + url);
                        stuDataList.set(position,new StuData(url, name, height));
                        adapter.notifyDataSetChanged();
                        recyclerView.setAdapter(adapter);
                    }
                    Log.d("DDDDD", "onActivityResult: " + stuDataList.size());

                });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvMyData);

        stuDataList = new ArrayList<>();

        List<StuData> stuDataList = new ArrayList<>();
        stuDataList.add(new StuData("https://i.pinimg.com/736x/17/73/dd/1773ddeae9660bd51e60240cb4fe3b9f.jpg", "Origami", "180"));
        stuDataList.add(new StuData("https://i.pinimg.com/736x/0e/c1/48/0ec148f4924d1631decda5608702bbbe.jpg", "Nia", "175"));
        stuDataList.add(new StuData("https://www.reddit.com/media?url=https%3A%2F%2Fi.redd.it%2Flvs8cyjsqpx61.jpg&rdt=60531", "Kurumi", "170"));
        stuDataList.add(new StuData("https://i.pinimg.com/736x/46/92/a7/4692a7c700903bc86f69b7ab735c843b.jpg", "Yoshino", "160"));
        stuDataList.add(new StuData("https://i.pinimg.com/236x/b0/18/20/b01820722d624554e220d9359b0c0f1a.jpg", "Mike", "165"));
        stuDataList.add(new StuData("https://www.cjcu.edu.tw/images/logo_story/logo-xl.jpg", "Rose", "155"));
        stuDataList.add(new StuData("https://www.cjcu.edu.tw/images/logo_story/logo-xl.jpg", "Lily", "150"));
        stuDataList.add(new StuData("https://www.cjcu.edu.tw/images/logo_story/logo-xl.jpg", "Lucy", "145"));
        stuDataList.add(new StuData("https://www.cjcu.edu.tw/images/logo_story/logo-xl.jpg", "Linda", "140"));
        stuDataList.add(new StuData("https://a.ppy.sh/13206763_1600386298.jpeg", "Tohka", "135"));
        adapter = new StuDataAdapter(stuDataList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter.setOnItemClickListener(new StuDataAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(MainActivity.this, UpdateActivity.class);
                StuData stuData = stuDataList.get(position);
                intent.putExtra("name", stuData.getName());
                intent.putExtra("height", stuData.getHeight());
                intent.putExtra("url", stuData.getImageUrl());
                intent.putExtra("position", position);
                Log.d("DDDDD", "onItemClick: " + position);
                Log.d("DDDDD", "onItemClick: " + stuDataList.size());
//                stuDataList.remove(position);
                Log.d("DDDDD", "onItemClick: " + stuDataList.size());
                activityResultLauncher.launch(intent);
            }
        });
    }

    public void addData(View view) {
        Intent intent = new Intent(this, AddDataActivity.class);
//        startActivityForResult(intent, 1);
        activityResultLauncher.launch(intent);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}