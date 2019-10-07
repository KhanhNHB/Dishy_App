package com.example.dishy_app.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.dishy_app.DataNotification;
import com.example.dishy_app.R;
import com.example.dishy_app.adaptes.NotificationAdapter;

import java.util.ArrayList;

public class NotificationActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private NotificationAdapter notificationAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        initView();
        initData();
    }

    public void initView(){
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
//        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setLayoutManager(linearLayoutManager);

    }

    private void initData(){
        ArrayList<DataNotification> dataNotifications = new ArrayList<>();
        dataNotifications.add(
                new DataNotification("https://images.pexels.com/photos/1633578/pexels-photo-1633578.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                        "15/10/2019 8:50:45","Bữa sáng sẽ thật tuyệt vời và tràn đầy năng lượng với chiếc bánh burger với nhân thịt bò đậm đà quyến rũ cùng lớp phô mai béo ngậy, bên dưới là lớp rau xanh cùng cà chua mọng nước quyện với sốt mayonnaise và tương cà hấp dẫn"));
        dataNotifications.add(new DataNotification("https://images.pexels.com/photos/410648/pexels-photo-410648.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                "14/10/2019 9:50:45","Món sườn nướng luôn làm cho thực đơn cuối tuần hay các bữa tiệc ngoài trời trở nên hấp dẫn hơn bao giờ hết bởi hương vị đặc trưng cùng những bí quyết riêng mà chỉ những người đầu bếp khéo léo mới có được"));
        dataNotifications.add(new DataNotification("https://images.pexels.com/photos/1211887/pexels-photo-1211887.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                "13/10/2019 10:50:45","Salad Rau Trộn Sốt Mayonnaise - Món salad ngon, cực hấp dẫn tại nhà. Salad rau trộn có tác dụng chống lão hóa, đặc biệt có vị chua ngọt, hòa với vị béo của sốt mayonnaise và hương thơm của dầu mè nên đem lại khẩu vị cực ngon"));
        dataNotifications.add(new DataNotification("https://images.pexels.com/photos/2097090/pexels-photo-2097090.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                "12/10/2019 11:50:45","Sườn Xào Chua Ngọt - món ăn ngon dễ làm, giúp đổi vị cho bữa cơm gia đình. Cách làm sườn xào chua ngọt đơn giản, thơm ngon, thịt sườn xào chín dai béo, ngấm gia vị nêm nếm chua chua, mặn ngọt, đưa cơm cực kỳ"));
        dataNotifications.add(new DataNotification("https://images.pexels.com/photos/803290/pexels-photo-803290.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                "11/10/2019 12:50:45","Chiếc bánh pizza được nướng bằng chảo trông thật ngon mắt phải không bạn? Món bánh ăn ngon chẳng kém bánh được nướng bằng lò nướng đâu nhé!"));
        dataNotifications.add(new DataNotification("https://images.pexels.com/photos/803963/pexels-photo-803963.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                "10/10/2019 13:50:45","Mì Ý Tôm Sốt Kem Phô Mai là món ngon dễ làm cho gia đình ngày cuối tuần. Nếu chán ăn mì Ý sốt bò bằm cà chua (Bolognese) hay mì Ý sốt kem phô mai thịt xông khói (Carbonara) thì thử triển cách làm mì Ý sốt kem phô mai (Creamy shrimp pasta) đơn giản, cực hấp dẫn"));
        dataNotifications.add(new DataNotification("https://images.pexels.com/photos/416471/pexels-photo-416471.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                "9/10/2019 14:50:45","Thịt xông khói cuộn măng tây chiên với thịt xong khói được chiên chín, hơi vàng giòn, bao lấy măng tây ăn sần sật. Đây là món ăn rất kích thích vị giác và đưa cơm đấy!"));
        dataNotifications.add(new DataNotification("https://images.pexels.com/photos/725991/pexels-photo-725991.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                "8/10/2019 15:50:45","Cá nướng Tứ Xuyên tuy không phổ biến nhưng lại xuất phát và mang đặc trưng riêng của phố Trùng Khánh cũ, được xem là đặc sản của vùng đất này bởi sự dân dã và hương vị đặc biệt khó quên."));
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
