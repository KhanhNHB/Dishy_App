package com.example.dishy_app.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.dishy_app.DataNotification;
import com.example.dishy_app.R;
import com.example.dishy_app.adaptes.NotificationAdapter;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private NotificationAdapter notificationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
    }

    public void initView(){
        recyclerView = (RecyclerView) findViewById(R.id.recycler_history);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void initData(){
        ArrayList<DataNotification> dataNotifications = new ArrayList<>();
        dataNotifications.add(
                new DataNotification("https://images.pexels.com/photos/750073/pexels-photo-750073.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                        "25/9/2019 8:50:45","Không cần nồi tráng bánh vẫn có thể làm bánh cuốn đầy nhân bằng chaỏ chống dính"));
        dataNotifications.add(new DataNotification("https://images.pexels.com/photos/1860208/pexels-photo-1860208.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                "25/9/2019 8:50:45","Không cần nồi tráng bánh vẫn có thể làm bánh cuốn đầy nhân bằng chaỏ chống dính"));
        dataNotifications.add(new DataNotification("https://images.pexels.com/photos/406152/pexels-photo-406152.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                "25/9/2019 8:50:45","Không cần nồi tráng bánh vẫn có thể làm bánh cuốn đầy nhân bằng chaỏ chống dính"));
        dataNotifications.add(new DataNotification("https://images.pexels.com/photos/461326/pexels-photo-461326.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                "25/9/2019 8:50:45","Không cần nồi tráng bánh vẫn có thể làm bánh cuốn đầy nhân bằng chaỏ chống dính"));
        dataNotifications.add(new DataNotification("https://images.pexels.com/photos/2116094/pexels-photo-2116094.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                "25/9/2019 8:50:45","Không cần nồi tráng bánh vẫn có thể làm bánh cuốn đầy nhân bằng chaỏ chống dính"));
        dataNotifications.add(new DataNotification("https://images.pexels.com/photos/2116091/pexels-photo-2116091.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                "25/9/2019 8:50:45","Không cần nồi tráng bánh vẫn có thể làm bánh cuốn đầy nhân bằng chaỏ chống dính"));
        dataNotifications.add(new DataNotification("https://images.pexels.com/photos/1630309/pexels-photo-1630309.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                "25/9/2019 8:50:45","Không cần nồi tráng bánh vẫn có thể làm bánh cuốn đầy nhân bằng chaỏ chống dính"));
        dataNotifications.add(new DataNotification("https://images.pexels.com/photos/36768/food-salmon-teriyaki-cooking.jpg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                "25/9/2019 8:50:45","Không cần nồi tráng bánh vẫn có thể làm bánh cuốn đầy nhân bằng chaỏ chống dính"));
        updateRCV(dataNotifications);
    }

    private void updateRCV(ArrayList<DataNotification> notifications){
        if (notificationAdapter==null){
            notificationAdapter = new NotificationAdapter(notifications, getApplicationContext());
            recyclerView.setAdapter(notificationAdapter);
        }else{
            notificationAdapter.notifyDataSetChanged();
        }
    }
}
